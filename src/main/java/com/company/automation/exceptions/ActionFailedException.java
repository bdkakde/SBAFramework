package com.company.automation.exceptions;

public class ActionFailedException extends RuntimeException {

    public ActionFailedException(String message) {
        super(message);
    }

    public ActionFailedException(String message, Exception ex) {
        super(message, ex);
    }
}
