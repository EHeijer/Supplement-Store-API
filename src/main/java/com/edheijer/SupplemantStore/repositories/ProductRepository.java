package com.edheijer.SupplemantStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edheijer.SupplemantStore.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
