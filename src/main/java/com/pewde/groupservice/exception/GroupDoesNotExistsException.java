package com.pewde.groupservice.exception;

public class GroupDoesNotExistsException extends BadRequestException{

    public GroupDoesNotExistsException(){
        super("Группы с таким уникальным идентификатором не существует");
    }

}
