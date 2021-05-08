import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Currencies {
    private final List<CurrencyItem> currencies;

    public Currencies(List<CurrencyItem> currencies) {
        this.currencies = currencies;
        currencies.add(new CurrencyItem(1, "Українська гривня", 1, "UAN", "08.05.2021"));
    }

    public List<CurrencyItem> getCurrencies() {
        return new ArrayList<>(currencies);
    }

    public void sortByCC() {
        currencies.sort(Comparator.comparing(CurrencyItem::getCc));
    }

    public void sortByText() {
        currencies.sort(Comparator.comparing(CurrencyItem::getTxt));
    }

    public double convertCurrency(int fromCurrencyIndex, int toCurrencyIndex, double convertedValue) {
        double coefficient = currencies.get(fromCurrencyIndex).getRate() / currencies.get(toCurrencyIndex).getRate();
        return convertedValue * coefficient;
    }

    @Override
    public String toString() {
        return "Currencies{" +
                "currencies=" + currencies +
                '}';
    }
}
