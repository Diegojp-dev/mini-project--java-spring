package com.example.aulaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aulaspring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
