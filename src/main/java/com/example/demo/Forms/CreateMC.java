package com.example.demo.Forms;

public class CreateMC {

    public String questionDiv1 = " display:none;";
    public String question;
    public String answerOne;
    public String answerTwo;
    public String answerThree;
    public String answerFour;

    public String questionDiv2 = " display:none;";
    public String question2;
    public String answer21;
    public String answer22;
    public String answer23;
    public String answer24;

    public String questionDiv3 = " display:none;";
    public String question3;
    public String answer31;
    public String answer32;
    public String answer33;
    public String answer34;

    public String questionDiv4 = " display:none;";
    public String question4;
    public String answer41;
    public String answer42;
    public String answer43;
    public String answer44;

    public String questionDiv5 = " display:none;";
    public String question5;
    public String answer51;
    public String answer52;
    public String answer53;
    public String answer54;

    public String questionDiv6 = " display:none;";
    public String question6;
    public String answer61;
    public String answer62;
    public String answer63;
    public String answer64;

    public String questionDiv7 = " display:none;";
    public String question7;
    public String answer71;
    public String answer72;
    public String answer73;
    public String answer74;

    public String questionDiv8 = " display:none;";
    public String question8;
    public String answer81;
    public String answer82;
    public String answer83;
    public String answer84;

    public String questionDiv9 = " display:none;";
    public String question9;
    public String answer91;
    public String answer92;
    public String answer93;
    public String answer94;

    public String questionDiv10 = " display:none;";
    public String question10;
    public String answer101;
    public String answer102;
    public String answer103;
    public String answer104;

    public CreateMC(String question1, String answer1, String answer2, String answer3, String answer4, String question2,
                    String answer21, String answer22, String answer23, String answer24, String question3, String answer31,
                    String answer32, String answer33, String answer34, String question4, String answer41, String answer42,
                    String answer43, String answer44, String question5, String answer51, String answer52, String answer53,
                    String answer54, String question6, String answer61, String answer62, String answer63, String answer64,
                    String question7, String answer71, String answer72, String answer73, String answer74, String question8,
                    String answer81, String answer82, String answer83, String answer84, String question9, String answer91,
                    String answer92, String answer93, String answer94, String question10, String answer101, String answer102,
                    String answer103, String answer104) {
        if(question1.trim() != "") {
            this.questionDiv1 = " display:block;";
        }
        if(question2.trim() != "") {
            this.questionDiv2 = " display:block;";
        }
        if(question3.trim() != "") {
            this.questionDiv3 = " display:block;";
        }
        if(question4.trim() != "") {
            this.questionDiv4 = " display:block;";
        }
        if(question5.trim() != "") {
            this.questionDiv5 = " display:block;";
        }
        if(question6.trim() != "") {
            this.questionDiv6 = " display:block;";
        }
        if(question7.trim() != "") {
            this.questionDiv7 = " display:block;";
        }
        if(question8.trim() != "") {
            this.questionDiv8 = " display:block;";
        }
        if(question9.trim() != "") {
            this.questionDiv9 = " display:block;";
        }
        if(question10.trim() != "") {
            this.questionDiv10 = " display:block;";
        }
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

        this.question6 = getQuestion(question6);
        this.answer61 = getAnswer(answer61);
        this.answer62 = getAnswer(answer62);
        this.answer63 = getAnswer(answer63);
        this.answer64 = getAnswer(answer64);

        this.question7 = getQuestion(question7);
        this.answer71 = getAnswer(answer71);
        this.answer72 = getAnswer(answer72);
        this.answer73 = getAnswer(answer73);
        this.answer74 = getAnswer(answer74);

        this.question8 = getQuestion(question8);
        this.answer81 = getAnswer(answer81);
        this.answer82 = getAnswer(answer82);
        this.answer83 = getAnswer(answer83);
        this.answer84 = getAnswer(answer84);

        this.question9 = getQuestion(question9);
        this.answer91 = getAnswer(answer91);
        this.answer92 = getAnswer(answer92);
        this.answer93 = getAnswer(answer93);
        this.answer94 = getAnswer(answer94);

        this.question10 = getQuestion(question10);
        this.answer101 = getAnswer(answer101);
        this.answer102 = getAnswer(answer102);
        this.answer103 = getAnswer(answer103);
        this.answer104 = getAnswer(answer104);


    }

    public String getQuestion(String pregunta) {
        return pregunta;
    }

    public String getAnswer(String answerUno) {
        return answerUno;
    }



}
