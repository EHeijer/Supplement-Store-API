package com.edheijer.SupplementStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edheijer.SupplementStore.models.Order;
import com.edheijer.SupplementStore.services.OrderService;
import com.edheijer.SupplementStore.services.UserService;

@RestController
@RequestMapping
@CrossOrigin
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;

	@GetMapping(path = "/orders") 
	public List<Order> getAllOrderLines(){
		return orderService.getAllOrders();
	}
	
	@GetMapping(path = "/orders/{id}") 
	public Order getOrderById(@PathVariable("id") int id) {
		return orderService.getOrder(Integer.toUnsignedLong(id));
	}
	
	@GetMapping(path = "users/{id}/orders")
	public List<Order> getOneCustomersOrders(@PathVariable("id") int id){
		return userService.getUser(Integer.toUnsignedLong(id)).getUserOrders();
	}
	
	
	@PostMapping(path = "/orders")
	public void addOrder(@RequestBody Order order) {
		orderService.addOrder(order);
	}
	
	@PutMapping(path = "/orders/{id}")
	public void updateOrder(@PathVariable("id") int id, @RequestBody Order order) {
		orderService.updateOrder(Integer.toUnsignedLong(id), order);
	}
	
	@PutMapping(path = "/orders/changestatus/{id}")
	public void changeOrderStatus(@PathVariable("id") int id, @RequestBody Order order) {
		order.setOrderSent(true);
		orderService.updateOrder(Integer.toUnsignedLong(id), order);
	}
	
	@DeleteMapping(path = "/orders/{id}")
	public void removeProductById(@PathVariable("id") int id) {
		orderService.deleteOrder(Integer.toUnsignedLong(id));
	}
}
