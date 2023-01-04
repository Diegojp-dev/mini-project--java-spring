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

import com.example.aulaspring.entities.Category;
import com.example.aulaspring.repository.CategoryRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryRepository repository;
	
	@PostMapping
	public ResponseEntity<Category> insert(@RequestBody Category category){
		category = repository.save(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(category.getId()).toUri();
		return ResponseEntity.created(uri).body(category);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category category = repository.findById(id).get();
		return ResponseEntity.ok().body(category);
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> categories = repository.findAll();
		return ResponseEntity.ok().body(categories);
	}
	
}
