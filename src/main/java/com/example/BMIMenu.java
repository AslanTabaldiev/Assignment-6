package com.example;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.application.Platform;
import javafx.scene.control.TextField;

public class BMIMenu {

    public static MenuBar createMenu() {
        MenuBar menuBar = new MenuBar();

        // File Menu
        Menu fileMenu = new Menu("File");
        MenuItem clearItem = new MenuItem("Clear");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> Platform.exit());

        fileMenu.getItems().addAll(clearItem, exitItem);

        // Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem helpItem = new MenuItem("How to use");
        helpMenu.getItems().add(helpItem);

        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return menuBar;
    }
}
