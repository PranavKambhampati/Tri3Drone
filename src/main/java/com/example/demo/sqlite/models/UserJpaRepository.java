package com.example.demo.sqlite.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
Extends the JpaRepository interface from Spring Data JPA.
-- Java Persistent API (JPA) - Hibernate: map, store, update and retrieve data
-- JpaRepository defines standard CRUD methods
-- Via JPA the developer can retrieve data from relational databases to Java objects and vice versa.
 */
public interface UserJpaRepository extends JpaRepository<User, Long> {
        // Query method
        Optional<User> findByEmail(String email);
}
