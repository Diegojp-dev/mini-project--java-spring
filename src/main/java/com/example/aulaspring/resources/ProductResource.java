package com.example.aulaspring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.aulaspring.entities.Product;
import com.example.aulaspring.repository.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductRepository repository;
	
	@PostMapping
	public ResponseEntity<Product>insert(@RequestBody Product product){
		product = repository.save(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(product);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product>findyById(@PathVariable Long id){
		Product product = repository.findById(id).get();
		return ResponseEntity.ok().body(product);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> products = repository.findAll();
		return ResponseEntity.ok().body(products);
	}
	
	
}
