package com.edheijer.SupplementStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edheijer.SupplementStore.models.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{

}
