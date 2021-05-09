import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Currencies {
    private final List<CurrencyItem> currencies;

    public Currencies(List<CurrencyItem> currencies) {
        this.currencies = new ArrayList<>(currencies);

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        currencies.add(new CurrencyItem(1, "Українська гривня", 1, "UAN", formatter.format(new Date())));
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currencies that = (Currencies) o;
        return Objects.equals(currencies, that.currencies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencies);
    }

    @Override
    public String toString() {
        return "Currencies{" +
                "currencies=" + currencies +
                '}';
    }
}
