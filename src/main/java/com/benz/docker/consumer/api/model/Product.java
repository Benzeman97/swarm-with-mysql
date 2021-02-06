package com.benz.docker.consumer.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    private int prodId;
    private String prodName;
    private int units;
    private double price;
}
