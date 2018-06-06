package com.github.bensmith87.rpn;

class OperationFailedException extends Exception {

    OperationFailedException(String message, Exception e) {
        super(message, e);
    }
}
