package com.example.demo.Forms;

public class CreateMC {

    // Help taken from https://www.youtube.com/watch?v=3JfySNe5MrM

    public String question;
    public String answerOne;
    public String answerTwo;
    public String answerThree;
    public String answerFour;
    
    public String question2;
    public String answer21;
    public String answer22;
    public String answer23;
    public String answer24;

    public String question3;
    public String answer31;
    public String answer32;
    public String answer33;
    public String answer34;

    public String question4;
    public String answer41;
    public String answer42;
    public String answer43;
    public String answer44;

    public String question5;
    public String answer51;
    public String answer52;
    public String answer53;
    public String answer54;


    public CreateMC(String question1, String answer1, String answer2, String answer3, String answer4, String question2,
                    String answer21, String answer22, String answer23, String answer24, String question3, String answer31,
                    String answer32, String answer33, String answer34, String question4, String answer41, String answer42,
                    String answer43, String answer44, String question5, String answer51, String answer52, String answer53,
                    String answer54) {
        question = getQuestion(question1);
        answerOne = getAnswer(answer1);
        answerTwo = getAnswer(answer2);
        answerThree = getAnswer(answer3);
        answerFour = getAnswer(answer4);

        this.question2 = getQuestion(question2);
        this.answer21 = getAnswer(answer21);
        this.answer22 = getAnswer(answer22);
        this.answer23 = getAnswer(answer23);
        this.answer24 = getAnswer(answer24);

        this.question3 = getQuestion(question3);
        this.answer31 = getAnswer(answer31);
        this.answer32 = getAnswer(answer32);
        this.answer33 = getAnswer(answer33);
        this.answer34 = getAnswer(answer34);

        this.question4 = getQuestion(question4);
        this.answer41 = getAnswer(answer41);
        this.answer42 = getAnswer(answer42);
        this.answer43 = getAnswer(answer43);
        this.answer44 = getAnswer(answer44);

        this.question5 = getQuestion(question5);
        this.answer51 = getAnswer(answer51);
        this.answer52 = getAnswer(answer52);
        this.answer53 = getAnswer(answer53);
        this.answer54 = getAnswer(answer54);

    }

    public String getQuestion(String pregunta) {
        return pregunta;
    }

    public String getAnswer(String answerUno) {
        return answerUno;
    }



}
