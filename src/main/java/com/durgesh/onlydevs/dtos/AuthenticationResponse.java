package com.durgesh.onlydevs.dtos;

import java.time.LocalDateTime;

import com.durgesh.onlydevs.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  @JsonProperty("access_token")
  private String accessToken;
  
  @JsonProperty("refresh_token")
  private String refreshToken;
  
  private String message;
  
  private Integer status;
  
  private LocalDateTime timeStamp;
  
  private User data;
}
