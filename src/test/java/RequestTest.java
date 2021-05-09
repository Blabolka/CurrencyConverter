import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

public class RequestTest {

    @Test
    public void getCurrenciesRequestAvailable() {
        try {
            URL jsonUrl = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
            Requests.getCurrencies(jsonUrl);
            Assert.assertTrue(true);
        } catch (IOException exception) {
            Assert.fail();
        }
    }
}
