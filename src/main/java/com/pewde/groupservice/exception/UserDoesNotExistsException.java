package com.pewde.groupservice.exception;

public class UserDoesNotExistsException extends BadRequestException{

    public UserDoesNotExistsException(){
        super("Пользователя с таким именем не существует");
    }

}
