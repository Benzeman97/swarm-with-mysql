package com.benz.docker.consumer.api.service.impl;

import com.benz.docker.consumer.api.exception.DataNotFoundException;
import com.benz.docker.consumer.api.model.Product;
import com.benz.docker.consumer.api.model.ProductList;
import com.benz.docker.consumer.api.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {


    private WebClient.Builder webClient;

    @Value("${producer.uri}")
    private String url;

    public ProductServiceImpl(WebClient.Builder webClient)
    {
        this.webClient=webClient;
    }

    @Override
    public List<Product> getProducts() {
        return webClient.build().get().uri(url)
                .retrieve().bodyToMono(ProductList.class).block().getProductList();
    }

    @Override
    public Product findProduct(int prodId) {
        Product product= webClient.build().get().uri(url+"/"+prodId).header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve().bodyToMono(Product.class).block();

          if(Objects.isNull(product))
              throw new DataNotFoundException(String.format("Product is not found with %d",prodId));
          return product;
    }

    @Override
    public Product saveProduct(Product product) {
        return webClient.build().post().uri(url+"/save").header(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(product),Product.class)
                .retrieve().bodyToMono(Product.class).block();
    }

    @Override
    public Product updateProduct(int prodId, Product product) {
        Product prod = webClient.build().put().uri(url+"/update/"+prodId).header(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(product),Product.class)
                .retrieve().bodyToMono(Product.class).block();

        if(Objects.isNull(prod))
            throw new DataNotFoundException(String.format("Product is not found with %d",prodId));
        return prod;

    }

    @Override
    public boolean deleteProduct(int prodId) {
        try {
            webClient.build().delete().uri(url+"/delete/"+prodId)
                    .retrieve().bodyToMono(Void.class).block();
            return true;
        }catch (Exception ex)
        {
           return false;
        }

    }
}
