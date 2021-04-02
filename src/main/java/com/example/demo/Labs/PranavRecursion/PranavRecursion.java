package com.example.demo.Labs.PranavRecursion;

import java.util.stream.LongStream;
import java.time.*;

public class PranavRecursion {
    public int recanswer;
    public int rectime;

    public int foranswer;
    public int fortime;

    public int streamanswer;
    public int streamtime;

    //public int bigans;
    //public int bigtime;

    Duration recduration;
    Duration forduration;
    Duration streamduration;
    //Duration bigduration;

    public PranavRecursion(int number){
        Instant recstart = Instant.now();
        FactorialRecursion recurse = new FactorialRecursion();
        recanswer = recurse.factorialcalc(number);
        Instant recend = Instant.now();
        recduration = Duration.between(recstart, recend);
        rectime = recduration.getNano();


        Instant forstart = Instant.now();
        FactorialFor forloop = new FactorialFor();
        foranswer = forloop.factorialcalc(number);
        Instant forend = Instant.now();
        forduration = Duration.between(forstart, forend);
        fortime = forduration.getNano();


        Instant streamstart = Instant.now();
        FactorialStreams stream = new FactorialStreams();
        streamanswer = stream.factorialcalc(number);
        Instant streamend = Instant.now();
        streamduration = Duration.between(streamstart, streamend);
        streamtime = streamduration.getNano();
    }

}
