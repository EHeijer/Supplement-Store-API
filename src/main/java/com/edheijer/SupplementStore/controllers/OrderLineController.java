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

import com.edheijer.SupplementStore.models.OrderLine;
import com.edheijer.SupplementStore.models.Product;
import com.edheijer.SupplementStore.services.OrderLineService;


@RestController
@RequestMapping
@CrossOrigin()
public class OrderLineController {
	
	Long idCounter = 1L;
	
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
		orderLine.setId(idCounter);
		
		orderLineService.addOrderLine(orderLine);
		idCounter++;
	}
	
	
	@PutMapping(path = "/orderLines")
	public void updateOrderLine(@RequestBody OrderLine orderLine) {
		orderLineService.updateOrderLine(orderLine);
	}
	
	@DeleteMapping(path = "/orderLines/{id}")
	public void removeProductById(@PathVariable("id") int id) {
		
		orderLineService.deleteOrderLine(Integer.toUnsignedLong(id));
	}

}
