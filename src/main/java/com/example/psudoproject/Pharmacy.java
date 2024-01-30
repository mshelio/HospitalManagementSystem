package com.example.psudoproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.SplitPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.Flow;

public class Pharmacy extends FlowPane {

    private ImageView photoImageView;
    private Label nameLabel;
    private Label quantityLabel;
    private Label expiryDateLabel;
    private Label productionDateLabel;
    private Label priceLabel;
    private int cartTotal;
    private Map<String, Integer> cartItems;
    LayoutPane style = new LayoutPane();
    Button addBtn = new Button("+");
    Button removeBtn = new Button("-");
    TextField numberTF = new TextField("0");

    public Pharmacy() {
        // Initialize UI components
        photoImageView = new ImageView();
        nameLabel = new Label();
        quantityLabel = new Label();
        expiryDateLabel = new Label();
        productionDateLabel = new Label();
        priceLabel = new Label();
        Button addBtn = new Button("+");
        Button removeBtn = new Button("-");
        TextField numberTF = new TextField("0");

        // Set up UI layout
        FlowPane medicationCard = new FlowPane();
        medicationCard.setStyle("-fx-border-color: darkblue; -fx-border-width: 2px; -fx-border-radius: 5px");
        VBox medInfo = new VBox();
        HBox addAndRemove = new HBox();

        medInfo.setAlignment(Pos.CENTER);
        medInfo.getChildren().addAll(nameLabel, priceLabel, productionDateLabel, expiryDateLabel, quantityLabel, addAndRemove);
        medicationCard.getChildren().addAll(photoImageView, medInfo);
        medicationCard.setAlignment(Pos.CENTER);

        this.getChildren().addAll(medicationCard);
    }

    public void setMedicationData(Medications medication) {
        // Set data for UI components based on the medication object
        nameLabel.setText("Name: " + medication.getName());
        quantityLabel.setText("Quantity: " + medication.getQuantity());
        expiryDateLabel.setText("Expiry Date: " + medication.getExpiryDate().toString());
        productionDateLabel.setText("Production Date: " + medication.getProductionDate().toString());
        priceLabel.setText("Price: $" + medication.getPrice());

        // Set photo image
        Image image = new Image(medication.getPhotoLink());
        photoImageView.setFitWidth(150);
        photoImageView.setFitHeight(150);
        photoImageView.setImage(image);
    }


    public ImageView getPhotoImageView() {
        return photoImageView;
    }

    public Label getExpiryDateLabel() {
        return expiryDateLabel;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public Label getPriceLabel() {
        return priceLabel;
    }

    public Label getProductionDateLabel() {
        return productionDateLabel;
    }

    public Label getQuantityLabel() {
        return quantityLabel;
    }

    public void setExpiryDateLabel(Label expiryDateLabel) {
        this.expiryDateLabel = expiryDateLabel;
    }

    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    public void setPhotoImageView(ImageView photoImageView) {
        this.photoImageView = photoImageView;
    }

    public void setPriceLabel(Label priceLabel) {
        this.priceLabel = priceLabel;
    }

    public void setProductionDateLabel(Label productionDateLabel) {
        this.productionDateLabel = productionDateLabel;
    }

    public void setQuantityLabel(Label quantityLabel) {
        this.quantityLabel = quantityLabel;
    }

}
