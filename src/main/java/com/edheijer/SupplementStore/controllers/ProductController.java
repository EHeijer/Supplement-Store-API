package com.edheijer.SupplementStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edheijer.SupplementStore.models.Product;
import com.edheijer.SupplementStore.services.ProductService;

import lombok.Setter;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping(path = "/products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping(path = "/products/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return productService.getProduct(Integer.toUnsignedLong(id));
	}
	
	
	
	@PostMapping(path = "/products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@PutMapping(path = "/products/{id}")
	public void updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		productService.updateProduct(Integer.toUnsignedLong(id), product);
	}
	
	@DeleteMapping(path = "/products/{id}")
	public void removeProductById(@PathVariable("id") int id) {
		productService.deleteProduct(Integer.toUnsignedLong(id));
	}
}
