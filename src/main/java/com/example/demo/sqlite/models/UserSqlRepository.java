package com.example.demo.sqlite.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserSqlRepository {

    @Autowired
    private UserJpaRepository jpa;

    public List<User> listAll() {
        return jpa.findAll();
    }

    public void save(User person) {
        jpa.save(person);
    }

    public User get(long id) {
        return jpa.findById(id).get();
    }

    public void delete(long id) {
        jpa.deleteById(id);
    }
}