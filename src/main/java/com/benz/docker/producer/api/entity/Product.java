package com.benz.docker.producer.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product",schema = "HR")
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "prod_id")
    private int prodId;
    @Column(name = "prod_name")
    private String prodName;
    @Column(name = "units")
    private Integer units;
    @Column(name = "price")
    private Double price;
}
