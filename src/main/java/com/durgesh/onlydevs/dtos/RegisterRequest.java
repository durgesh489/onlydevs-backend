package com.durgesh.onlydevs.dtos;

import com.durgesh.onlydevs.entities.Role;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	@NotBlank(message = "Name is required.")
	private String name;
	
	@NotBlank(message = "Email is required.")
	private String email;
	
	@NotBlank(message = "Password is required.")
	private String password;
	
	private Role role;
}
