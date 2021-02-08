package com.benz.docker.consumer.api.service;

import com.benz.docker.consumer.api.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    Product findProduct(int prodId);
    Product saveProduct(Product product);
    Product updateProduct(int prodId,Product product);
    boolean deleteProduct(int prodId);
}
