package com.dwill.gamestore.model.user;

import lombok.Getter;

@Getter
public enum UserPermission {
    USER_VIEW("user:view"),
    USER_BUY("user:buy"),
    GAME_DELETE("game:delete"),
    GAME_ADD("game:add");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }


}
