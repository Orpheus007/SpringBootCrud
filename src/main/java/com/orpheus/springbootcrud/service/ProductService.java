package com.orpheus.springbootcrud.service;

import com.orpheus.springbootcrud.entity.Product;
import com.orpheus.springbootcrud.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repository;


    public Product saveProduct(Product product) {
       return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> listOfProducts) {
        return repository.saveAll(listOfProducts);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "Product remove with id " +id;
    }

    public Product updateProduct(Product product) {
        Product dbProduct = repository.findById(product.getId()).orElse(null);
        assert dbProduct != null;
        dbProduct.setName(product.getName());
        dbProduct.setQuantity(product.getQuantity());
        dbProduct.setPrice(product.getPrice());
        return repository.save(dbProduct);
    }

    @Async
    public CompletableFuture<List<Product>> getProductsAsync() {
        List<Product> products = repository.findAll();
        return CompletableFuture.completedFuture(products);
    }
}
