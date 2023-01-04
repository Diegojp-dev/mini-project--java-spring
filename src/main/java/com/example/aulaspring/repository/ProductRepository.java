package com.example.aulaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aulaspring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
