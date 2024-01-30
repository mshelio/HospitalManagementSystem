package com.example.psudoproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MedicationsMenu extends Application {
    LayoutPane style = new LayoutPane();
    Medications medication = new Medications();
    @Override
    public void start(Stage stage) throws Exception {

        // create the panes
        GridPane leftTopPane = new GridPane();
        leftTopPane.setStyle("-fx-background-color: aliceblue;");

        Label addMedLbl = new Label("Add Medications");
        addMedLbl.setFont(style.titleFont);
        addMedLbl.setStyle("-fx-text-fill: darkblue");

        leftTopPane.add(addMedLbl, 0, 0);

        Label addSNLbl = new Label("Serial Number");
        addSNLbl.setFont(style.generalFont);

        TextField addSN = new TextField();
        style.tfStyle(addSN);
        addSN.setPromptText("Serial Number");

        Label addNameLbl = new Label("Medication Name");
        addNameLbl.setFont(style.generalFont);

        TextField addName = new TextField();
        style.tfStyle(addName);
        addName.setPromptText("Name");

        Label addQuantityLbl = new Label("Quantity");
        addQuantityLbl.setFont(style.generalFont);

        TextField addQuantity = new TextField();
        style.tfStyle(addQuantity);
        addQuantity.setPromptText("Quantity");

        Label productionLbl = new Label("Production Date");
        productionLbl.setFont(style.generalFont);

        DatePicker productionDate = new DatePicker();
        productionDate.setPromptText("Production Date");
        productionDate.setEditable(false);

        Label expiryLbl = new Label("Expiry Date");
        expiryLbl.setFont(style.generalFont);

        DatePicker expiryDate = new DatePicker();
        expiryDate.setPromptText("Expiry Date");
        expiryDate.setEditable(false);

        Label addPhotoLabel = new Label("Photo Link");
        addPhotoLabel.setFont(style.generalFont);

        TextField addPhoto = new TextField();
        style.tfStyle(addPhoto);
        addPhoto.setPromptText("Link");

        Label priceLabel = new Label("Price/Piece");
        priceLabel.setFont(style.generalFont);

        TextField addPrice = new TextField();
        style.tfStyle(addPrice);
        addPrice.setPromptText("Price");

        expiryDate.setStyle("-fx-font-family: Tahoma; -fx-font-size: 15px; " +
                "-fx-font-style: italic; -fx-font-weight: bold; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px; " +
                "-fx-border-color: darkblue; -fx-background-radius: 10px;" +
                "-fx-background-color: white");

        productionDate.setStyle("-fx-font-family: Tahoma; -fx-font-size: 15px; " +
                "-fx-font-style: italic; -fx-font-weight: bold; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px; " +
                "-fx-border-color: darkblue; -fx-background-radius: 10px;" +
                "-fx-background-color: white");

        StringConverter<LocalDate> converter = new StringConverter<>() {
            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        productionDate.setConverter(converter);
        expiryDate.setConverter(converter);

        Button addMedBtn = new Button("Add");
        style.btStyle(addMedBtn);

        Button addMedClearBtn = new Button("Clear");
        style.btStyle(addMedClearBtn);

        leftTopPane.add(addSNLbl,0, 1);
        leftTopPane.add(addSN, 1, 1);
        leftTopPane.add(addNameLbl, 0, 2);
        leftTopPane.add(addName, 1, 2);
        leftTopPane.add(addQuantityLbl, 0, 3);
        leftTopPane.add(addQuantity, 1, 3);
        leftTopPane.add(productionLbl, 0, 4);
        leftTopPane.add(productionDate, 1, 4);
        leftTopPane.add(expiryLbl, 0, 5);
        leftTopPane.add(expiryDate, 1, 5);
        leftTopPane.add(addPhotoLabel,0, 6);
        leftTopPane.add(addPhoto, 1, 6);
        leftTopPane.add(priceLabel, 0, 7);
        leftTopPane.add(addPrice, 1, 7);
        leftTopPane.add(addMedBtn, 0, 8);
        leftTopPane.add(addMedClearBtn, 1, 8);
        leftTopPane.setAlignment(Pos.CENTER);
        leftTopPane.setHgap(10);
        leftTopPane.setVgap(5);

//----------------------------------------------------------------------------------------------------------------------

        GridPane leftBottomPane = new GridPane();
        leftBottomPane.setStyle("-fx-background-color: aliceblue;");

        Label editMedLbl = new Label("Edit Medications");
        editMedLbl.setFont(style.titleFont);
        editMedLbl.setStyle("-fx-text-fill: darkblue");

        leftBottomPane.add(editMedLbl, 0, 0);

        Label editSNLbl = new Label("Serial Number");
        editSNLbl.setFont(style.generalFont);

        TextField editSN = new TextField();
        style.tfStyle(editSN);
        editSN.setPromptText("Serial Number");

        Label editNameLbl = new Label("Medication Name");
        editNameLbl.setFont(style.generalFont);

        TextField editName = new TextField();
        style.tfStyle(editName);
        editName.setPromptText("Name");

        Label editQuantityLbl = new Label("Edit Quantity");
        editQuantityLbl.setFont(style.generalFont);

        TextField editQuantity = new TextField();
        style.tfStyle(editQuantity);
        editQuantity.setPromptText("Edit Quantity");

        Label editProductionLbl = new Label("Production Date");
        editProductionLbl.setFont(style.generalFont);

        DatePicker editProductionDate = new DatePicker();
        editProductionDate.setPromptText("Production Date");
        editProductionDate.setEditable(false);

        Label editExpiryLbl = new Label("Expiry Date");
        editExpiryLbl.setFont(style.generalFont);

        DatePicker editExpiryDate = new DatePicker();
        editExpiryDate.setPromptText("Expiry Date");
        editExpiryDate.setEditable(false);

        Label editPhotoLabel = new Label("Photo Link");
        editPhotoLabel.setFont(style.generalFont);

        TextField editPhoto = new TextField();
        style.tfStyle(editPhoto);
        editPhoto.setPromptText("Link");

//        FileChooser editPhoto = new FileChooser();
//        editPhoto.setTitle("Choose Medication Image");
//        editPhoto.setO\

        Label editPriceLabel = new Label("Price/Piece");
        editPriceLabel.setFont(style.generalFont);

        TextField editPrice = new TextField();
        style.tfStyle(editPrice);
        editPrice.setPromptText("Price");

        style.dpStyle(productionDate);
        style.dpStyle(expiryDate);

        StringConverter<LocalDate> editConverter = new StringConverter<>() {
            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        editProductionDate.setConverter(editConverter);
        editExpiryDate.setConverter(editConverter);

        Button updateMedBtn = new Button("Update");
        style.btStyle(updateMedBtn);

        Button deleteMedBtn = new Button("Delete");
        style.btStyle(deleteMedBtn);

        style.dpStyle(editProductionDate);
        style.dpStyle(editExpiryDate);

        leftBottomPane.add(editSNLbl,0, 1);
        leftBottomPane.add(editSN, 1, 1);
        leftBottomPane.add(editNameLbl, 0, 2);
        leftBottomPane.add(editName, 1, 2);
        leftBottomPane.add(editQuantityLbl, 0, 3);
        leftBottomPane.add(editQuantity, 1, 3);
        leftBottomPane.add(editProductionLbl, 0, 4);
        leftBottomPane.add(editProductionDate, 1, 4);
        leftBottomPane.add(editExpiryLbl, 0, 5);
        leftBottomPane.add(editExpiryDate, 1, 5);
        leftBottomPane.add(editPhotoLabel,0, 6);
        leftBottomPane.add(editPhoto, 1, 6);
        leftBottomPane.add(editPriceLabel, 0, 7);
        leftBottomPane.add(editPrice, 1, 7);
        leftBottomPane.add(updateMedBtn, 0, 8);
        leftBottomPane.add(deleteMedBtn, 1, 8);
        leftBottomPane.setAlignment(Pos.CENTER);
        leftBottomPane.setHgap(10);
        leftBottomPane.setVgap(5);

        viewMedication(editSN, editName, editQuantity, editProductionDate, editExpiryDate, editPhoto, editPrice, updateMedBtn, deleteMedBtn);

//----------------------------------------------------------------------------------------------------------------------

        GridPane rightPane = new GridPane();
        rightPane.setStyle("-fx-background-color: lightblue;");


//----------------------------------------------------------------------------------------------------------------------
        // create the split panes
        SplitPane leftPane = new SplitPane();
        leftPane.getItems().addAll(leftTopPane, leftBottomPane);
        leftPane.setOrientation(Orientation.VERTICAL);

        TableView<Medications> medTable = new TableView<>();

// Define the columns
        TableColumn<Medications, Integer> snCol = new TableColumn<>("Serial Number");
        snCol.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));

        TableColumn<Medications, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Medications, Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Medications, LocalDate> productionCol = new TableColumn<>("Production Date");
        productionCol.setCellValueFactory(new PropertyValueFactory<>("productionDate"));

        TableColumn<Medications, LocalDate> expiryCol = new TableColumn<>("Expiry Date");
        expiryCol.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));

        TableColumn<Medications, String> photoCol = new TableColumn<>("Photo");
        photoCol.setCellValueFactory(new PropertyValueFactory<>("photoLink"));
        photoCol.setPrefWidth(200);

        TableColumn<Medications, Double> priceCol = new TableColumn<>("Price/Piece");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        medTable.getColumns().addAll(snCol, nameCol, quantityCol, productionCol, expiryCol, photoCol, priceCol);

        rightPane.add(medTable, 0, 0);
        rightPane.setAlignment(Pos.CENTER);
        medTable.setMinWidth(700);
        refreshTable(medTable);

        addMedBtn.setOnAction( e -> {
            insertMedication(medication, addSN, addName, addQuantity, productionDate, expiryDate, addPhoto, addPrice);
            refreshTable(medTable);
        });

        addMedClearBtn.setOnAction( e -> {
            addSN.clear();
            style.tfStyle(addSN);
            addSN.setPromptText("Serial number");

            addName.clear();
            style.tfStyle(addName);
            addName.setPromptText("Name");

            addQuantity.clear();
            style.tfStyle(addQuantity);
            addQuantity.setPromptText("Quantity");

            productionDate.setValue(null);
            style.dpStyle(productionDate);
            productionDate.setPromptText("Production Date");

            expiryDate.setValue(null);
            style.dpStyle(expiryDate);
            editExpiryDate.setPromptText("Expiry Date");

            addPhoto.clear();
            style.tfStyle(addPhoto);
            addPhoto.setPromptText("Photo Link");

            addPrice.clear();
            style.tfStyle(addPrice);
            addPrice.setPromptText("Price/Piece");

            refreshTable(medTable);
        });

        updateMedBtn.setOnAction( e -> {
            updateMed(medTable, deleteMedBtn, updateMedBtn, editName, editSN, editPhoto, editPrice, editQuantity, editExpiryDate, editProductionDate);
        });

        deleteMedBtn.setOnAction( e -> {
            deleteMed(medTable, editName, editSN, editPhoto, editPrice, editQuantity, editExpiryDate, editProductionDate);
        });

