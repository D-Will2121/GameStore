package com.dwill.gamestore.model.user;

import com.google.common.collect.Sets;
import lombok.Getter;

import java.io.Serializable;
import java.util.Set;

import static com.dwill.gamestore.model.user.UserPermission.*;
@Getter
public enum UserRole {
    USER(Sets.newHashSet(USER_BUY, USER_VIEW)),
    ADMIN(Sets.newHashSet(GAME_ADD, GAME_DELETE, USER_BUY, USER_VIEW));

    public String getUserRole() {
        return this.name();
    }

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

}
