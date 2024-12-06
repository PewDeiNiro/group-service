package com.pewde.groupservice.exception;

public class InvalidTokenException extends UnauthorizedException{

    public InvalidTokenException(){
        super("Неправильный токен пользователя");
    }

}
