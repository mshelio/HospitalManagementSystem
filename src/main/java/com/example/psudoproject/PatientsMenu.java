package com.example.psudoproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientsMenu extends Application {
    Patients patient = new Patients();
    LayoutPane style = new LayoutPane();

    public SplitPane leftPane = new SplitPane();
    public GridPane patAddPane = new GridPane();
    public GridPane rightPane = new GridPane();
    public SplitPane main = new SplitPane();
    Scene scene = new Scene(main);
    @Override
    public void start(Stage stage) throws Exception {

        Font generalFont = Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 15);

        // create the panes

        patAddPane.setStyle("-fx-background-color: aliceblue");

        Label addLabel = new Label("Add Patient");
        addLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 20));
        addLabel.setTextFill(Color.DARKBLUE);
        patAddPane.add(addLabel, 0, 0);


        Label patFirstname = new Label("Patient Firstname");
        patFirstname.setFont(generalFont);

        Label patLastname = new Label("Patient Lastname");
        patLastname.setFont(generalFont);

        Label patNumber = new Label("Patient Phone Number");
        patNumber.setFont(generalFont);

        Label patEmail = new Label("Patient Email");
        patEmail.setFont(generalFont);

        Label patDiagnosis = new Label("Patient Diagnosis");
        patDiagnosis.setFont(generalFont);

        patAddPane.add(patFirstname, 0, 1);
        patAddPane.add(patLastname, 0, 2);
        patAddPane.add(patNumber, 0, 3);
        patAddPane.add(patEmail, 0, 4);
        patAddPane.add(patDiagnosis, 0, 5);

        TextField patFirstnameTF = new TextField();
        patFirstnameTF.setFont(generalFont);
        patFirstnameTF.setPromptText("Firstname");
        patFirstnameTF.setStyle("-fx-stroke: darkblue");
        style.tfStyle(patFirstnameTF);

        TextField patLastnameTF = new TextField();
        patLastnameTF.setFont(generalFont);
        patLastnameTF.setPromptText("Lastname");
        style.tfStyle(patLastnameTF);

        TextField patNumberTF = new TextField();
        patNumberTF.setFont(generalFont);
        patNumberTF.setPromptText("Phone Number");
        style.tfStyle(patNumberTF);

        TextField patEmailTF = new TextField();
        patEmailTF.setFont(generalFont);
        patEmailTF.setPromptText("Email");
        style.tfStyle(patEmailTF);

        TextArea patDiagnosisTA = new TextArea();
        patDiagnosisTA.setFont(generalFont);
        patDiagnosisTA.setPrefWidth(200);
        patDiagnosisTA.setPrefHeight(100);
        patDiagnosisTA.setPromptText("Diagnosis...");
        style.taStyle(patDiagnosisTA);

        patAddPane.add(patFirstnameTF, 1, 1);
        patAddPane.add(patLastnameTF, 1, 2);
        patAddPane.add(patNumberTF, 1, 3);
        patAddPane.add(patEmailTF, 1, 4);
        patAddPane.add(patDiagnosisTA, 1, 5);
        patAddPane.setHgap(10);
        patAddPane.setVgap(5);

        Button patSubmitBt = new Button("Submit");
        patSubmitBt.setFont(generalFont);
        style.btStyle(patSubmitBt);

        Button patClearBt = new Button("Clear");
        patClearBt.setFont(generalFont);
        style.btStyle(patClearBt);
        patClearBt.setOnAction(e -> {
            style.tfStyle(patFirstnameTF);
            patFirstnameTF.clear();
            patFirstnameTF.setPromptText("Firstname");

            style.tfStyle(patLastnameTF);
            patLastnameTF.clear();
            patLastnameTF.setPromptText("Lastname");

            style.tfStyle(patNumberTF);
            patNumberTF.clear();
            patNumberTF.setPromptText("Phone Number");

            style.tfStyle(patEmailTF);
            patEmailTF.clear();
            patEmailTF.setPromptText("Email");

            style.taStyle(patDiagnosisTA);
            patDiagnosisTA.clear();
        });

        patAddPane.add(patSubmitBt, 0, 6);
        patAddPane.add(patClearBt, 1, 6);
        patAddPane.setAlignment(Pos.CENTER);
