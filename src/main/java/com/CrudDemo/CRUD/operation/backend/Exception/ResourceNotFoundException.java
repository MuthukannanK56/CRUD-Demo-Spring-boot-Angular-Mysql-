package com.CrudDemo.CRUD.operation.backend.Exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String message){
        super(message);
    }
}
