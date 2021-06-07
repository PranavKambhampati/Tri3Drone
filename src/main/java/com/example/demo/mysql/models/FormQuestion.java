package com.example.demo.mysql.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FormQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Form form;
    public FormQuestion(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FormQuestion{" +
                "id=" + id +
                '}';
    }
}
