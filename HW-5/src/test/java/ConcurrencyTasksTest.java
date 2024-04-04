import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcurrencyTasksTest {
    ConcurrencyTasks ct = new ConcurrencyTasks();

    @DisplayName("Тест на корректность метода atomicCounterMethod")
    @ParameterizedTest
    @MethodSource("countData")
    void atomicCounterMethodTest(int itog, int n, int threadNums) {
        int res = ct.atomicCounterMethod(n, threadNums);
        assertEquals(res, itog);
    }

    private static Stream<Arguments> countData() {
        return Stream.of(
                Arguments.arguments(20, 10, 2),
                Arguments.arguments(2800, 700, 4),
                Arguments.arguments(7800, 1300, 6),
                Arguments.arguments(14400, 1800, 8),
                Arguments.arguments(21000, 2100, 10),
                Arguments.arguments(6666660, 555555, 12)
        );
    }

    @DisplayName("Тест на корректность метода factorialMethod")
    @ParameterizedTest
    @MethodSource("bigIntegerData")
    void factorialMethodTest(int n, BigInteger expect, int threadNums) throws ExecutionException, InterruptedException {
        BigInteger res = ct.factorialMethod(n, threadNums);
        assertEquals(expect, res);
    }

    private static Stream<Arguments> bigIntegerData() {
        return Stream.of(
                Arguments.arguments(5, BigInteger.valueOf(120), 2),
                Arguments.arguments(8, BigInteger.valueOf(40320), 4),
                Arguments.arguments(10, BigInteger.valueOf(3628800), 6),
                Arguments.arguments(12, BigInteger.valueOf(479001600), 8),
                Arguments.arguments(14, BigInteger.valueOf(87178291200L), 10),
                Arguments.arguments(16, BigInteger.valueOf(20922789888000L), 12),
                Arguments.arguments(18, BigInteger.valueOf(6402373705728000L), 14),
                Arguments.arguments(20, BigInteger.valueOf(2432902008176640000L), 16)
        );
    }
}