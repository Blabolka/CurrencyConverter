import currencies.CurrencyItem;
import org.junit.Assert;
import org.junit.Test;

public class CurrencyItemTest {

    @Test
    public void getParametersTest() {
        CurrencyItem item = new CurrencyItem(5, "Деяка валюта", 5.5, "SCC", "01.01.2021");
        Assert.assertEquals(5, item.getR030());
        Assert.assertEquals("Деяка валюта", item.getTxt());
        Assert.assertEquals(5.5, item.getRate(), 0.000005);
        Assert.assertEquals("SCC", item.getCc());
        Assert.assertEquals("01.01.2021", item.getExchangedate());
    }

    @Test
    public void setParametersTest() {
        CurrencyItem item = new CurrencyItem();

        item.setR030(5);
        Assert.assertEquals(5, item.getR030());

        item.setTxt("Деяка валюта");
        Assert.assertEquals("Деяка валюта", item.getTxt());

        item.setRate(5.5);
        Assert.assertEquals(5.5, item.getRate(), 0.000005);

        item.setCc("SCC");
        Assert.assertEquals("SCC", item.getCc());

        item.setExchangedate("01.01.2021");
        Assert.assertEquals("01.01.2021", item.getExchangedate());
    }

    @Test
    public void equalsTest() {
        CurrencyItem item1 = new CurrencyItem();
        CurrencyItem item2 = new CurrencyItem();
        Assert.assertEquals(item1, item2);

        item1 = new CurrencyItem(5, "Деяка валюта", 5.5, "SCC", "01.01.2021");
        item2 = new CurrencyItem(5, "Деяка валюта", 5.5, "SCC", "01.01.2021");
        Assert.assertEquals(item1, item2);

        item1 = new CurrencyItem(10, "Деяка перша валюта", 5, "SC1", "01.01.2021");
        item2 = new CurrencyItem(20, "Деяка друга валюта", 5.5, "SC2", "02.01.2021");
        Assert.assertNotEquals(item1, item2);
    }
}
