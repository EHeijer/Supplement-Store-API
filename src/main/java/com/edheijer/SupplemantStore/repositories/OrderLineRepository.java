package com.edheijer.SupplemantStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edheijer.SupplemantStore.models.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{

}
