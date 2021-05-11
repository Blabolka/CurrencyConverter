package gui;

import currencies.Currencies;
import currencies.CurrencyItem;

import javax.swing.*;

public class ComboBoxesPanel extends JComponent {

    private JPanel comboBoxesPanel;

    private JComboBox<String> fromComboBox;
    private DefaultComboBoxModel<String> fromComboBoxModel;

    private JComboBox<String> toComboBox;
    private DefaultComboBoxModel<String> toComboBoxModel;

    private void createUIComponents() {
        fromComboBox = new JComboBox<>();
        toComboBox = new JComboBox<>();
    }

    public void refreshComboBoxes(Currencies currencies) {
        fromComboBoxModel = new DefaultComboBoxModel<>();
        toComboBoxModel = new DefaultComboBoxModel<>();
        for (CurrencyItem item : currencies.getCurrencies()) {
            fromComboBoxModel.addElement(item.getCc() + " (" + item.getTxt() + ")");
            toComboBoxModel.addElement(item.getCc() + " (" + item.getTxt() + ")");
        }
        fromComboBox.removeAllItems();
        fromComboBox.setModel(fromComboBoxModel);
        toComboBox.removeAllItems();
        toComboBox.setModel(toComboBoxModel);
    }

    public JComboBox<String> getFromComboBox() {
        return fromComboBox;
    }

    public JComboBox<String> getToComboBox() {
        return toComboBox;
    }

    public DefaultComboBoxModel<String> getFromComboBoxModel() {
        return fromComboBoxModel;
    }

    public DefaultComboBoxModel<String> getToComboBoxModel() {
        return toComboBoxModel;
    }

    public void swapSelectedItemsInComboBox() {
        int selectedIndex = fromComboBox.getSelectedIndex();
        fromComboBox.setSelectedIndex(toComboBox.getSelectedIndex());
        toComboBox.setSelectedIndex(selectedIndex);
    }
}
