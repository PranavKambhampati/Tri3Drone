package com.example.demo.Forms;

import lombok.Getter;
import lombok.Setter;

@Setter
public class AnalyticCounter {
    private String question;
    private String val_opt1;
    private String val_opt2;
    private String val_opt3;
    private String val_opt4;

    private int option_1;
    private int option_2;
    private int option_3;
    private int option_4;

    public AnalyticCounter(String question, String answer_1, String answer_2, String answer_3, String answer_4) {
        this.question = question;
        this.val_opt1 = answer_1;
        this.val_opt2 = answer_2;
        this.val_opt3 = answer_3;
        this.val_opt4 = answer_4;
        this.option_1 = 0;
        this.option_2 = 0;
        this.option_3 = 0;
        this.option_4 = 0;
    }

    public void incrementOpt1(){
        this.option_1++;
    }
    public void incrementOpt2(){
        this.option_2++;
    }
    public void incrementOpt3(){
        this.option_3++;
    }
    public void incrementOpt4(){
        this.option_4++;
    }

    public String getQuestion() {
        return question;
    }

    public String getVal_opt1() {
        return val_opt1;
    }

    public String getVal_opt2() {
        return val_opt2;
    }

    public String getVal_opt3() {
        return val_opt3;
    }

    public String getVal_opt4() {
        return val_opt4;
    }

    public int getOption_1() {
        return option_1;
    }

    public int getOption_2() {
        return option_2;
    }

    public int getOption_3() {
        return option_3;
    }

    public int getOption_4() {
        return option_4;
    }
}
