package com.example.demo.Forms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnalyticCounter {
    private int option_1;
    private int option_2;
    private int option_3;
    private int option_4;

    public AnalyticCounter() {
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
}
