package com.edheijer.SupplemantStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edheijer.SupplemantStore.models.Product;
import com.edheijer.SupplemantStore.repositories.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getProduct(Long id) {
		return productRepository.getOne(id);
	}
	
	public Product addProduct(Product Product) {
		return productRepository.saveAndFlush(Product);
	}
	
	public void updateProduct(Long id, Product Product) {
		productRepository.saveAndFlush(Product);
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
