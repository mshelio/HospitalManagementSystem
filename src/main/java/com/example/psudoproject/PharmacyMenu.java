package com.example.psudoproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PharmacyMenu extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: aliceblue");
        root.setVgap(20);
        root.setHgap(20);
        VBox invoice = new VBox();
        invoice.setStyle("-fx-background-color: aliceblue");
        borderPane.setCenter(root);

        medView(root);

        Scene scene = new Scene(borderPane);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void medView(FlowPane root) {
        try {
            DatabaseConnection DBConnection = new DatabaseConnection();
            Connection connection = DBConnection.getConnection();

            String query = "SELECT * FROM medications";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Medications medication = new Medications();
                medication.setSerialNumber(resultSet.getInt(1));
                medication.setName(resultSet.getString(2));
                medication.setQuantity(resultSet.getInt(3));
                medication.setExpiryDate(resultSet.getDate(4).toLocalDate());
                medication.setProductionDate(resultSet.getDate(5).toLocalDate());
                medication.setPhotoLink(resultSet.getString(6));
                medication.setPrice(resultSet.getFloat(7));

                Pharmacy pharmacy = new Pharmacy();
                pharmacy.setMedicationData(medication);
                root.getChildren().add(pharmacy);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
