import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CurrenciesTest {

    @Test
    public void convertCurrenciesTest() {
        List<CurrencyItem> currencyItemList = new ArrayList<>();
        currencyItemList.add(new CurrencyItem(40, "Деяка перша валюта", 24.5, "SC1", "01.01.2020"));
        currencyItemList.add(new CurrencyItem(41, "Деяка друга валюта", 15.7, "SC2", "01.01.2020"));
        Currencies currencies = new Currencies(currencyItemList);

        double expectedConvertedCurrency = 5 * (24.5 / 15.7);
        Assert.assertEquals(expectedConvertedCurrency, currencies.convertCurrency(0, 1, 5), 0.000005);
    }
}
