package com.benz.docker.producer.api.dao;

import com.benz.docker.producer.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDAO extends JpaRepository<Product,Integer> {

    @Query("from Product")
    Optional<List<Product>> getProducts();

}
