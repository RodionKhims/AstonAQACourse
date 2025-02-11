package khims.rodion;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class MathUtilsTest {

    @Test(dataProvider = "factorialSuccess")
    public void testSuccessfulFactorial(int value, long expected) {
        BigInteger calculated = MathUtils.calcFactorial(value);
        Assertions.assertThat(calculated).isEqualTo(expected);
    }

    @Test
    public void testZeroFactorial() {
        BigInteger calculated = MathUtils.calcFactorial(0);
        Assertions.assertThat(calculated).isEqualTo(1);
    }

    @Test
    public void testNegativeFactorial() {
        Throwable thrown = Assertions.catchThrowable(() -> MathUtils.calcFactorial(-1));
        Assertions.assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Incorrect value: -1");
    }

    @DataProvider(name = "factorialSuccess")
    public static Object[][] factorialSuccessValues() {
        return new Object[][]{{1, 1}, {2, 2}, {3, 6}, {5, 120}, {10, 3628800}};
    }
}
