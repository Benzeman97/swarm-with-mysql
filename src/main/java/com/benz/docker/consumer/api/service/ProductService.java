package com.benz.docker.consumer.api.service;

import com.benz.docker.consumer.api.model.Product;
import com.benz.docker.consumer.api.model.ProductList;

import java.util.List;

public interface ProductService {

    ProductList getProducts();
    Product findProduct(int prodId);
    Product saveProduct(Product product);
    Product updateProduct(int prodId,Product product);
    boolean deleteProduct(int prodId);
}
