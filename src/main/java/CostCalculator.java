import java.math.BigDecimal;

public class CostCalculator {

    private BigDecimal SMSCost;

    public CostCalculator(BigDecimal SMSCost) {
        this.SMSCost = SMSCost;
    }

    BigDecimal calculate(int SMSAmount) {
        return SMSCost.multiply(BigDecimal.valueOf(SMSAmount));
    }
}
