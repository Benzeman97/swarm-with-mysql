package com.benz.docker.producer.api.controller;

import com.benz.docker.producer.api.entity.Product;
import com.benz.docker.producer.api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService=productService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Product>> getProducts()
    {
         return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> findProduct(@PathVariable("id") int prodId)
    {
        if(prodId!=0)
        return ResponseEntity.ok(productService.findProduct(prodId));
        else
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/save",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        if(product.getProdId()!=0 && !product.getProdName().trim().isEmpty() && product.getPrice()!=0.0)
         return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
        else
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/update/{prodId}",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> updateProduct(@PathVariable int prodId,@RequestBody Product product)
    {
        if(prodId!=0)
        return new ResponseEntity<>(productService.updateProduct(prodId,product),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int prodId)
    {
        if(prodId!=0)
            if(productService.deleteProduct(prodId)) {
                return new ResponseEntity(HttpStatus.OK);
            }
        throw new IllegalArgumentException();
    }
}
