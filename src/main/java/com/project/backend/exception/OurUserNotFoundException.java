package com.project.backend.exception;

public class OurUserNotFoundException extends RuntimeException {

    public OurUserNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}