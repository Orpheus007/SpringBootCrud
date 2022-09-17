package com.orpheus.springbootcrud.repository;

import com.orpheus.springbootcrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ProductRepo extends JpaRepository<Product,Integer> {

    Product findByName(String name);
}
