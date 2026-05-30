package com.example.user_service.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){}

    public ResourceNotFoundException(String msg){ super(msg); }
}
