package com.example.birdspotting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BirdspottingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BirdspottingApplication.class, args);
    }

}
