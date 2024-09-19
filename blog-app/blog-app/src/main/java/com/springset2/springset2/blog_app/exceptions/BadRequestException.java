package com.springset2.springset2.blog_app.exceptions;

import lombok.Data;


@Data

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message){
     super(message);



    }
}
