package com.edheijer.SupplementStore.models;

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
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String brand;
	private String product_name;
	private double price;
	private String imageUrl;
	
//	@JsonManagedReference
//	@OneToMany(mappedBy = "product")
//	private List<OrderLine> orderLines = new ArrayList<>();
	
//	public void connectProductToOrderLine(OrderLine orderLine) {
//		this.orderLines.add(orderLine);
//		orderLine.setProduct(this);
//	}
//	
//	public void removeOrderLine(OrderLine orderLine) {
//		this.orderLines.remove(orderLine);
//		orderLine.setProduct(null);
//	}
}
