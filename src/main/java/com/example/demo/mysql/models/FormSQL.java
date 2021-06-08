package com.example.demo.mysql.models;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FormSQL {
    @Autowired
    private FormRepository jpa;

    public List<Form> listAll() {
        return jpa.findAll();
    }

    public void save(Form person) {
        jpa.save(person);
    }

    public Form get(long id) {
        return jpa.findById(id).get();
    }

    public void delete(long id) {
        jpa.deleteById(id);
    }
}
