package com.dwill.gamestore.controller.user;

import com.dwill.gamestore.model.game.Game;
import com.dwill.gamestore.model.user.AppUser;
import com.dwill.gamestore.security.AuthenticationBean;
import com.dwill.gamestore.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@AllArgsConstructor
@RequestMapping(path = "/login")
public class LoginController {

    UserService userService;

    @GetMapping(path = "/")
    public AuthenticationBean login() {
        return new AuthenticationBean("You are authenticated");
    }

    @GetMapping(path = "/user")
    public ResponseEntity<AppUser> getAuthenticatedUser(@RequestParam("email") String email) {
        AppUser user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
