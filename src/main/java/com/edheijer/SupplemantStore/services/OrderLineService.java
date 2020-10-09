package com.edheijer.SupplemantStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edheijer.SupplemantStore.models.OrderLine;
import com.edheijer.SupplemantStore.repositories.OrderLineRepository;

@Service
public class OrderLineService {

	@Autowired
	private OrderLineRepository orderLineRepository;
	
	public List<OrderLine> getAllOrderLines() {
		return orderLineRepository.findAll();
	}
	
	public OrderLine getOrderLine(Long id) {
		return orderLineRepository.getOne(id);
	}
	
	public OrderLine addOrderLine(OrderLine OrderLine) {
		return orderLineRepository.saveAndFlush(OrderLine);
	}
	
	public void updateOrderLine(Long id, OrderLine OrderLine) {
		orderLineRepository.saveAndFlush(OrderLine);
	}
	
	public void deleteOrderLine(Long id) {
		orderLineRepository.deleteById(id);
	}
}
