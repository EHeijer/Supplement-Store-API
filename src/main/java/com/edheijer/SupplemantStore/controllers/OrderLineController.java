package com.edheijer.SupplemantStore.controllers;

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

import com.edheijer.SupplemantStore.models.OrderLine;
import com.edheijer.SupplemantStore.services.OrderLineService;


@RestController
@RequestMapping
@CrossOrigin
public class OrderLineController {
	
	@Autowired
	private OrderLineService orderLineService;

	@GetMapping(path = "/orderLines") //check this later
	public List<OrderLine> getAllOrderLines(){
		return orderLineService.getAllOrderLines();
	}
	
	@GetMapping(path = "/orderLines/{id}") //check this
	public OrderLine getOrderLineById(@PathVariable("id") int id) {
		return orderLineService.getOrderLine(Integer.toUnsignedLong(id));
	}
	
	@PostMapping(path = "/orderLines")
	public void addOrderLine(@RequestBody OrderLine orderLine) {
		orderLineService.addOrderLine(orderLine);
	}
	
	@PutMapping(path = "/orderLines/{id}")
	public void updateOrderLine(@PathVariable("id") int id, @RequestBody OrderLine orderLine) {
		orderLineService.updateOrderLine(Integer.toUnsignedLong(id), orderLine);
	}
	
	@DeleteMapping(path = "/orderLines/{id}")
	public void removeProductById(@PathVariable("id") int id) {
		orderLineService.deleteOrderLine(Integer.toUnsignedLong(id));
	}

}
