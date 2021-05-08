import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            URL jsonUrl = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
            Currencies currencies = new Currencies(Requests.getCurrencies(jsonUrl));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

}
