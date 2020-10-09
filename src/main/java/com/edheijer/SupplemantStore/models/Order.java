package com.edheijer.SupplemantStore.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate dateCreated = LocalDate.now();
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "order")
	@JsonManagedReference
	private List<OrderLine> orderLines = new ArrayList<>();
	
	public void addOrderLineToOrder(OrderLine orderLine) {
		this.orderLines.add(orderLine);
		orderLine.setOrder(this);
	}
	
	public void removeOrderLineFromOrder(OrderLine orderLine) {
		this.orderLines.remove(orderLine);
		orderLine.setOrder(null);
	}
	
	@Transient
	public Double getTotalOrderPrice() {
		double sum = 0D;
		List<OrderLine> orderLines = getOrderLines();
		
		for(OrderLine ol : orderLines) {
			sum += ol.getSumOfOrderLine();
		}
		return sum;
	}
	
	@Transient
	public int getNumberOfProducts() {
		return this.getOrderLines().size();
	}
}
