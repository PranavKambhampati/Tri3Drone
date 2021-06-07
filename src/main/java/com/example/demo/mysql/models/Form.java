package com.example.demo.mysql.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "Form")
@Getter
@Setter
@NoArgsConstructor
public class Form {
    @Id
    private Long id;
    @OneToOne
    private User creator;

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
