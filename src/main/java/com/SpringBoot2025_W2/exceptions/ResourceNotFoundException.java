package com.SpringBoot2025_W2.exceptions;

public class ResourceNotFoundException extends RuntimeException
{

    public ResourceNotFoundException(String message)
    {
    super(message);
    }
}
