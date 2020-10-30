package com.edheijer.SupplementStore.models;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "orderLines")
public class OrderLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int quantity;
	
//	@JsonBackReference(value="order")
//	@ManyToOne(optional = false, fetch = FetchType.LAZY)
//	@JoinColumn(name = "order_id")
//	private Order order;
	
//	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id")
	private Product product;

	public double getSumOfOrderLine() {
		return getProduct().getPrice() * quantity;
	}
	
	
	
}
