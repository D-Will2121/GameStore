package com.dwill.gamestore.controller.user;

import com.dwill.gamestore.model.user.AppUser;
import com.dwill.gamestore.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class LoginController {

    UserService userService;

    @PostMapping("/login")
    public AppUser loginUser(@RequestBody AppUser user) throws Exception {
        String tempEmail = user.getEmail();
        String tempPass = user.getPassword();
        AppUser userObj = null;
        if (tempEmail != null && tempPass != null) {
            userObj = userService.getUserByEmailAndPassword(tempEmail, tempPass);
        }
        if (userObj == null) {
            throw new Exception(String.format("Email %s and Password %s are wrong", tempEmail, tempPass));
        }
        return userObj;
    }
}
