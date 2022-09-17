package com.orpheus.springbootcrud.controller;

import com.orpheus.springbootcrud.entity.Product;
import com.orpheus.springbootcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> productList) {
        return service.saveProducts(productList);
    }

    @GetMapping("/findAllProducts")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/findProductById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/findProductByName/{name}")
    public Product findProductByName(@PathVariable String  name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }
    @DeleteMapping("/delete")
    public String deleteProduct(@PathVariable int id) {
        CompletableFuture<List<Product>> thread1 = service.getProductsAsync();
        CompletableFuture<List<Product>> thread2 = service.getProductsAsync();
        CompletableFuture<List<Product>> thread3 = service.getProductsAsync();

        CompletableFuture.allOf(thread1,thread2,thread3).join();

        return service.deleteProduct(id);
    }
}
