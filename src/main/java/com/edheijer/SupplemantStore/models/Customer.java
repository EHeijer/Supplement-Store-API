package com.edheijer.SupplemantStore.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String password;
	private String address;

	@JsonManagedReference
	@OneToMany(mappedBy = "customer")
	private List<Order> customerOrders = new ArrayList<Order>();
	
	public void addOrderToCustomer(Order order) {
		this.customerOrders.add(order);
		order.setCustomer(this);
	}
	
	public void removeOrderFromCustomer(Order order) {
		this.customerOrders.remove(order);
		order.setCustomer(null);
	}
	
}
