package com.edheijer.SupplementStore.payload.response;

import java.util.List;

import lombok.Data;

@Data
public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private String address;
	private List<String> roles;

	public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles, String address) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.address = address;
	}
}
