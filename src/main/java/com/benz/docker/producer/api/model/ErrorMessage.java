package com.benz.docker.producer.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorMessage {

    private int errorCode;
    private String errorMsg;
    private String documentation;
}
