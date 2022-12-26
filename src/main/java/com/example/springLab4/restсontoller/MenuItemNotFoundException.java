package com.example.springLab4.restсontoller;

public class MenuItemNotFoundException extends RuntimeException{
    MenuItemNotFoundException(Long id){
        super("Could not find the item with id " + id);
    }
}
