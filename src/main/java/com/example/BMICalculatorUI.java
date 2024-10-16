package com.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BMICalculatorUI {

    private TextField weightMetricField, heightMetricField; // Поля для метрической системы
    private TextField weightImperialField, heightImperialField; // Поля для английской системы
    private Label metricResultLabel; // Метка для результата метрической системы
    private Label imperialResultLabel; // Метка для результата английской системы

    public VBox getLayout() {
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10, 10, 10, 20));

        // Ввод веса и роста для метрической системы
        Label weightMetricLabel = new Label("Weight (kg):");
        weightMetricField = new TextField();

        Label heightMetricLabel = new Label("Height (cm):");
        heightMetricField = new TextField();

        // Кнопка для расчета ИМТ для метрической системы
        Button calculateMetricButton = new Button("Calculate Metric BMI");
        calculateMetricButton.setOnAction(e -> calculateMetricBMI());

        // Отображение результата
        metricResultLabel = new Label("Your Metric BMI will appear here.");

        // Ввод веса и роста для английской системы
        Label weightImperialLabel = new Label("Weight (lbs):");
        weightImperialField = new TextField();

        Label heightImperialLabel = new Label("Height (inches):");
        heightImperialField = new TextField();

        // Кнопка для расчета ИМТ для английской системы
        Button calculateImperialButton = new Button("Calculate Imperial BMI");
        calculateImperialButton.setOnAction(e -> calculateImperialBMI());

        // Отображение результата
        imperialResultLabel = new Label("Your Imperial BMI will appear here.");

        GridPane metricGrid = new GridPane();
        metricGrid.setVgap(10);
        metricGrid.setHgap(28);
        metricGrid.addRow(0, weightMetricLabel, weightMetricField);
        metricGrid.addRow(1, heightMetricLabel, heightMetricField);
        metricGrid.add(calculateMetricButton, 1, 2);
        metricGrid.add(metricResultLabel, 1, 3);

        GridPane imperialGrid = new GridPane();
        imperialGrid.setVgap(10);
        imperialGrid.setHgap(10);
        imperialGrid.addRow(0, weightImperialLabel, weightImperialField);
        imperialGrid.addRow(1, heightImperialLabel, heightImperialField);
        imperialGrid.add(calculateImperialButton, 1, 2);
        imperialGrid.add(imperialResultLabel, 1, 3);


        layout.getChildren().addAll(metricGrid, imperialGrid);
        return layout;
    }

    // Метод для расчета ИМТ по метрической системе
    private void calculateMetricBMI() {
        double bmiMetric = 0;
        try {
            double weight = Double.parseDouble(weightMetricField.getText());
            double height = Double.parseDouble(heightMetricField.getText()) / 100; // Преобразование см в метры
            bmiMetric = weight / (height * height);
            metricResultLabel.setText(String.format("Your Metric BMI is: %.2f (%s)", bmiMetric, getBMIStatus(bmiMetric)));
        } catch (NumberFormatException e) {
            metricResultLabel.setText("Please enter valid numbers for metric.");
        }
    }

    // Метод для расчета ИМТ по английской системе
    private void calculateImperialBMI() {
        double bmiImperial = 0;
        try {
            double weight = Double.parseDouble(weightImperialField.getText());
            double height = Double.parseDouble(heightImperialField.getText());
            bmiImperial = (weight / (height * height)) * 703; // Формула для английских единиц
            imperialResultLabel.setText(String.format("Your Imperial BMI is: %.2f (%s)", bmiImperial, getBMIStatus(bmiImperial)));
        } catch (NumberFormatException e) {
            imperialResultLabel.setText("Please enter valid numbers for imperial.");
        }
    }

    // Метод для определения статуса ИМТ
    private String getBMIStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }
}
