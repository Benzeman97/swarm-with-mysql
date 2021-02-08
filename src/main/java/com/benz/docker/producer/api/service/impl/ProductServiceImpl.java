package com.benz.docker.producer.api.service.impl;

import com.benz.docker.producer.api.dao.ProductDAO;
import com.benz.docker.producer.api.entity.Product;
import com.benz.docker.producer.api.exception.DataNotFoundException;
import com.benz.docker.producer.api.model.ProductList;
import com.benz.docker.producer.api.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO)
    {
        this.productDAO=productDAO;
    }

    @Override
    public ProductList getProducts() {

        List<Product> products=productDAO.getProducts().orElseThrow(()->new DataNotFoundException("No Products available in the DB"));
        ProductList productList =new ProductList();
        productList.setProductList(products);
        return productList;
    }

    @Override
    public Product findProduct(int prodId) {
      return  productDAO.findById(prodId)
                .orElseThrow(()->new DataNotFoundException(String.format("Product is not found with %d",prodId)));
    }

    @Override
    public Product saveProduct(Product product) {
       return productDAO.save(product);
    }

    @Override
    public Product updateProduct(int productId, Product product) {

        Product prod=productDAO.findById(productId)
                .orElseThrow(()->new DataNotFoundException(String.format("Product is not found with %d",productId)));
        prod.setProdName(product.getProdName());
        prod.setUnits(product.getUnits());
        prod.setPrice(product.getPrice());

        if(Objects.isNull(prod))
            throw new DataNotFoundException(String.format("Product is not found with %d",productId));
        return productDAO.save(prod);

    }

    @Override
    public boolean deleteProduct(int prodId) {

        Product prod=productDAO.findById(prodId)
                .orElseThrow(()->new DataNotFoundException(String.format("Product is not found with %d",prodId)));
        if(Objects.isNull(prod))
            throw new  DataNotFoundException(String.format("Product is not found with %d",prodId));
        productDAO.delete(prod);
        return true;

    }
}
