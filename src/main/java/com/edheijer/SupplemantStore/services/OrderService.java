package com.edheijer.SupplemantStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edheijer.SupplemantStore.models.Order;
import com.edheijer.SupplemantStore.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	public Order getOrder(Long id) {
		return orderRepository.getOne(id);
	}
	
	public Order addOrder(Order Order) {
		return orderRepository.saveAndFlush(Order);
	}
	
	public void updateOrder(Long id, Order Order) {
		orderRepository.saveAndFlush(Order);
	}
	
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}
}
