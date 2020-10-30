package com.edheijer.SupplementStore.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String address;
	
	public User(String username, String email, String password, String address) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();

	@JsonManagedReference
	@OneToMany(mappedBy = "user")
	private List<Order> userOrders = new ArrayList<Order>();
	
	public void addOrderToUser(Order order) {
		this.userOrders.add(order);
		order.setUser(this);
	}
	
	public void removeOrderFromCustomer(Order order) {
		this.userOrders.remove(order);
		order.setUser(null);
	}
	
}
