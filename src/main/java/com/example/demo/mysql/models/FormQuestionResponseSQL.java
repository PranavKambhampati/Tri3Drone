package com.example.demo.mysql.models;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FormQuestionResponseSQL {
    @Autowired
    private FormQuestionResponseRepository jpa;

    public List<FormQuestionResponse> listAll() {
        return jpa.findAll();
    }

    public void save(FormQuestionResponse person) {
        jpa.save(person);
    }

    public FormQuestionResponse get(long id) {
        return jpa.findById(id).get();
    }

    public void delete(long id) {
        jpa.deleteById(id);
    }
}
