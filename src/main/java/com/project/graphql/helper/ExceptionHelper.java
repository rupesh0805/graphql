package com.project.graphql.helper;

public class ExceptionHelper {

    public static RuntimeException throwResourceNotFoundException(){
        return new RuntimeException("Resource not found!");
    }
}
