package com.github.bensmith87.rnp;

class OperationFailedException extends Exception {

    OperationFailedException(String message, Exception e) {
        super(message, e);
    }
}
