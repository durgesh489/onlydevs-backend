package com.durgesh.onlydevs.controllers;

import com.durgesh.onlydevs.entities.ApiResponse;
import com.durgesh.onlydevs.entities.LoginUser;
import com.durgesh.onlydevs.entities.User;
import com.durgesh.onlydevs.entities.UserDTO;
import com.durgesh.onlydevs.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class UserController {

    @Autowired
    UserRepository userRepository;


    ObjectMapper objectMapper=new ObjectMapper();
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signup(@Valid @RequestBody UserDTO userDTO) {
       try {
           User user =objectMapper.convertValue(userDTO,User.class);
           User result = userRepository.save(user);
           ApiResponse apiResponse=new ApiResponse("User Saved", "ok",result);
           return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
       }
       catch (Exception exception){
           ApiResponse apiResponse=new ApiResponse(exception.getMessage(),"not ok",null);
           return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
       }



    }



    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User>users=(List<User>) userRepository.findAll();
        return users;
    }
    @DeleteMapping("/users")
    public String deleteAllUsers(){
        userRepository.deleteAll();
        return "users deleted";
    }
}
