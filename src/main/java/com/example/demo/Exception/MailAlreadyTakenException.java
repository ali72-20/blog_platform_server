package com.example.demo.Exception;

public class MailAlreadyTakenException extends RuntimeException{
   public MailAlreadyTakenException(String message){
       super(message);
    }
}
