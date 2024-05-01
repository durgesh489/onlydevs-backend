package com.durgesh.onlydevs.repositories;

import com.durgesh.onlydevs.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.email=:email")
    public User getUserByEmail(@Param("email") String email);
    
    Optional<User> findByEmail(String email);


}
