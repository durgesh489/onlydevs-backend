package com.durgesh.onlydevs.controllers;

import com.durgesh.onlydevs.entities.Expert;
import com.durgesh.onlydevs.entities.User;
import com.durgesh.onlydevs.repositories.ExpertRepository;
import com.durgesh.onlydevs.repositories.UserRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ExpertController {

    @Autowired
    ExpertRepository expertRepository;

    @GetMapping("/experts")
    public List<Expert> getAllExperts(){
        List<Expert>experts=(List<Expert>) expertRepository.findAll();
        return experts;
    }
    @PostMapping("/addExpert")
    @CrossOrigin(origins = "http://localhost:3000")
    public String addExpert(@RequestBody Expert expert) {
        Expert result= expertRepository.save(expert);
        return "expert added";

    }
    // Method to handle preflight requests
    @RequestMapping(value = "/addExpert", method = RequestMethod.OPTIONS)
    public ResponseEntity handle() {
        return ResponseEntity.ok().build();
    }
}
