package Labs;

import java.util.stream.LongStream;

public class AryanRecursion {
    public int answerRecursionFactorial;
    public int answerForLoop;
    public int answerForStream;


    public AryanRecursion(int totalNumber) {
        answerRecursionFactorial = recursionFactorial(totalNumber);
        answerForLoop = factorialForLoop(totalNumber);
        answerForStream = streamsFactorial(totalNumber);
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



