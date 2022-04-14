package com.dwill.gamestore.controller.user;

import com.dwill.gamestore.registration.RegistrationRequest;
import com.dwill.gamestore.service.user.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users/registration")
@AllArgsConstructor
public class
RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request, @RequestParam("role") String role) {
        return registrationService.register(request, role);
    }

    @GetMapping(path = "confirm")
    public String confirm (@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
