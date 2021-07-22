package com.dwill.gamestore.exception;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(String s) {
        super(s);
    }
}
