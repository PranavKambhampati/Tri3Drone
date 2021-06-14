package com.example.demo.mysql.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
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
