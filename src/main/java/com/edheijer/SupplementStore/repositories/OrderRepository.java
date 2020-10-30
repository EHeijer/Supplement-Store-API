package com.edheijer.SupplementStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edheijer.SupplementStore.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