//----------------------------------------------------------------------------------------------------------------------
        GridPane editPane = new GridPane();
        editPane.setStyle("-fx-background-color: aliceblue;");

        Label editLabel = new Label("Edit Patient");
        editLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 20));
        editLabel.setTextFill(Color.DARKBLUE);

        Label editIdLabel = new Label("Enter the ID");
        editIdLabel.setFont(generalFont);

        TextField editIdTf = new TextField();
        editIdTf.setPromptText("Patient ID");
        editIdTf.setFont(generalFont);
        style.tfStyle(editIdTf);

        Label editFirstnameLabel = new Label("Edit Firstname");
        editFirstnameLabel.setFont(generalFont);

        TextField editFirstname = new TextField();
        editFirstname.setPromptText("Edit Firstname");
        editFirstname.setFont(generalFont);
        style.tfStyle(editFirstname);

        Label editLastnameLabel = new Label("Edit Lastname");
        editLastnameLabel.setFont(generalFont);

        TextField editLastname = new TextField();
        editLastname.setPromptText("Edit Lastname");
        editLastname.setFont(generalFont);
        style.tfStyle(editLastname);

        Label editPhoneLabel = new Label("Edit Phone Number");
        editPhoneLabel.setFont(generalFont);

        TextField editPhone = new TextField();
        editPhone.setPromptText("Edit Phone Number");
        editPhone.setFont(generalFont);
        style.tfStyle(editPhone);

        Label editEmailLabel = new Label("Edit Email");
        editEmailLabel.setFont(generalFont);

        TextField editEmail = new TextField();
        editEmail.setPromptText("Edit Email");
        editEmail.setFont(generalFont);
        style.tfStyle(editEmail);

        Label editDiagnosisLabel = new Label("Edit Diagnosis");
        editDiagnosisLabel.setFont(generalFont);

        TextArea editDiagnosis = new TextArea();
        editDiagnosis.setPromptText("Edit Diagnosis");
        editDiagnosis.setFont(generalFont);
        style.taStyle(editDiagnosis);


        Button deleteButton = new Button("Delete");
        deleteButton.setFont(generalFont);
        style.btStyle(deleteButton);

        Button updateButton = new Button("Update");
        updateButton.setFont(generalFont);
        style.btStyle(updateButton);

        editDiagnosis.setPrefWidth(200);
        editDiagnosis.setPrefHeight(100);


        editPane.add(editLabel, 0, 1);
        editPane.add(editIdLabel, 0, 2);
        editPane.add(editIdTf, 1, 2);
        editPane.add(editFirstnameLabel, 0, 3);
        editPane.add(editFirstname, 1, 3);
        editPane.add(editLastnameLabel, 0, 4);
        editPane.add(editLastname, 1, 4);
        editPane.add(editPhoneLabel, 0, 5);
        editPane.add(editPhone, 1, 5);
        editPane.add(editEmailLabel, 0, 6);
        editPane.add(editEmail, 1, 6);
        editPane.add(editDiagnosisLabel, 0, 7);
        editPane.add(editDiagnosis, 1, 7);
        editPane.add(updateButton, 0, 8);
        editPane.add(deleteButton, 1, 8);
        editPane.setAlignment(Pos.CENTER);
        editLabel.setAlignment(Pos.TOP_CENTER);
        editPane.setHgap(10);
        editPane.setVgap(10);
        viewPatient(editIdTf, editFirstname, editLastname, editPhone, editEmail, editDiagnosis, deleteButton, updateButton);
