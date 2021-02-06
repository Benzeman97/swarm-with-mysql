package com.benz.docker.producer.api.db;

import com.benz.docker.producer.api.entity.Product;
import com.benz.docker.producer.api.exception.DataNotFoundException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Database {

    final private static Map<Integer, Product> products;

    static {
        products=new ConcurrentHashMap<>();
        products.put(1001,new Product(1001,"Nafaz Benzema",25,3000.0));
        products.put(1002,new Product(1002,"Kelly Brook",50,2500.0));
    }

    public static Optional<List<Product>> getProducts()
    {
        return Optional.of(new ArrayList<>(products.values()));
    }

    public static Optional<Product> findProduct(int productId)
    {
         return Optional.of(products.get(productId));
    }

    public static Product saveProduct(Product product)
    {
        return products.put(product.getProdId(),product);
    }

    public static Optional<Product> updateProduct(int productId,Product product)
    {
         Product prod = products.get(productId);
         if(Objects.isNull(prod))
             throw new DataNotFoundException(String.format("Product is not found with %d",productId));
         prod.setProdName(product.getProdName());
         prod.setUnits(product.getUnits());
         prod.setPrice(product.getPrice());
         return Optional.of(products.put(productId,product));
    }

    public static boolean delete(int productId)
    {
        Product prod = products.get(productId);
        if(Objects.isNull(prod))
            throw new DataNotFoundException(String.format("Product is not found with %d",productId));
        return products.remove(productId,prod);
    }
}
