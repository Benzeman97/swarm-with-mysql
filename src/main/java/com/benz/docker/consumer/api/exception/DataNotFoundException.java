package com.benz.docker.consumer.api.exception;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(String msg)
    {
        super(msg);
    }

}
