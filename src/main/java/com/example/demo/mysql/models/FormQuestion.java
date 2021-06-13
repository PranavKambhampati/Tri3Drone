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
    private String question;
    private String opt_1;
    private String opt_2;
    private String opt_3;
    private String opt_4;

    public FormQuestion(Form form, String question, String opt_1, String opt_2, String opt_3, String opt_4) {
        this.form = form;
        this.question = question;
        this.opt_1 = opt_1;
        this.opt_2 = opt_2;
        this.opt_3 = opt_3;
        this.opt_4 = opt_4;
    }

    @Override
    public String toString() {
        return "FormQuestion{" +
                "id=" + id +
                ", form=" + form +
                ", question='" + question + '\'' +
                ", opt_1='" + opt_1 + '\'' +
                ", opt_2='" + opt_2 + '\'' +
                ", opt_3='" + opt_3 + '\'' +
                ", opt_4='" + opt_4 + '\'' +
                '}';
    }
}
