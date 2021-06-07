package com.example.demo.mysql.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Form")
@Getter
@Setter
@NoArgsConstructor
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User creator;
    @OneToMany(mappedBy = "form")
    private List<FormQuestion> questions;

    public Form(Long id, User creator) {
        this.id = id;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", creator=" + creator +
                '}';
    }
}
