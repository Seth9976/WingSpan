package com.yahoo.memory;

public class ReadOnlyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ReadOnlyException(String message) {
        super(message);
    }
}

