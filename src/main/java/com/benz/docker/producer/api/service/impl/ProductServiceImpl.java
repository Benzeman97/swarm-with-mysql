package com.benz.docker.producer.api.service.impl;

import com.benz.docker.producer.api.db.Database;
import com.benz.docker.producer.api.entity.Product;
import com.benz.docker.producer.api.exception.DataNotFoundException;
import com.benz.docker.producer.api.model.ProductList;
import com.benz.docker.producer.api.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public ProductList getProducts() {
        List<Product> products=Database.getProducts().orElseThrow(()->new DataNotFoundException("No Products available in the DB"));
        ProductList productList =new ProductList();
        productList.setProductList(products);
        return productList;
    }

    @Override
    public Product findProduct(int prodId) {
        return Database.findProduct(prodId)
                .orElseThrow(()->new DataNotFoundException(String.format("Product is not found with %d",prodId)));
    }

    @Override
    public Product saveProduct(Product product) {
        return Database.saveProduct(product);
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        return Database.updateProduct(productId,product)
                .orElseThrow(()->new DataNotFoundException(String.format("Product is not found with %d",productId)));
    }

    @Override
    public boolean deleteProduct(int prodId) {
        return Database.delete(prodId);
    }
}
