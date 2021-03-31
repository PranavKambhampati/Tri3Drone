package Labs;

import java.util.stream.LongStream;
import java.time.Duration;
import java.time.Instant;

public class AryanRecursion {
    public int answerRecursionFactorial;
    public int timeRecursionFactorial;

    public int answerForLoop;
    public int timeForLoop;

    public int answerForStream;
    public int timeForStream;

    Duration r;
    Duration f;
    Duration s;

    public AryanRecursion(int totalNumber) {

        Instant startCalc = Instant.now();
        answerRecursionFactorial = recursionFactorial(totalNumber);
        Instant endCalc = Instant.now();
        r = Duration.between(startCalc, endCalc);
        timeRecursionFactorial = r.getNano();

        Instant startCalc1 = Instant.now();
        answerForLoop = factorialForLoop(totalNumber);
        Instant endCalc1 = Instant.now();
        f = Duration.between(startCalc1, endCalc1);
        timeForLoop = f.getNano();

        Instant startCalc2 = Instant.now();
        answerForStream = streamsFactorial(totalNumber);
        Instant endCalc2 = Instant.now();
        s = Duration.between(startCalc2, endCalc2);
        timeForStream = s.getNano();

    }

    // Method using recursion to calculate the factorial of a number
    public int recursionFactorial(int number) {
        if (number >= 1) {
            return number * recursionFactorial(number-1); // recursive case
        }
        else {
            return 1; // base case
        }
    }

    // Method using a for loop to calculate the factorial of a number, help taken from https://beginnersbook.com/2017/09/java-program-to-find-factorial-using-for-and-while-loop/
    public int factorialForLoop(int numberTwo) {
        int answer = 1;
        for (int i = 1; i <= numberTwo; i++) {
            answer = answer * i;
        }
        return answer;
    }

    // Method using a java stream to calculate the factorial of a number, help taken from https://www.baeldung.com/java-calculate-factorial
    public int streamsFactorial(int numberThree) {
        return (int) LongStream.rangeClosed(1,numberThree).reduce(1, (x, y)  -> x * y);
    }
}



