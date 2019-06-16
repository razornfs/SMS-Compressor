import org.apache.commons.lang3.StringUtils;
import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.math.BigDecimal;
import java.util.List;

public class Main implements Runnable {

    @Option(names = "-m", required = true)
    private static String SMS = "Ala ma kota";

    @Option(names = "-d", required = true)
    private static int length = 160;

    @Option(names = "-k", required = true)
    private static BigDecimal cost = BigDecimal.valueOf(1);

    public static void main(String[] args) {
        CommandLine.run(new Main(), args);
    }

    public void run() {
        JsmazCompressor nc = new JsmazCompressor();
        byte[] compressed = nc.compress(SMS);

        Paginator paginator = new Paginator(length);
        List<String> paginate = paginator.paginate(StringUtils.join(compressed, ""));
        int amountOfSMS = paginate.size();

        CostCalculator calculator = new CostCalculator(cost);
        BigDecimal smsCost = calculator.calculate(amountOfSMS);

        System.out.println(
                String.format("Twój sms mieści się w %d wiadomościach. Całkowity koszt: %.2f zł. Lista wiadomości: %s",
                              amountOfSMS, smsCost, paginate));
    }
}
