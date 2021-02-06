package com.benz.docker.producer.api.service;

import com.benz.docker.producer.api.entity.Product;
import com.benz.docker.producer.api.model.ProductList;

import java.util.List;

public interface ProductService {

    ProductList getProducts();
    Product findProduct(int prodId);
    Product saveProduct(Product product);
    Product updateProduct(int productId,Product product);
    boolean deleteProduct(int prodId);
}
