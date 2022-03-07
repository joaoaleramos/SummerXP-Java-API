package com.products.api.productsapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.products.api.productsapi.model.Product;
import com.products.api.productsapi.repository.ProductRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAlProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(UUID id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(UUID id, Product product) {
        Product actualProduct = productRepository.getById(id);
        BeanUtils.copyProperties(product, actualProduct, "id");
        return productRepository.save(actualProduct);
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

}
