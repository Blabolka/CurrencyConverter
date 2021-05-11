package currencies;

import java.util.Objects;

public class CurrencyItem {

    /* Bad variable names because i have json request with format:
    * {
    *   r030: 111 // some currency identifier from service where i get info
    *   txt: "Some currency text"
    *   rate: 25.5
    *   cc: "SCC" // currency code by country
    *   exchangedate: "01.01.2020"
    * }
    * For working Jackson json parsing library i need to keep variable names the same as in json */

    private int r030;
    private String txt;
    private double rate;
    private String cc;
    private String exchangedate;

    // need to parse from json string because it use reflection
    public CurrencyItem(){}

    public CurrencyItem(int r030, String txt, double rate, String cc, String exchangedate) {
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    public int getR030() {
        return r030;
    }

    public String getTxt() {
        return txt;
    }

    public double getRate() {
        return rate;
    }

    public String getCc() {
        return cc;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    public void setR030(int r030) {
        this.r030 = r030;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyItem item = (CurrencyItem) o;
        return r030 == item.r030 &&
                Double.compare(item.rate, rate) == 0 &&
                Objects.equals(txt, item.txt) &&
                Objects.equals(cc, item.cc) &&
                Objects.equals(exchangedate, item.exchangedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(r030, txt, rate, cc, exchangedate);
    }

    @Override
    public String toString() {
        return "currencies.CurrencyItem{" +
                "r030=" + r030 +
                ", txt='" + txt + '\'' +
                ", rate=" + rate +
                ", cc='" + cc + '\'' +
                ", exchangeData='" + exchangedate + '\'' +
                '}';
    }
}
