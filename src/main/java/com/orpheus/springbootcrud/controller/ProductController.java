package com.orpheus.springbootcrud.controller;

import com.orpheus.springbootcrud.entity.Product;
import com.orpheus.springbootcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

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
        return service.deleteProduct(id);
    }
}
