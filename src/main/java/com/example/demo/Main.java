package com.example.demo;

import com.example.demo.mysql.models.User;
import com.example.demo.mysql.models.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * Uncomment for expanded creation of a new user entry in the database hi
     */
    /*
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User steven = new User( // clearer way to define objects with lots of data
                    "Steven",
                    "Lebreski",
                    "stevel01",
                    "1234",
                    "steve@lebreski.com",
                    "user"
            );
            userRepository.save(steven);
            System.out.println(userRepository.findAll());
        };
    }
     */
}
