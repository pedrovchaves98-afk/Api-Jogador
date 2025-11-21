package com.pedro.api_teste.exception;

public class JogadorResourceException extends Exception {

    public JogadorResourceException() {
    }

    public JogadorResourceException(String message) {
        super(message);
    }

    public JogadorResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public JogadorResourceException(Throwable cause) {
        super(cause);
    }

    public JogadorResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
