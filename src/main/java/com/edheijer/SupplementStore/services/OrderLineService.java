package com.edheijer.SupplementStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edheijer.SupplementStore.models.OrderLine;
import com.edheijer.SupplementStore.repositories.OrderLineRepository;

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
	
	public OrderLine addOrderLine(OrderLine orderLine) {
		return orderLineRepository.saveAndFlush(orderLine);
	}
	
	public void updateOrderLine(OrderLine orderLine) {
		orderLineRepository.saveAndFlush(orderLine);
	}
	
	public void deleteOrderLine(Long id) {
		orderLineRepository.deleteById(id);
	}
}
