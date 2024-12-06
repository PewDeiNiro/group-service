package com.pewde.groupservice.exception;

public class TokenExpiredException extends UnauthorizedException{

    public TokenExpiredException() {
        super("Срок действия токена пользователя истек");
    }

}
