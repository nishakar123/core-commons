package com.nishakar.commons.exception;

public class TokenGenerationFailedException extends RuntimeException{
    public TokenGenerationFailedException(String msg){
        super(msg);
    }
}
