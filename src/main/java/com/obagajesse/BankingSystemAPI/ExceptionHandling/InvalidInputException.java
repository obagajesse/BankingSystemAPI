package com.obagajesse.BankingSystemAPI.ExceptionHandling;

public class InvalidInputException extends RuntimeException{

    public InvalidInputException(String message){
        super(message);
    }
}
