import currencies.Currencies;
import gui.ComboBoxesPanel;
import gui.DocumentInputListener;
import gui.InputFieldsPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;

public class Application extends JFrame {

    private Currencies currencies;

    private JPanel contentPane;
    private JButton refreshButton;
    private ComboBoxesPanel comboBoxesPanel;
    private InputFieldsPanel inputFieldsPanel;

    public Application(String title) {
        super(title);

        addGUIElementsAction();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
    }

    private void createUIComponents() {
        refreshButton = new JButton("REFRESH CURRENCIES INFO");

        inputFieldsPanel = new InputFieldsPanel();

        refreshCurrenciesInfo();

        comboBoxesPanel = new ComboBoxesPanel();
        comboBoxesPanel.refreshComboBoxes(currencies);
    }

    private void addGUIElementsAction() {
        refreshButton.addActionListener(event -> {
            refreshCurrenciesInfo();
            comboBoxesPanel.refreshComboBoxes(currencies);
        });

        comboBoxesPanel.getFromComboBox().addItemListener(event -> convertCurrencies());
        comboBoxesPanel.getToComboBox().addItemListener(event -> convertCurrencies());

        inputFieldsPanel.getFromTextField().getDocument().addDocumentListener((DocumentInputListener) event -> convertCurrencies());

        inputFieldsPanel.getSwapButton().addActionListener(event -> {
            comboBoxesPanel.swapSelectedItemsInComboBox();
            inputFieldsPanel.swapTextInTextFields();
            convertCurrencies();
        });
    }

    private void convertCurrencies() throws NumberFormatException {
        int indexFrom = comboBoxesPanel.getFromComboBoxModel().getIndexOf(comboBoxesPanel.getFromComboBoxModel().getSelectedItem());
        int indexTo = comboBoxesPanel.getToComboBoxModel().getIndexOf(comboBoxesPanel.getToComboBoxModel().getSelectedItem());

        if (!inputFieldsPanel.getFromTextField().getText().equals("")) {
            try {
                double convertibleValue = Double.parseDouble(inputFieldsPanel.getFromTextField().getText());
                double convertedValue = currencies.convertCurrency(indexFrom, indexTo, convertibleValue);
                inputFieldsPanel.getToTextField().setText(String.format("%.4f", convertedValue));
            } catch (NumberFormatException ignore) {
                inputFieldsPanel.getToTextField().setText("");
            }

        } else {
            inputFieldsPanel.getToTextField().setText("");
        }
    }

    private void refreshCurrenciesInfo() {
        try {
            URL jsonUrl = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
            currencies = new Currencies(Requests.getCurrencies(jsonUrl));
            currencies.sortByCC();
        } catch (IOException exception) {
            currencies = new Currencies();
            JOptionPane.showMessageDialog(null, "Cannot get currencies info...", "Request error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        JFrame frame = new Application("Andrew's Klochko Currency Converter");
        frame.pack();

        // Window located on center of screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2 - frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        frame.setResizable(false);
        frame.setVisible(true);
    }
}
