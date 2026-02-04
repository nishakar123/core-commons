package com.nishakar.commons.exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String message){
        super(message);
    }
}
