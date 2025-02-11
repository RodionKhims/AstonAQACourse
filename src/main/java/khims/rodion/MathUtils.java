package khims.rodion;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class MathUtils {
    public static BigInteger calcFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Incorrect value: " + n);
        }
        if (n < 2) {
            return BigInteger.valueOf(1);
        }
        return IntStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .get();
    }
}
