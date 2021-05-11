package gui;

import javax.swing.*;

public class InputFieldsPanel extends JComponent {

    private JPanel inputFieldsPanel;

    private JTextField fromTextField;
    private JButton swapButton;
    private JTextField toTextField;

    private void createUIComponents() {
        swapButton = new JButton("⇄"); // Unicode Hex Character Code &#x21c4
    }

    public JTextField getFromTextField() {
        return fromTextField;
    }

    public JTextField getToTextField() {
        return toTextField;
    }

    public JButton getSwapButton() {
        return swapButton;
    }

    public void swapTextInTextFields() {
        String tempText = fromTextField.getText();
        fromTextField.setText(toTextField.getText());
        toTextField.setText(tempText);
    }
}
