package com.example.demo.sqlite.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserSqlRepository {
    @Autowired
    private UserJpaRepository jpa;

    public UserSqlRepository(UserJpaRepository jpa) {
        this.jpa = jpa;
    }

    public List<User> listAll() {
        return jpa.findAll();
    }

    public Optional<User> findById(long id) {
        return jpa.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return jpa.findByEmail(email);
    }

    public User save(User person) {
        return jpa.save(person);
    }

    public User get(long id) {
        return jpa.findById(id).get();
    }

    public void deleteById(long id) {
        jpa.deleteById(id);
    }
}