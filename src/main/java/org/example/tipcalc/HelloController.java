package org.example.tipcalc;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField amountTextField;
    @FXML
    private Slider slider;
    @FXML
    private TextField tipTextField;
    @FXML
    private TextField totalTextField;
    @FXML
    private TextField tipPercentageTextField;

    public void initialize() {
        // Example of a listener
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                // Set the text of tipPercentageTextField to the new value of the slider
                tipPercentageTextField.setText(String.format("%.2f%%", newValue));

                // Calculate tip and total based on the new tip percentage
                double amount = Double.parseDouble(amountTextField.getText());
                double tipPercentage = newValue.doubleValue();
                double tip = amount * (tipPercentage / 100.0);
                double total = amount + tip;

                // Set the text of tipTextField and totalTextField
                tipTextField.setText(String.format("$%.2f", tip));
                totalTextField.setText(String.format("$%.2f", total));
            }
        });
    }
}
