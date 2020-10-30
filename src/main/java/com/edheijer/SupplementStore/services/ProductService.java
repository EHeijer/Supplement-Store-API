package com.edheijer.SupplementStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edheijer.SupplementStore.models.OrderLine;
import com.edheijer.SupplementStore.models.Product;
import com.edheijer.SupplementStore.repositories.ProductRepository;


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
