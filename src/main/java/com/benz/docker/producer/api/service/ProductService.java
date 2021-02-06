package com.benz.docker.producer.api.service;

import com.benz.docker.producer.api.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    Product findProduct(int prodId);
    Product saveProduct(Product product);
    Product updateProduct(int productId,Product product);
    boolean deleteProduct(int prodId);
}
