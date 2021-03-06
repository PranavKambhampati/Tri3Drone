package com.example.demo.mysql.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Form")
@Getter
@Setter
@NoArgsConstructor
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;
    @ManyToOne
    private User creator;
    @OneToMany(mappedBy = "form", fetch= FetchType.EAGER)
    private List<FormQuestion> questions = new ArrayList<>();
    /* Constructor without @OneToMany values */
    public Form(User creator) {
        this.creator = creator;
    }
    /* Constructor with @OneToMany values */
    public Form(User creator, List<FormQuestion> questions) {
        this.creator = creator;
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", creator=" + creator +
                '}';
    }
}
