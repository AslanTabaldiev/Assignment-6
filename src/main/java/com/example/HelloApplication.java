package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    BmiCalculatorController controller;
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 335);

        // Set up the BMI Calculator UI
        BMICalculatorUI bmiUI = new BMICalculatorUI();
        root.setCenter(bmiUI.getLayout());

        // Set up the MenuBar at the top
        MenuBar menuBar = BMIMenu.createMenu();
        root.setTop(menuBar);

        primaryStage.setTitle("BMI Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}