//----------------------------------------------------------------------------------------------------------------------

        SplitPane main = new SplitPane();
        main.getItems().addAll(leftPane, rightPane);

        // create the scene and show the stage
        Scene scene = new Scene(main);
        stage.setTitle("Medications");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
//----------------------------------------------------------------------------------------------------------------------
    public void insertMedication(Medications medication, TextField snTF, TextField name, TextField quantity, DatePicker prod, DatePicker exp, TextField photo, TextField price){

        if (snTF.getText().isEmpty()){
            style.tfErrorStyle(snTF);
            snTF.setPromptText("Cannot be empty!");
        } else if (!snTF.getText().matches("\\d+")) {
            style.tfErrorStyle(snTF);
            snTF.setText("");
            snTF.setPromptText("Please enter only integers!");
        } else {
            medication.setSerialNumber(Integer.parseInt(snTF.getText()));
            style.tfSuccessStyle(snTF);
            snTF.setPromptText("");
        }

        if (name.getText().isEmpty()) {
            style.tfErrorStyle(name);
            name.setPromptText("Cannot be empty!");
        } else {
            medication.setName(name.getText());
            style.tfSuccessStyle(name);
            name.setPromptText("");
        }

        if (quantity.getText().isEmpty()){
            quantity.setPromptText("Cannot be empty!");
            style.tfErrorStyle(quantity);
        } else if (!quantity.getText().matches("\\d+")){
            style.tfErrorStyle(quantity);
            quantity.setPromptText("Please enter only integers!");
            quantity.setText("");
        } else {
            medication.setQuantity(Integer.parseInt(quantity.getText()));
            style.tfSuccessStyle(quantity);
            quantity.setPromptText("");
        }

        LocalDate prodValue = prod.getValue();
        LocalDate expValue = exp.getValue();

        if (prodValue == null) {
            style.dpErrorStyle(prod);
            prod.setPromptText("Production date cannot be empty!");
        } else if (expValue != null && prodValue.isAfter(expValue)) {
            style.dpErrorStyle(prod);
            prod.setPromptText("Production date cannot be after expiry date!");
        } else if (prodValue.isAfter(LocalDate.now())) {
            style.dpErrorStyle(prod);
            prod.setPromptText("Production date cannot be in the future!");
        } else {
            style.dpSuccessStyle(prod);
            medication.setProductionDate(prodValue);
        }

        if (expValue == null) {
            style.dpErrorStyle(exp);
            exp.setPromptText("Expiry date cannot be empty!");
        } else if (expValue.isBefore(LocalDate.now())) {
            style.dpErrorStyle(exp);
            exp.setPromptText("Expiry date cannot be in the past!");
        } else if (prodValue != null && expValue.isBefore(prodValue)) {
            style.dpErrorStyle(exp);
            exp.setPromptText("Expiry date cannot be before production date!");
        } else {
            style.dpSuccessStyle(exp);
            medication.setExpiryDate(expValue);
        }


        if (photo.getText().isEmpty()){
            style.tfErrorStyle(photo);
            photo.setPromptText("Cannot be empty!");
        } else {
            medication.setPhotoLink(photo.getText());
            style.tfSuccessStyle(photo);
        }

        if (price.getText().isEmpty()){
            medication.setPrice(0.0f);
        } else {
            try {
                float priceValue = Float.parseFloat(price.getText());
                medication.setPrice(priceValue);
                style.tfSuccessStyle(price);
            } catch (NumberFormatException e) {
                style.tfErrorStyle(price);
                price.setText("");
                price.setPromptText("Please enter a number!");
            }
        }
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        try {
            connectDB.setAutoCommit(false); // set auto-commit to false to start transaction

            // check if the serial number already exists in the database
            PreparedStatement checkStmt = connectDB.prepareStatement("SELECT * FROM medications WHERE medication_sn = ?");
            checkStmt.setInt(1, medication.getSerialNumber());
            ResultSet resultSet = checkStmt.executeQuery();
            if (resultSet.next()) {
                style.tfErrorStyle(snTF);
                snTF.setText("");
                snTF.setPromptText("Serial number already exists!");
                return;
            }

            // insert data into medications table
            PreparedStatement insertStmt = connectDB.prepareStatement("INSERT INTO medications (medication_sn, medication_name, quantity, expiry_date, production_date, photo, price_per_piece) VALUES (?, ?, ?, ?, ?, ?, ?)");
            insertStmt.setInt(1, medication.getSerialNumber());
            insertStmt.setString(2, medication.getName());
            insertStmt.setInt(3, medication.getQuantity());
            insertStmt.setDate(4, Date.valueOf(medication.getExpiryDate()));
            insertStmt.setDate(5, Date.valueOf(medication.getProductionDate()));
            insertStmt.setString(6, medication.getPhotoLink());
            insertStmt.setFloat(7, medication.getPrice());
            insertStmt.executeUpdate();

            connectDB.commit(); // commit the transaction
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            style.successAlert(alert1);
            alert1.setContentText("Medication Added Successfully");

        } catch (SQLException e) {
            try {
                connectDB.rollback(); // rollback the transaction if an exception occurs
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            style.errorAlert(alert2);
            e.printStackTrace();
        } finally {
            try {
                connectDB.setAutoCommit(true); // set auto-commit back to true after transaction is completed
                connectDB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public void viewMedication(TextField editSN, TextField editName, TextField editQuantity,
                               DatePicker editProductionDate, DatePicker editExpiryDate, TextField editPhoto,
                               TextField editPrice, Button updateMedBtn, Button deleteMedBtn) {


        editSN.setOnKeyReleased(e -> {
            try {
                if (editSN.getText().isEmpty()) {
                    editName.clear();
                    editQuantity.clear();
                    editProductionDate.setValue(null);
                    editExpiryDate.setValue(null);
                    editPhoto.clear();
                    editPrice.clear();
                    deleteMedBtn.setDisable(true);
                    updateMedBtn.setDisable(true);
                } else {
                    medication.setSerialNumber(Integer.parseInt(editSN.getText()));

                    DatabaseConnection connection = new DatabaseConnection();
                    Connection conn = connection.getConnection();

                    PreparedStatement stmt = conn.prepareStatement(
                            "SELECT * FROM medications WHERE medication_sn=?");
                    stmt.setInt(1, medication.getSerialNumber());
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        editName.setText(rs.getString("medication_name"));
                        editQuantity.setText(Integer.toString(rs.getInt("quantity")));
                        editProductionDate.setValue(LocalDate.parse(rs.getString("production_date")));
                        editExpiryDate.setValue(LocalDate.parse(rs.getString("expiry_date")));
                        editPhoto.setText(rs.getString("photo"));
                        editPrice.setText(Float.toString(rs.getFloat("price_per_piece")));
                        deleteMedBtn.setDisable(false);
                        updateMedBtn.setDisable(false);
                    } else {
                        editName.clear();
                        editQuantity.clear();
                        editProductionDate.setValue(null);
                        editExpiryDate.setValue(null);
                        editPhoto.clear();
                        editPrice.clear();
                        deleteMedBtn.setDisable(true);
                        updateMedBtn.setDisable(true);
                    }
                    stmt.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }
//----------------------------------------------------------------------------------------------------------------------
    public ObservableList<Medications> getAllMeds() throws SQLException {
        ObservableList<Medications> medicationsList = FXCollections.observableArrayList();
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String query = "SELECT * FROM medications";
        Statement statement = connectDB.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Medications medication = new Medications();
            medication.setSerialNumber(resultSet.getInt("medication_sn"));
            medication.setName(resultSet.getString("medication_name"));
            medication.setQuantity(resultSet.getInt("quantity"));
            medication.setProductionDate(resultSet.getDate("production_date").toLocalDate());
            medication.setExpiryDate(resultSet.getDate("expiry_date").toLocalDate());
            medication.setPrice(resultSet.getFloat("price_per_piece"));
            medication.setPhotoLink(resultSet.getString("photo"));
            medicationsList.add(medication);
        }

        resultSet.close();
        statement.close();
        connectDB.close();

        return medicationsList;
    }
    public void refreshTable(TableView<Medications> tableView){
        try {
            ObservableList<Medications> medicationsList = getAllMeds();
            tableView.setItems(medicationsList);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    public void updateMed(TableView<Medications> medicationsTableView, Button deleteButton, Button updateButton, TextField editName, TextField editSn, TextField editPhoto, TextField editPrice, TextField editQuantity, DatePicker exp, DatePicker prod){
        try {
            medication.setSerialNumber(Integer.parseInt(editSn.getText()));
            DatabaseConnection connection = new DatabaseConnection();
            Connection conn = connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM medications WHERE medication_sn=?");
            stmt.setInt(1, medication.getSerialNumber());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // enable the delete and update buttons
                deleteButton.setDisable(false);
                updateButton.setDisable(false);

                // get the patient data from the text fields
                if (editSn.getText().isEmpty()){
                    style.tfErrorStyle(editSn);
                    editSn.setPromptText("Cannot be empty!");
                } else if (!editSn.getText().matches("\\d+")) {
                    style.tfErrorStyle(editSn);
                    editSn.setText("");
                    editSn.setPromptText("Please enter only integers!");
                } else {
                    medication.setSerialNumber(Integer.parseInt(editSn.getText()));
                    style.tfSuccessStyle(editSn);
                    editSn.setPromptText("");
                }

                int tempSn = medication.getSerialNumber();

                if (editName.getText().isEmpty()) {
                    style.tfErrorStyle(editName);
                    editName.setPromptText("Cannot be empty!");
                } else {
                    medication.setName(editName.getText());
                    style.tfSuccessStyle(editName);
                    editName.setPromptText("");
                }

                if (editQuantity.getText().isEmpty()){
                    editQuantity.setPromptText("Cannot be empty!");
                    style.tfErrorStyle(editQuantity);
                } else if (!editQuantity.getText().matches("\\d+")){
                    style.tfErrorStyle(editQuantity);
                    editQuantity.setPromptText("Please enter only integers!");
                    editQuantity.setText("");
                } else {
                    medication.setQuantity(Integer.parseInt(editQuantity.getText()));
                    style.tfSuccessStyle(editQuantity);
                    editQuantity.setPromptText("");
                }

                LocalDate prodValue = prod.getValue();
                LocalDate expValue = exp.getValue();

                if (prodValue == null) {
                    style.dpErrorStyle(prod);
                    prod.setPromptText("Production date cannot be empty!");
                } else if (expValue != null && prodValue.isAfter(expValue)) {
                    style.dpErrorStyle(prod);
                    prod.setPromptText("Production date cannot be after expiry date!");
                } else if (prodValue.isAfter(LocalDate.now())) {
                    style.dpErrorStyle(prod);
                    prod.setPromptText("Production date cannot be in the future!");
                } else {
                    style.dpSuccessStyle(prod);
                    medication.setProductionDate(prodValue);
                }

                if (expValue == null) {
                    style.dpErrorStyle(exp);
                    exp.setPromptText("Expiry date cannot be empty!");
                } else if (expValue.isBefore(LocalDate.now())) {
                    style.dpErrorStyle(exp);
                    exp.setPromptText("Expiry date cannot be in the past!");
                } else if (prodValue != null && expValue.isBefore(prodValue)) {
                    style.dpErrorStyle(exp);
                    exp.setPromptText("Expiry date cannot be before production date!");
                } else {
                    style.dpSuccessStyle(exp);
                    medication.setExpiryDate(expValue);
                }


                if (editPhoto.getText().isEmpty()){
                    style.tfErrorStyle(editPhoto);
                    editPhoto.setPromptText("Cannot be empty!");
                } else {
                    medication.setPhotoLink(editPhoto.getText());
                    style.tfSuccessStyle(editPhoto);
                }

                if (editPrice.getText().isEmpty()){
                    medication.setPrice(0.0f);
                } else {
                    try {
                        float priceValue = Float.parseFloat(editPrice.getText());
                        medication.setPrice(priceValue);
                        style.tfSuccessStyle(editPrice);
                    } catch (NumberFormatException e) {
                        style.tfErrorStyle(editPrice);
                        editPrice.setText("");
                        editPrice.setPromptText("Please enter a number!");
                    }
                }

                // update the patient data in the database
                PreparedStatement updateStmt = conn.prepareStatement(
                        "UPDATE medications SET  medication_name=?, quantity=?, expiry_date=?, production_date=?, photo=?, price_per_piece=? WHERE medication_sn=?");
                updateStmt.setString(1, medication.getName());
                updateStmt.setInt(2, medication.getQuantity());
                updateStmt.setDate(3, Date.valueOf(medication.getExpiryDate()));
                updateStmt.setDate(4, Date.valueOf(medication.getProductionDate()));
                updateStmt.setString(5, medication.getPhotoLink());
                updateStmt.setFloat(6, medication.getPrice());
                updateStmt.setInt(7, medication.getSerialNumber());

                int rows = updateStmt.executeUpdate();
                Alert alert;
                if (rows > 0) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Medication updated successfully!");
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Fail");
                    alert.setHeaderText(null);
                    alert.setContentText("Couldn't update successfully!");
                }
                alert.showAndWait();
                updateStmt.close();
            } else {
                // disable the delete and update buttons
                deleteButton.setDisable(true);
                updateButton.setDisable(true);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        refreshTable(medicationsTableView);
    }
//----------------------------------------------------------------------------------------------------------------------
public void deleteMed(TableView<Medications> medicationsTableView, TextField editName, TextField editSn, TextField editPhoto, TextField editPrice, TextField editQuantity, DatePicker exp, DatePicker prod) {
    try {
        medication.setSerialNumber(Integer.parseInt(editSn.getText()));
        DatabaseConnection connection = new DatabaseConnection();
        Connection conn = connection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
                "DELETE FROM medications WHERE medication_sn=?");
        stmt.setInt(1, medication.getSerialNumber());
        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            // Display a success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Medication deleted successfully!");
            alert.showAndWait();

            // Clear text fields and disable buttons
            editSn.clear();
            editSn.setPromptText("Serial Number");
            editName.clear();
            editName.setPromptText("Edit Name");
            editPhoto.clear();
            editPhoto.setPromptText("Edit Photo");
            editQuantity.clear();
                editQuantity.setPromptText("Edit Quantity");
            editPrice.clear();
            editPrice.setPromptText("Edit Price");
            prod.setValue(null);
            exp.setValue(null);

        } else {
            // Display an error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to delete Medication!");
            alert.showAndWait();
        }
        stmt.close();
        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    refreshTable(medicationsTableView);
}
}
