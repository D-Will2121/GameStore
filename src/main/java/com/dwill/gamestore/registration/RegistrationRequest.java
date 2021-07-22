package com.dwill.gamestore.registration;

import com.dwill.gamestore.model.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String name;
    private final String email;
    private final String password;
    private final Float cash;
    private final UserRole userRole;

}
