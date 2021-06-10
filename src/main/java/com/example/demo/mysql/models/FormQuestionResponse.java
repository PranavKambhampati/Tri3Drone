package com.example.demo.mysql.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FormQuestionResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User user;
    @OneToOne
    private Form form;
    @OneToOne
    private FormQuestion question;
    private String response;

    public FormQuestionResponse(User user, Form form, FormQuestion question, String response) {
        this.user = user;
        this.form = form;
        this.question = question;
        this.response = response;
    }

    @Override
    public String toString() {
        return "FormQuestionResponse{" +
                "id=" + id +
                ", user=" + user +
                ", form=" + form +
                ", question=" + question +
                ", response='" + response + '\'' +
                '}';
    }
}

