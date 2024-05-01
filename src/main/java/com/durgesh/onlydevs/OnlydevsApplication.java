package com.durgesh.onlydevs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class OnlydevsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlydevsApplication.class, args);
        System.out.println("Project Startedddddddddddddddddd");
    }

}
