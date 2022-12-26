package com.example.springLab4.restсontoller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MenuItemNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MenuItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String menuItemNotFoundHandler(MenuItemNotFoundException ex) {
        return ex.getMessage();
    }
}
