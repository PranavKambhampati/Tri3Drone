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
    private String opt_5;
    private String opt_6;
    private String opt_7;
    private String opt_8;
    private String opt_9;
    private String opt_10;

    public FormQuestion(Form form, String question, String opt_1, String opt_2, String opt_3, String opt_4, String opt_5, String opt_6, String opt_7, String opt_8, String opt_9, String opt_10) {
        this.form = form;
        this.question = question;
        this.opt_1 = opt_1;
        this.opt_2 = opt_2;
        this.opt_3 = opt_3;
        this.opt_4 = opt_4;
        this.opt_5 = opt_5;
        this.opt_6 = opt_6;
        this.opt_7 = opt_7;
        this.opt_8 = opt_8;
        this.opt_9 = opt_9;
        this.opt_10 = opt_10;
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
                ", opt_5='" + opt_5 + '\'' +
                ", opt_6='" + opt_6 + '\'' +
                ", opt_7='" + opt_7 + '\'' +
                ", opt_8='" + opt_8 + '\'' +
                ", opt_9='" + opt_9 + '\'' +
                ", opt_10='" + opt_10 + '\'' +
                '}';
    }
}
