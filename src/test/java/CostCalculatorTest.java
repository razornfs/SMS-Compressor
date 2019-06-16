import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CostCalculatorTest {
    @Test
    public void calculates_correctly() {
        CostCalculator cc = new CostCalculator(BigDecimal.valueOf(10));
        BigDecimal calculate = cc.calculate(5);
        assertEquals(BigDecimal.valueOf(10 * 5), calculate);
    }
}
