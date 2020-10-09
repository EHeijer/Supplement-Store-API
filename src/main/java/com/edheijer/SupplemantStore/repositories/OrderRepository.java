package com.edheijer.SupplemantStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edheijer.SupplemantStore.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
