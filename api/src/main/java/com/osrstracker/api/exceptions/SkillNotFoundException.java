package com.osrstracker.api.exceptions;


public class SkillNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public SkillNotFoundException(String message){
        super(message);
    }
    
}
