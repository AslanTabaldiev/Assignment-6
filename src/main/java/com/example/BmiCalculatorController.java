package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BmiCalculatorController {

    @FXML
    private TextField weightMetric;

    @FXML
    private TextField heightMetric;

    @FXML
    private TextField weightImperial;

    @FXML
    private TextField heightImperial;

    @FXML
    private Label metricBmiResult;

    @FXML
    private Label imperialBmiResult;

    // Метод для расчета ИМТ
    @FXML
    private void handleCalculateMetric() {
        try {
            double weight = Double.parseDouble(weightMetric.getText());
            double height = Double.parseDouble(heightMetric.getText());
            double bmi = weight / (height * height); // ИМТ для метрических единиц

            metricBmiResult.setText(String.format("Your Metric BMI: %.2f (%s)", bmi, getBmiStatus(bmi)));

        } catch (NumberFormatException e) {
            showAlert("Please enter valid numbers for weight and height in metric units.");
        }
    }

    @FXML
    private void handleCalculateImperial() {
        try {
            double weight = Double.parseDouble(weightImperial.getText());
            double height = Double.parseDouble(heightImperial.getText());
            double bmi = (weight / (height * height)) * 703; // ИМТ для английских единиц

            imperialBmiResult.setText(String.format("Your Imperial BMI: %.2f (%s)", bmi, getBmiStatus(bmi)));

        } catch (NumberFormatException e) {
            showAlert("Please enter valid numbers for weight and height in imperial units.");
        }
    }

    // Метод для определения статуса ИМТ
    private String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal weight";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }

    // Метод для показа сообщений об ошибках
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Метод для очистки полей (если нужен)
    @FXML
    public void handleClear() {
        weightMetric.clear();
        heightMetric.clear();
        weightImperial.clear();
        heightImperial.clear();
    }


    // Метод для закрытия приложения
    @FXML
    public void handleExit() {
        javafx.application.Platform.exit();
    }

    // Метод для отображения помощи
    @FXML
    public void handleHelp() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("How to use");
        alert.setHeaderText(null);
        alert.setContentText("Enter your weight and height, then press 'Calculate BMI' to see your BMI and status.");
        alert.showAndWait();
    }
}
