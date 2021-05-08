import java.util.List;

public class Currencies {
    private List<CurrencyItem> currencies;

    public Currencies(List<CurrencyItem> currencies) {
        this.currencies = currencies;
    }

    @Override
    public String toString() {
        return "Currencies{" +
                "currencies=" + currencies +
                '}';
    }
}
