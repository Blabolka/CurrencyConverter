import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Application extends JFrame {

    private Currencies currencies;
    private JPanel contentPane;
    private JComboBox<String> fromComboBox;
    private DefaultComboBoxModel<String> fromComboBoxModel;
    private JComboBox<String> toComboBox;
    private DefaultComboBoxModel<String> toComboBoxModel;
    private JButton calculateButton;
    private JTextField fromValueTextField;
    private JTextField toValueTextField;

    public Application(String title) {
        super(title);

        addButtonActions();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
    }

    private void createUIComponents() {
        currencies = new Currencies(new ArrayList<>());
        try {
            URL jsonUrl = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
            currencies = new Currencies(Requests.getCurrencies(jsonUrl));
            currencies.sortByCC();
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, "Cannot get currencies info...", "Request error", JOptionPane.ERROR_MESSAGE);
        }

        fromComboBoxModel = new DefaultComboBoxModel<>();
        toComboBoxModel = new DefaultComboBoxModel<>();
        for (CurrencyItem item : currencies.getCurrencies()) {
            fromComboBoxModel.addElement(item.getCc() + " (" + item.getTxt() + ")");
            toComboBoxModel.addElement(item.getCc() + " (" + item.getTxt() + ")");
        }

        fromComboBox = new JComboBox<>(fromComboBoxModel);
        toComboBox = new JComboBox<>(toComboBoxModel);

        calculateButton = new JButton("=");
    }

    private void addButtonActions() {
        calculateButton.addActionListener(event -> {
            int indexFrom = fromComboBoxModel.getIndexOf(fromComboBoxModel.getSelectedItem());
            int indexTo = toComboBoxModel.getIndexOf(toComboBoxModel.getSelectedItem());

            try {
                if (!fromValueTextField.getText().equals("")) {
                    double convertibleValue = Double.parseDouble(fromValueTextField.getText());
                    double convertedValue = currencies.convertCurrency(indexFrom, indexTo, convertibleValue);
                    toValueTextField.setText(String.format("%.4f", convertedValue));
                }
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Enter correct value!", "Incorrect value error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new Application("Andrew's Klochko Currency Converter");
        frame.pack();

        // Window located on center of screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2 - frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        frame.setResizable(false);
        frame.setVisible(true);
    }
}