//----------------------------------------------------------------------------------------------------------------------

        rightPane.setStyle("-fx-background-color: lightblue");
        rightPane.setAlignment(Pos.CENTER);


        // create the split panes

        leftPane.getItems().addAll(patAddPane, editPane);
        leftPane.setOrientation(Orientation.VERTICAL);

        main.getItems().addAll(leftPane, rightPane);

        TableView<Patients> patientsTableView = new TableView<>();
        patientsTableView.setPrefWidth(600);

        TableColumn<Patients, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Patients, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));

        TableColumn<Patients, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));

        TableColumn<Patients, String> phoneCol = new TableColumn<>("Phone Number");
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Patients, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Patients, String> diagnosisCol = new TableColumn<>("Diagnosis");
        diagnosisCol.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));

        patientsTableView.getColumns().addAll(idCol, firstNameCol, lastNameCol, phoneCol, emailCol, diagnosisCol);

        refreshTable(patientsTableView);

        TextField searchField = new TextField();
        searchField.setFont(generalFont);
        style.tfStyle(searchField);

        Button searchButton = new Button();
        style.btStyle(searchButton);
        searchButton.setFont(generalFont);
        Image searchImg = new Image("https://cdn-icons-png.flaticon.com/128/151/151773.png");
        ImageView searchImgView = new ImageView(searchImg);
        searchImgView.setFitWidth(20);
        searchImgView.setFitHeight(20);
        searchButton.setGraphic(searchImgView);

        Button xButton =  new Button();
        style.btStyle(xButton);
        xButton.setFont(generalFont);
        ImageView xImgView = new ImageView(new Image("https://cdn-icons-png.flaticon.com/128/2976/2976286.png"));
        xImgView.setFitHeight(20);
        xImgView.setFitWidth(20);
        xButton.setGraphic(xImgView);

        Label searchLbl = new Label("Search");
        searchLbl.setFont(generalFont);

//        rightPane.add(searchLbl, 0, 0);
        rightPane.add(searchField, 1, 0);
        rightPane.add(searchButton, 2, 0);
        rightPane.add(xButton, 3, 0);
        rightPane.add(patientsTableView, 0, 1, 3, 1);


        patSubmitBt.setOnAction(e -> {
            insertPatient(patient, patFirstnameTF, patLastnameTF, patNumberTF, patEmailTF, patDiagnosisTA);
            refreshTable(patientsTableView);
        });

        deleteButton.setOnAction(e -> {
            deletePatient(editIdTf);
            refreshTable(patientsTableView);
        });

        updateButton.setOnAction( e -> {
            updatePatient(deleteButton, updateButton, editFirstname, editLastname, editEmail, editDiagnosis, editIdTf, editPhone, patientsTableView);
        });


        searchButton.setOnAction( e -> {
            searchPatients(patientsTableView, searchField);
        });

        xButton.setOnAction( e -> {
            refreshTable(patientsTableView);
            searchField.clear();
        });

        // create the scene and show the stage
