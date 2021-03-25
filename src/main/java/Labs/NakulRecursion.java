package Labs;
import java.time.Instant;
import java.util.stream.IntStream;
import java.time.Duration;

public class NakulRecursion {
    public int recursionProcessingTime;
    public int loopProcessingTime;
    public int streamProcessingTime;

    Duration recursionProcessingTimeSec;
    Duration loopProcessingTimeSec;
    Duration streamProcessingTimeSec;

    public int recursionFactorialResult;
    public int loopFactorialResult;
    public int streamFactorialResult;

    public NakulRecursion(int n) {
        Instant start = Instant.now();
        recursionFactorialResult = recursionFactorial(n);
        Instant end = Instant.now();
        recursionProcessingTimeSec = Duration.between(start, end);
        recursionProcessingTime = recursionProcessingTimeSec.getNano();

        start = Instant.now();
        loopFactorialResult = loopFactorial(n);
        end = Instant.now();
        loopProcessingTimeSec = Duration.between(start, end);
        loopProcessingTime = loopProcessingTimeSec.getNano();

        start = Instant.now();
        streamFactorialResult = streamFactorial(n);
        end = Instant.now();
        streamProcessingTimeSec = Duration.between(start, end);
        streamProcessingTime = streamProcessingTimeSec.getNano();
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
