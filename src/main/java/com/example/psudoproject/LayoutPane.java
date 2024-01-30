package com.example.psudoproject;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class LayoutPane extends BorderPane {

    public void makePane() {

        ImageView logo = new ImageView(new Image("C:\\Users\\elioe\\IdeaProjects\\PsudoProject\\Images\\download.png"));
        StackPane logoPane = new StackPane();
        logoPane.getChildren().add(logo);
        System.out.println(logoPane.getHeight());
        logoPane.setStyle("-fx-border-color: darkblue; -fx-border-width: 5px; -fx-background-color: rgba(53,96,171,255); -fx-border-radius: 5px");
        setAlignment(logoPane, Pos.CENTER);
        logo.setFitWidth(logoPane.getWidth());
        setTop(logoPane);
    }


    public void tfStyle(TextField textField) {
        textField.setStyle("-fx-background-color: white; -fx-border-color: darkblue; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px; " +
                "-fx-background-radius: 10px;");

        textField.setFont(generalFont);
    }

    public void taStyle(TextArea textArea) {
        textArea.setStyle("-fx-background-color: white; -fx-border-color: darkblue; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px; " +
                "radius: 10px;");
        textArea.setFont(generalFont);
    }

    public void tfErrorStyle(TextField textField) {
        textField.setStyle("-fx-background-color: white; -fx-border-color: #ff5454; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px; " +
                "-fx-background-radius: 10px;");
    }

    public void dpErrorStyle(DatePicker datePicker) {
        datePicker.setStyle("-fx-font-family: Tahoma; -fx-font-size: 15px; " +
                "-fx-font-style: italic; -fx-font-weight: bold; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px; " +
                "-fx-border-color: #ff5454; -fx-background-radius: 10px;" +
                "-fx-background-color: white");
    }

    public void tfSuccessStyle(TextField textField) {
        textField.setStyle("-fx-background-color: white; -fx-border-color: lightgreen; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px;");
    }

    public void dpSuccessStyle(DatePicker datePicker){
        datePicker.setStyle("-fx-font-family: Tahoma; -fx-font-size: 15px; " +
                "-fx-font-style: italic; -fx-font-weight: bold; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px; " +
                "-fx-border-color: lightgreen; -fx-background-radius: 10px;" +
                "-fx-background-color: white");

    }

    public void btStyle(Button bt) {
        bt.setStyle("-fx-border-color: darkblue; -fx-border-radius: 5px; " +
                "-fx-background-color: white; -fx-border-width: 2px");

        bt.setFont(generalFont);
    }

    public void dpStyle(DatePicker datePicker) {
        datePicker.setStyle("-fx-font-family: Tahoma; -fx-font-size: 15px; " +
                "-fx-font-style: italic; -fx-font-weight: bold; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px; " +
                "-fx-border-color: darkblue; -fx-background-radius: 10px;" +
                "-fx-background-color: white");
    }

    public Font generalFont = Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 15);
    public Font titleFont = Font.font("Tahoma", FontWeight.BOLD, 20);

    public void errorAlert(Alert alert){
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
    public void successAlert(Alert alert){
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.showAndWait();
    }


}
