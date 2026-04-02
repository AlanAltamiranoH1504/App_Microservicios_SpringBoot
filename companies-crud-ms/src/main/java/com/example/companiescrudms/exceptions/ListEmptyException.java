package com.example.companiescrudms.exceptions;

public class ListEmptyException extends RuntimeException {
    public ListEmptyException(String message) {
        super(message);
    }
}
