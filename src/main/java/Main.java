import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Kompresja SMS ===");
        System.out.println("Podaj treść SMSa:");
        String SMS = sc.nextLine();
        System.out.println("Podaj maksymalną długość SMSa: ");
        int length = sc.nextInt();
        System.out.println("Podaj koszt wysłania jednego SMSa w złotych: ");
        BigDecimal cost = sc.nextBigDecimal();

        NaiveCompressor nc = new NaiveCompressor();
        String compressed = nc.compress(SMS);

        Paginator paginator = new Paginator(length);
        List<String> paginate = paginator.paginate(compressed);
        int amountOfSMS = paginate.size();

        CostCalculator calculator = new CostCalculator(cost);
        BigDecimal smsCost = calculator.calculate(amountOfSMS);

        System.out.println(
                String.format("Twój sms mieści się w %d wiadomościach. Całkowity koszt: %.2f zł. Lista wiadomości: %s",
                              amountOfSMS, smsCost, paginate));
    }
}
