package com.dwill.gamestore.service.user;

import com.dwill.gamestore.registration.EmailSender;
import com.dwill.gamestore.model.user.AppUser;
import com.dwill.gamestore.model.user.ConfirmationToken;
import com.dwill.gamestore.model.user.UserRole;
import com.dwill.gamestore.registration.EmailValidator;
import com.dwill.gamestore.registration.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    public String register(RegistrationRequest request, String role) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        String token = "";
        if (role.equals("user"))
        {
            token = userService.signUpUser(
                    new AppUser(
                            request.getName(),
                            request.getEmail(),
                            request.getPassword(),
                            request.getCash(),
                            UserRole.USER
                    )
            );
        }
        else if (role.equals("admin"))
        {
            token = userService.signUpUser(
                    new AppUser(
                            request.getName(),
                            request.getEmail(),
                            request.getPassword(),
                            request.getCash(),
                            UserRole.ADMIN
                    )
            );
        }

        String link = "http://Localhost:8080/users/registration/confirm?token=" + token;
        emailSender.send(request.getEmail(), userService.buildEmail(request.getName(), link));
        return token;

        }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }


}
