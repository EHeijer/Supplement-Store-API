package com.edheijer.SupplemantStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edheijer.SupplemantStore.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
