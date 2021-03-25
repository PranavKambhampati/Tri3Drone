package Labs;
import java.time.Instant;
import java.util.stream.IntStream;
import java.time.Duration;

public class NakulRecursion {
    Duration recursionProcessingTime;
    Duration loopProcessingTime;
    Duration streamProcessingTime;

    int recursionFactorialResult;
    int loopFactorialResult;
    int streamFactorialResult;

    public NakulRecursion(int n) {
        Instant start = Instant.now();
        recursionFactorialResult = recursionFactorial(n);
        Instant end = Instant.now();
        recursionProcessingTime = Duration.between(start, end);

        start = Instant.now();
        loopFactorialResult = loopFactorial(n);
        end = Instant.now();
        loopProcessingTime = Duration.between(start, end);

        start = Instant.now();
        streamFactorialResult = streamFactorial(n);
        end = Instant.now();
        streamProcessingTime = Duration.between(start, end);
    }

    public int recursionFactorial(int n){
        if (n>=1){
            return n * recursionFactorial(n-1);
        }
        return 1;
    }

    public int loopFactorial(int n){
        int result = 1;
        for (int i = n; i>0; i--){
            result = i*result;
        }
        return result;
    }

    public int streamFactorial(int n){
        return IntStream.rangeClosed(1, n)
                .reduce(1, (x, y) -> x * y);
    }

}
