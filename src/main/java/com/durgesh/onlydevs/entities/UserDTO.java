package com.durgesh.onlydevs.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    int id;


    @NotNull(message = "username cannot be null")
    String username;
    @NotNull(message = "password cannot be null")

    String password;

    @NotNull(message = "email cannot be null")

    String email;

    @NotNull(message = "type cannot be null")

    String type;
}
