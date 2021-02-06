package com.benz.docker.producer.api.model;

import com.benz.docker.producer.api.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductList {

    private List<Product> productList;
}
