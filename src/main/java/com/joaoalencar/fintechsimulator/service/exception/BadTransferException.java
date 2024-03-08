package com.joaoalencar.fintechsimulator.service.exception;

public class BadTransferException extends RuntimeException {

    public BadTransferException() {
        super();
    }

    public BadTransferException(String message) {
        super(message);
    }

    public BadTransferException(String message, Throwable cause) {
        super(message, cause);
    }
}
