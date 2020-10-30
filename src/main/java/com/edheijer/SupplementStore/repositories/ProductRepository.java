package com.edheijer.SupplementStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edheijer.SupplementStore.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
