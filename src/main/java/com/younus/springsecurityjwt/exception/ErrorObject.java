package com.younus.springsecurityjwt.exception;

import lombok.Data;

@Data
public class ErrorObject {
    private String message;
    private int statusCode;
}
