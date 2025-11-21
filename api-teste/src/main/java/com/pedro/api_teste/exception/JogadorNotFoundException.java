package com.pedro.api_teste.exception;

public class JogadorNotFoundException extends Exception{
    public JogadorNotFoundException() {
    }

    public JogadorNotFoundException(String message) {
        super(message);
    }

    public JogadorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public JogadorNotFoundException(Throwable cause) {
        super(cause);
    }

    public JogadorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
