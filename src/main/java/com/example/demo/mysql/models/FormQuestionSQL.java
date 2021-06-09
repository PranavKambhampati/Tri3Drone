package com.example.demo.mysql.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class FormQuestionSQL {
    @Autowired
    private FormQuestionRepository jpa;

    public List<FormQuestion> listAll() {
        return jpa.findAll();
    }

    public void save(FormQuestion person) {
        jpa.save(person);
    }

    public FormQuestion get(long id) {
        return jpa.findById(id).get();
    }

    public void delete(long id) {
        jpa.deleteById(id);
    }
}