//        Scene scene = new Scene(main);
        stage.setMaximized(true);
        stage.getIcons().add(new Image("https://static.thenounproject.com/png/2071020-200.png"));
        stage.setTitle("Patients");
        stage.setScene(scene);
        stage.show();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void insertPatient(Patients patient, TextField patFname, TextField patLname, TextField patPhone, TextField patEmail, TextArea patDiag) {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        // Check for empty fields
        if (patFname.getText().isEmpty()){
            style.tfErrorStyle(patFname);
            patFname.clear();
            patFname.setPromptText("Cannot be empty!");
//            return;
        } else {
            style.tfSuccessStyle(patFname);
            patient.setFirstname(patFname.getText());
        }

        if (patLname.getText().isEmpty()) {
            style.tfErrorStyle(patLname);
            patLname.clear();
            patLname.setPromptText("Cannot be empty!");
//            return;
        } else {
            style.tfSuccessStyle(patLname);
            patient.setLastname(patLname.getText());
        }

        if (patPhone.getText().isEmpty()){
            style.tfErrorStyle(patPhone);
            patPhone.clear();
            patPhone.setPromptText("Cannot be empty!");
//            return;
        }
        else if (!patPhone.getText().matches("\\d{8}")) {
            style.tfErrorStyle(patPhone);
            patPhone.setPromptText("Invalid Format");
//            return;
        }
        else {
            style.tfSuccessStyle(patPhone);
            patient.setPhoneNumber(patPhone.getText());
        }
        if ((!(patEmail.getText().isEmpty())) && (patEmail.getText().contains("@") && patEmail.getText().contains("."))){
            style.tfSuccessStyle(patEmail);
            patient.setEmail(patEmail.getText());
        }
        else {
            style.tfErrorStyle(patEmail);
            patEmail.clear();
        }
        patient.setDiagnosis(patDiag.getText());

        // Check if a record with the same first name, last name, and phone number already exists
        try {
            String query = "SELECT * FROM patients WHERE first_name = ? AND last_name = ? AND phone_number = ?";
            PreparedStatement stmt = connectDB.prepareStatement(query);
            stmt.setString(1, patient.getFirstname());
            stmt.setString(2, patient.getLastname());
            stmt.setString(3, patient.getPhoneNumber());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // A record with the same first name, last name, and phone number already exists
                style.tfErrorStyle(patFname);
                style.tfErrorStyle(patLname);
                style.tfErrorStyle(patPhone);
                patFname.setPromptText("Duplicate record");
                patLname.setPromptText("Duplicate record");
                patPhone.setPromptText("Duplicate record");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Insert the patient record
        try {
            connectDB.setAutoCommit(false); // start transaction

            String query = "INSERT INTO patients (first_name, last_name, phone_number, email, diagnosis) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stmt = connectDB.prepareStatement(query);
            stmt.setString(1, patient.getFirstname());
            stmt.setString(2, patient.getLastname());
            stmt.setString(3, patient.getPhoneNumber());
            stmt.setString(4, patient.getEmail());
            stmt.setString(5, patient.getDiagnosis());

            stmt.executeUpdate();
            System.out.println("Patient data inserted successfully!");
            patFname.setText("");
            patLname.setText("");
            patPhone.setText("");
            patEmail.setText("");
            patDiag.setText("");
            connectDB.commit(); // commit transaction

        } catch (Exception e) {
            e.printStackTrace();
            try {
                connectDB.rollback(); // rollback transaction if there's an exception
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // Close the database connection
            if (connectDB != null) {
                try {
                    connectDB.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
public void deletePatient(TextField patientIdTf) {
    int patientId;

    if (patientIdTf.getText().isEmpty()) {
        style.tfErrorStyle(patientIdTf);
        return;
    } else {
        patientId = Integer.parseInt(patientIdTf.getText());
    }

    try (Connection conn = new DatabaseConnection().getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM patients WHERE ins_id = ?");
         PreparedStatement isAStmt = conn.prepareStatement("DELETE FROM is_a WHERE ins_id = ?");
         PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM patients WHERE ins_id = ?");
         PreparedStatement traumataStmt = conn.prepareStatement("DELETE FROM traumata WHERE ins_id = ?");
         PreparedStatement deleteExam = conn.prepareStatement("DELETE FROM examinations WHERE ins_id = ?")) {

        // Check if patient exists in the database
        stmt.setInt(1, patientId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Delete patient from is_a table
            isAStmt.setInt(1, patientId);
            int rowsAffected = isAStmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted from is_a table.");

            // Delete examinations associated with patient
            deleteExam.setInt(1, patientId);
            rowsAffected = deleteExam.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted from examinations table.");

            // Delete traumata associated with patient
            traumataStmt.setInt(1, patientId);
            rowsAffected = traumataStmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted from traumata table.");

            // Delete patient from patients table
            deleteStmt.setInt(1, patientId);
            rowsAffected = deleteStmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted from patients table.");

        } else {
            System.out.println("No patient found with ID " + patientId);
        }

        rs.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}



//----------------------------------------------------------------------------------------------------------------------
    public ObservableList<Patients> getAllPatients() throws SQLException {
        ObservableList<Patients> patientsList = FXCollections.observableArrayList();
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String query = "SELECT * FROM patients";
        Statement statement = connectDB.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Patients patient = new Patients();
            patient.setId(resultSet.getInt(1));
            patient.setFirstname(resultSet.getString(2));
            patient.setLastname(resultSet.getString(3));
            patient.setPhoneNumber(resultSet.getString(4));
            patient.setEmail(resultSet.getString(5));
            patient.setDiagnosis(resultSet.getString(6));
            patientsList.add(patient);
        }

        resultSet.close();
        statement.close();
        connectDB.close();

        return patientsList;
    }
//----------------------------------------------------------------------------------------------------------------------
    public void refreshTable(TableView<Patients> tableView) {
        try {
            ObservableList<Patients> patientsList = getAllPatients();
            tableView.setItems(patientsList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    private void searchPatients(TableView<Patients> tableView, TextField searchField) {
        // get search query from text field
        String query = searchField.getText().trim();

        // perform search in database
        List<Patients> patients = new ArrayList<>();
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        try {
            String sql = "SELECT * FROM patients WHERE first_name LIKE ? OR last_name LIKE ?";
            PreparedStatement stmt = connectDB.prepareStatement(sql);
            stmt.setString(1, "%" + query + "%");
            stmt.setString(2, "%" + query + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Patients patient = new Patients();
                patient.setId(rs.getInt(1));
                patient.setFirstname(rs.getString(2));
                patient.setLastname(rs.getString(3));
                patient.setPhoneNumber(rs.getString(4));
                patient.setEmail(rs.getString(5));
                patient.setDiagnosis(rs.getString(6));
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connectDB != null) {
                try {
                    connectDB.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // update table view with search results
        tableView.getItems().clear();
        tableView.getItems().addAll(patients);
    }
//----------------------------------------------------------------------------------------------------------------------

    public void viewPatient(TextField editId, TextField editFirstname, TextField editLastname, TextField editPhone, TextField editEmail, TextArea editDiagnosis, Button deleteButton, Button updateButton) throws SQLException {
        editId.setOnKeyReleased( e-> {
            try {
                if (editId.getText().isEmpty()) {
                    editFirstname.clear();
                    editLastname.clear();
                    editPhone.clear();
                    editEmail.clear();
                    editDiagnosis.clear();
                } else {
                    int id = Integer.parseInt(editId.getText());
                    DatabaseConnection connection = new DatabaseConnection();
                    Connection conn = connection.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(
                            "SELECT * FROM patients WHERE ins_id=?");
                    stmt.setInt(1, id);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        deleteButton.setDisable(false);
                        updateButton.setDisable(false);

                        editFirstname.setText(rs.getString("first_name"));
                        editLastname.setText(rs.getString("last_name"));
                        editPhone.setText(rs.getString("phone_number"));
                        editEmail.setText(rs.getString("email"));
                        editDiagnosis.setText(rs.getString("diagnosis"));
                    }else {
                        // Disable buttons if the ID doesn't exist
                        deleteButton.setDisable(true);
                        updateButton.setDisable(true);

                        // Clear text fields and text area
                        editFirstname.clear();
                        editLastname.clear();
                        editPhone.clear();
                        editEmail.clear();
                        editDiagnosis.clear();
                    }
                    stmt.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void updatePatient(Button deleteButton, Button updateButton, TextField editFirstname, TextField editLastname, TextField editEmail, TextArea editDiagnosis, TextField editIdTf, TextField editPhone, TableView<Patients> patientsTableView){
        try {
            patient.setId(Integer.parseInt(editIdTf.getText()));
            DatabaseConnection connection = new DatabaseConnection();
            Connection conn = connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM patients WHERE ins_id=?");
            stmt.setInt(1, patient.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // enable the delete and update buttons
                deleteButton.setDisable(false);
                updateButton.setDisable(false);

                // get the patient data from the text fields
                patient.setFirstname(editFirstname.getText());
                patient.setLastname(editLastname.getText());
                patient.setPhoneNumber(editPhone.getText());
                patient.setEmail(editEmail.getText());
                patient.setDiagnosis(editDiagnosis.getText());

                // update the patient data in the database
                PreparedStatement updateStmt = conn.prepareStatement(
                        "UPDATE patients SET first_name=?, last_name=?, phone_number=?, email=?, diagnosis=? WHERE ins_id=?");
                updateStmt.setString(1, patient.getFirstname());
                updateStmt.setString(2, patient.getLastname());
                updateStmt.setString(3, patient.getPhoneNumber());
                updateStmt.setString(4, patient.getEmail());
                updateStmt.setString(5, patient.getDiagnosis());
                updateStmt.setInt(6, patient.getId());

                int rows = updateStmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Patient with ID " + patient.getId() + " updated successfully!");
                } else {
                    System.out.println("Failed to update patient with ID " + patient.getId());
                }
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
        refreshTable(patientsTableView);
    }

    public static void main(String[] args) {
        launch(args);
    }
}