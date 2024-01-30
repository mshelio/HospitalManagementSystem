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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesMenu extends Application {
    LayoutPane style = new LayoutPane();
    Employees employee = new Employees();

    @Override
    public void start(Stage stage) throws Exception {

        // create the panes
        GridPane leftTopPane = new GridPane();
        leftTopPane.setStyle("-fx-background-color: aliceblue;");

        Label empLabel = new Label("Add Employee");
        empLabel.setFont(style.titleFont);
        empLabel.setTextFill(Color.DARKBLUE);

        Label empFirstname = new Label("Employee Firstname");
        empFirstname.setFont(style.generalFont);

        Label empLastname = new Label("Employee Lastname");
        empLastname.setFont(style.generalFont);

        Label empNumber = new Label("Employee Phone Number");
        empNumber.setFont(style.generalFont);

        Label empEmail = new Label("Employee Email");
        empEmail.setFont(style.generalFont);

        Label empRole = new Label("Employee Role");
        empRole.setFont(style.generalFont);

        leftTopPane.add(empLabel, 0, 0);
        leftTopPane.add(empFirstname, 0, 1);
        leftTopPane.add(empLastname, 0, 2);
        leftTopPane.add(empNumber, 0, 3);
        leftTopPane.add(empEmail, 0, 4);
        leftTopPane.add(empRole, 0, 5);

        TextField empFirstnameTF = new TextField();
        empFirstnameTF.setFont(style.generalFont);
        empFirstnameTF.setPromptText("Firstname");
        empFirstnameTF.setStyle("-fx-stroke: darkblue");
        style.tfStyle(empFirstnameTF);

        TextField empLastnameTF = new TextField();
        empLastnameTF.setFont(style.generalFont);
        empLastnameTF.setPromptText("Lastname");
        style.tfStyle(empLastnameTF);

        TextField empNumberTF = new TextField();
        empNumberTF.setFont(style.generalFont);
        empNumberTF.setPromptText("Phone Number");
        style.tfStyle(empNumberTF);

        TextField empEmailTF = new TextField();
        empEmailTF.setFont(style.generalFont);
        empEmailTF.setPromptText("Email");
        style.tfStyle(empEmailTF);

        TextField empRoleTF = new TextField();
        empRoleTF.setFont(style.generalFont);
        empRoleTF.setPromptText("Role");
        style.tfStyle(empRoleTF);

        leftTopPane.add(empFirstnameTF, 1, 1);
        leftTopPane.add(empLastnameTF, 1, 2);
        leftTopPane.add(empNumberTF, 1, 3);
        leftTopPane.add(empEmailTF, 1, 4);
        leftTopPane.add(empRoleTF, 1, 5);
        leftTopPane.setHgap(10);
        leftTopPane.setVgap(5);

        Button empSubmitBt = new Button("Submit");
        empSubmitBt.setFont(style.generalFont);
        style.btStyle(empSubmitBt);

        Button empClearBt = new Button("Clear");
        empClearBt.setFont(style.generalFont);
        style.btStyle(empClearBt);


        Label empGenderTf = new Label("Gender");
        empGenderTf.setFont(style.generalFont);
        leftTopPane.add(empGenderTf, 0, 6);

        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setFont(style.generalFont);
        maleRadio.setSelected(true);

        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setFont(style.generalFont);

        RadioButton otherRadio = new RadioButton("Other");
        otherRadio.setFont(style.generalFont);

        ToggleGroup genderToggleGroup = new ToggleGroup();
        genderToggleGroup.getToggles().addAll(maleRadio, femaleRadio, otherRadio);

        TextField genderTextField = new TextField();
        genderTextField.setFont(style.generalFont);
        genderTextField.setPromptText("Other gender");
        style.tfStyle(genderTextField);

        HBox radioButtonsBox = new HBox();
        radioButtonsBox.getChildren().addAll(maleRadio, femaleRadio, otherRadio);
// Add the radio buttons and the text field to the grid pane
        leftTopPane.add(radioButtonsBox, 1, 6);
        leftTopPane.add(genderTextField, 2, 6);
        leftTopPane.setAlignment(Pos.CENTER);
        radioButtonsBox.setAlignment(Pos.CENTER);
        genderTextField.setVisible(false);

        maleRadio.setOnAction(e -> {
            genderTextField.setVisible(false);
        });

        femaleRadio.setOnAction(e -> {
            genderTextField.setVisible(false);
        });

        otherRadio.setOnAction(e -> {
            genderTextField.setVisible(true);
        });

        leftTopPane.add(empSubmitBt, 0, 7);
        leftTopPane.add(empClearBt, 1, 7);

        empClearBt.setOnAction(e -> {
            style.tfStyle(empFirstnameTF);
            empFirstnameTF.clear();
            empFirstnameTF.setPromptText("Firstname");

            style.tfStyle(empLastnameTF);
            empLastnameTF.clear();
            empLastnameTF.setPromptText("Lastname");

            style.tfStyle(empNumberTF);
            empNumberTF.clear();
            empNumberTF.setPromptText("Phone Number");

            style.tfStyle(empEmailTF);
            empEmailTF.clear();
            empEmailTF.setPromptText("Email");

            style.tfStyle(empRoleTF);
            empRoleTF.clear();
            empRoleTF.setPromptText("Role");

            genderToggleGroup.selectToggle(maleRadio);
            genderTextField.clear();
            genderTextField.setVisible(false);
        });


//----------------------------------------------------------------------------------------------------------------------
        GridPane leftBottomPane = new GridPane();
        leftBottomPane.setStyle("-fx-background-color: aliceblue;");

        Label empEditlabel = new Label("Edit Employee");
        empEditlabel.setFont(style.titleFont);
        empEditlabel.setTextFill(Color.DARKBLUE);

        Label editIdLabel = new Label("Enter the Id of Employee to Edit");
        editIdLabel.setFont(style.generalFont);

        Label empEditFname = new Label("Edit Firstname");
        empEditFname.setFont(style.generalFont);

        Label empEditLname = new Label("Edit Lastname");
        empEditLname.setFont(style.generalFont);

        Label empEditNumber = new Label("Edit Phone Number");
        empEditNumber.setFont(style.generalFont);

        Label empEditMail = new Label("Edit Email");
        empEditMail.setFont(style.generalFont);

        Label empEditRole = new Label("Edit Role");
        empEditRole.setFont(style.generalFont);

        leftBottomPane.add(empEditlabel, 0, 0);
        leftBottomPane.add(editIdLabel, 0, 1);
        leftBottomPane.add(empEditFname, 0, 2);
        leftBottomPane.add(empEditLname, 0, 3);
        leftBottomPane.add(empEditNumber, 0, 4);
        leftBottomPane.add(empEditMail, 0, 5);
        leftBottomPane.add(empEditRole, 0, 6);

        TextField editIdTf = new TextField();
        editIdTf.setFont(style.generalFont);
        editIdTf.setPromptText("Enter Id");
        style.tfStyle(editIdTf);

        TextField editFnameTf = new TextField();
        editFnameTf.setFont(style.generalFont);
        editFnameTf.setPromptText("Firstname");
        style.tfStyle(editFnameTf);

        TextField editLnameTf = new TextField();
        editLnameTf.setFont(style.generalFont);
        editLnameTf.setPromptText("Lastname");
        style.tfStyle(editLnameTf);

        TextField editNumberTf = new TextField();
        editNumberTf.setFont(style.generalFont);
        editNumberTf.setPromptText("Phone Number");
        style.tfStyle(editNumberTf);

        TextField editEmailTf = new TextField();
        editEmailTf.setFont(style.generalFont);
        editEmailTf.setPromptText("Email");
        style.tfStyle(editEmailTf);

        TextField editRoleTf = new TextField();
        editRoleTf.setFont(style.generalFont);
        editRoleTf.setPromptText("Role");
        style.tfStyle(editRoleTf);

        leftBottomPane.add(editIdTf, 1, 1);
        leftBottomPane.add(editFnameTf, 1, 2);
        leftBottomPane.add(editLnameTf, 1, 3);
        leftBottomPane.add(editNumberTf, 1, 4);
        leftBottomPane.add(editEmailTf, 1, 5);
        leftBottomPane.add(editRoleTf, 1, 6);
        leftBottomPane.setHgap(10);
        leftBottomPane.setVgap(5);

        Button updateBt = new Button("Update");
        updateBt.setFont(style.generalFont);
        style.btStyle(updateBt);

        Button deleteBt = new Button("Delete");
        deleteBt.setFont(style.generalFont);
        style.btStyle(deleteBt);

        Label empGenderLabel = new Label("Gender");
        empGenderLabel.setFont(style.generalFont);
        leftBottomPane.add(empGenderLabel, 0, 7);

        RadioButton editMaleRadio = new RadioButton("Male");
        editMaleRadio.setFont(style.generalFont);
        editMaleRadio.setSelected(true);

        RadioButton editFemaleRadio = new RadioButton("Female");
        editFemaleRadio.setFont(style.generalFont);

        RadioButton editOtherRadio = new RadioButton("Other");
        editOtherRadio.setFont(style.generalFont);

        ToggleGroup editGenderToggleGroup = new ToggleGroup();
        editGenderToggleGroup.getToggles().addAll(editMaleRadio, editFemaleRadio, editOtherRadio);

        TextField editGenderTextField = new TextField();
        editGenderTextField.setFont(style.generalFont);
        editGenderTextField.setPromptText("Other gender");
        style.tfStyle(editGenderTextField);

        HBox editRadioButtonsBox = new HBox();
        editRadioButtonsBox.getChildren().addAll(editMaleRadio, editFemaleRadio, editOtherRadio);
// Add the radio buttons and the text field to the grid pane
        leftBottomPane.add(editRadioButtonsBox, 1, 7);
        leftBottomPane.add(editGenderTextField, 2, 7);
        radioButtonsBox.setAlignment(Pos.CENTER);

        editGenderTextField.setVisible(false);

        editMaleRadio.setOnAction(e -> {
            editGenderTextField.setVisible(false);
        });

        editFemaleRadio.setOnAction(e -> {
            editGenderTextField.setVisible(false);
        });

        editOtherRadio.setOnAction(e -> {
            editGenderTextField.setVisible(true);
        });

        leftBottomPane.add(updateBt, 0, 8);
        leftBottomPane.add(deleteBt, 1, 8);
        leftBottomPane.setAlignment(Pos.CENTER);

        viewEmployee(editIdTf, editFnameTf, editLnameTf, editNumberTf, editEmailTf, editRoleTf, editGenderToggleGroup, editGenderTextField, editMaleRadio, editFemaleRadio, editOtherRadio, deleteBt, updateBt);

//----------------------------------------------------------------------------------------------------------------------
        GridPane rightPane = new GridPane();
        rightPane.setStyle("-fx-background-color: lightblue;");

        TableView<Employees> employeesTableView = new TableView<>();
        ObservableList<Employees> data = FXCollections.observableArrayList();
        TableColumn<Employees, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Employees, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        TableColumn<Employees, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        TableColumn<Employees, String> phoneCol = new TableColumn<>("Phone Number");
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        TableColumn<Employees, String> specialityCol = new TableColumn<>("Role");
        specialityCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        TableColumn<Employees, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Employees, String> genderCol = new TableColumn<>("Gender");
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));

        employeesTableView.getColumns().addAll(idCol, firstNameCol, lastNameCol, phoneCol, specialityCol, emailCol, genderCol);
        rightPane.setAlignment(Pos.CENTER);
        employeesTableView.setMinWidth(700);


        TextField searchField = new TextField();
        searchField.setFont(style.generalFont);
        style.tfStyle(searchField);

        Button searchButton = new Button();
        style.btStyle(searchButton);
        searchButton.setFont(style.generalFont);
        Image searchImg = new Image("https://cdn-icons-png.flaticon.com/128/151/151773.png");
        ImageView searchImgView = new ImageView(searchImg);
        searchImgView.setFitWidth(20);
        searchImgView.setFitHeight(20);
        searchButton.setGraphic(searchImgView);

        Button xButton = new Button();
        style.btStyle(xButton);
        xButton.setFont(style.generalFont);
        ImageView xImgView = new ImageView(new Image("https://cdn-icons-png.flaticon.com/128/2976/2976286.png"));
        xImgView.setFitHeight(20);
        xImgView.setFitWidth(20);
        xButton.setGraphic(xImgView);

        rightPane.add(searchField, 1, 0);
        rightPane.add(searchButton, 2, 0);
        rightPane.add(xButton, 3, 0);
        rightPane.add(employeesTableView, 0, 1, 3, 1);

        refreshTable(employeesTableView);

        empSubmitBt.setOnAction(e -> {
            addEmployee(employee, empFirstnameTF, empLastnameTF, empNumberTF, empEmailTF, empRoleTF, genderToggleGroup, genderTextField, maleRadio, femaleRadio, otherRadio);
            refreshTable(employeesTableView);
        });
        updateBt.setOnAction(e -> {
            updateEmployee(employeesTableView, editGenderToggleGroup, editMaleRadio, editFemaleRadio, editOtherRadio, editGenderTextField, deleteBt, updateBt, editFnameTf, editLnameTf, editEmailTf, editRoleTf, editIdTf, editNumberTf);
        });
        deleteBt.setOnAction(e -> {
            deleteEmployee(editIdTf, editFnameTf, editLnameTf, editNumberTf, editEmailTf, editRoleTf, editGenderToggleGroup, editMaleRadio, genderTextField, employeesTableView);
        });

        searchButton.setOnAction(e -> {
            searchEmployees(employeesTableView, searchField);
        });

        xButton.setOnAction(e -> {
            refreshTable(employeesTableView);
        });

//----------------------------------------------------------------------------------------------------------------------
        // create the split panes
        SplitPane leftPane = new SplitPane();
        leftPane.getItems().addAll(leftTopPane, leftBottomPane);
        leftPane.setOrientation(Orientation.VERTICAL);
        SplitPane main = new SplitPane();
        main.getItems().addAll(leftPane, rightPane);

        // create the scene and show the stage
        Scene scene = new Scene(main);
        stage.getIcons().add(new Image("https://static.thenounproject.com/png/2909354-200.png"));
        stage.setTitle("Employees");
        stage.setScene(scene);
        stage.setMaximized(true);
//        stage.setResizable(false);
        stage.show();
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void addEmployee(Employees employee, TextField fnametf, TextField lnametf, TextField phonetf, TextField emailtf, TextField role, ToggleGroup gender, TextField genderTf, RadioButton male, RadioButton female, RadioButton other) {

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        if (fnametf.getText().isEmpty()) {
            style.tfErrorStyle(fnametf);
            fnametf.clear();
            fnametf.setPromptText("Cannot be empty!");
        } else {
            employee.setFirstname(fnametf.getText());
            style.tfSuccessStyle(fnametf);
        }
        if (lnametf.getText().isEmpty()) {
            style.tfErrorStyle(lnametf);
            lnametf.clear();
            lnametf.setPromptText("Cannot be empty!");
//            return;
        } else {
            employee.setLastname(lnametf.getText());
            style.tfSuccessStyle(lnametf);
        }

        if (phonetf.getText().isEmpty()) {
            style.tfErrorStyle(phonetf);
            phonetf.clear();
            phonetf.setPromptText("Cannot be empty!");
        } else if (!phonetf.getText().matches("\\d{8}")) {
            style.tfErrorStyle(phonetf);
            phonetf.setPromptText("Invalid Format");
//            return;
        } else {
            style.tfSuccessStyle(phonetf);
            employee.setPhoneNumber(phonetf.getText());
        }

        if (!(emailtf.getText().isEmpty())) {
            if (emailtf.getText().contains("@") && emailtf.getText().contains(".")) {
                style.tfSuccessStyle(emailtf);
                employee.setEmail(emailtf.getText());
            } else {
                style.tfErrorStyle(emailtf);
            }
        } else {
            style.tfStyle(emailtf);
        }

        if (gender.getSelectedToggle().equals(male)) {
            employee.setGender("Male");
            System.out.println(employee.getGender());
        } else if (gender.getSelectedToggle().equals(female)) {
            employee.setGender("Female");
            System.out.println(employee.getGender());
        } else if (gender.getSelectedToggle().equals(other)) {
            if (!(genderTf.getText().isEmpty())) {
                employee.setGender(genderTf.getText());
                style.tfSuccessStyle(genderTf);
                System.out.println(employee.getGender());
            } else {
                style.tfErrorStyle(genderTf);
                genderTf.setPromptText("Cannot be empty!");
            }
        }
        if (role.getText().isEmpty()) {
            style.tfErrorStyle(role);
            role.setPromptText("Cannot be empty!");
        } else {
            employee.setCategory(role.getText());
            style.tfSuccessStyle(role);
        }


        try {
            String query = "SELECT * FROM medical_doctor WHERE first_name = ? AND last_name = ? AND phone_number = ?";
            PreparedStatement statement = connectDB.prepareStatement(query);
            statement.setString(1, employee.getFirstname());
            statement.setString(2, employee.getLastname());
            statement.setString(3, employee.getPhoneNumber());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                style.tfErrorStyle(fnametf);
                style.tfErrorStyle(lnametf);
                style.tfErrorStyle(phonetf);
                fnametf.setPromptText("Duplicate record");
                lnametf.setPromptText("Duplicate record");
                phonetf.setPromptText("Duplicate record");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        try {
            connectDB.setAutoCommit(false);

            String query = "Insert INTO medical_doctor (first_name, last_name, phone_number, speciality, email, gender)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connectDB.prepareStatement(query);
            statement.setString(1, employee.getFirstname());
            statement.setString(2, employee.getLastname());
            statement.setString(3, employee.getPhoneNumber());
            statement.setString(4, employee.getCategory());
            statement.setString(5, employee.getEmail());
            statement.setString(6, employee.getGender());

            statement.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Employee Inserted successfully!");
            alert.showAndWait();
            fnametf.setText("");
            lnametf.setText("");
            phonetf.setText("");
            genderTf.setText("");
            emailtf.setText("");
            gender.selectToggle(male);
            role.setText("");

            connectDB.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connectDB.rollback();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to delete employee!");
                alert.showAndWait();// rollback transaction if there's an exception
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
    public void viewEmployee(TextField editId, TextField editFirstname, TextField editLastname, TextField editPhone, TextField editEmail, TextField editCategory, ToggleGroup editGender, TextField editGenderTf, RadioButton male, RadioButton female, RadioButton other, Button deleteButton, Button updateButton) throws SQLException {
        editId.setOnKeyReleased(e -> {
            try {
                if (editId.getText().isEmpty()) {
                    editFirstname.clear();
                    editLastname.clear();
                    editPhone.clear();
                    editEmail.clear();
                    editCategory.clear();
                    editGender.selectToggle(male);
                    editGenderTf.setVisible(false);
                } else {
                    employee.setId(Integer.parseInt(editId.getText()));

                    DatabaseConnection connection = new DatabaseConnection();
                    Connection conn = connection.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(
                            "SELECT * FROM medical_doctor WHERE md_id=?");
                    stmt.setInt(1, employee.getId());
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        deleteButton.setDisable(false);
                        updateButton.setDisable(false);

                        editFirstname.setText(rs.getString("first_name"));
                        editLastname.setText(rs.getString("last_name"));
                        editPhone.setText(rs.getString("phone_number"));
                        editEmail.setText(rs.getString("email"));
                        editCategory.setText(rs.getString("speciality"));
                        if (rs.getString("gender").matches("Male")) {
                            editGender.selectToggle(male);
                            editGenderTf.setVisible(false);
                        } else if (rs.getString("gender").matches("Female")) {
                            editGender.selectToggle(female);
                            editGenderTf.setVisible(false);
                        } else {
                            editGender.selectToggle(other);
                            editGenderTf.setVisible(true);
                            editGenderTf.setText(rs.getString("gender"));
                        }
                    } else {
                        // Disable buttons if the ID doesn't exist
                        deleteButton.setDisable(true);
                        updateButton.setDisable(true);

                        // Clear text fields and text area
                        editFirstname.clear();
                        editLastname.clear();
                        editPhone.clear();
                        editEmail.clear();
                        editCategory.clear();
                        editGender.selectToggle(male);
                        editGenderTf.clear();
                        editGenderTf.setVisible(false);
                    }
                    stmt.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }

    public ObservableList<Employees> getAllEmployees() throws SQLException {
        ObservableList<Employees> employeesList = FXCollections.observableArrayList();
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String query = "SELECT * FROM medical_doctor";
        Statement statement = connectDB.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Employees employee = new Employees();
            employee.setId(resultSet.getInt(1));
            employee.setFirstname(resultSet.getString(2));
            employee.setLastname(resultSet.getString(3));
            employee.setPhoneNumber(resultSet.getString(4));
            employee.setEmail(resultSet.getString(6));
            employee.setCategory(resultSet.getString(5));
            employee.setGender(resultSet.getString(7));
            employeesList.add(employee);
        }

        resultSet.close();
        statement.close();
        connectDB.close();

        return employeesList;
    }

    public void refreshTable(TableView<Employees> tableView) {
        try {
            ObservableList<Employees> employeesList = getAllEmployees();
            tableView.setItems(employeesList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(TableView<Employees> employeeTableView, ToggleGroup editGender, RadioButton male, RadioButton female, RadioButton other, TextField genderTf, Button deleteButton, Button updateButton, TextField editFirstname, TextField editLastname, TextField editEmail, TextField editRole, TextField editIdTf, TextField editPhone) {
        try {
            employee.setId(Integer.parseInt(editIdTf.getText()));
            DatabaseConnection connection = new DatabaseConnection();
            Connection conn = connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM medical_doctor WHERE md_id=?");
            stmt.setInt(1, employee.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // enable the delete and update buttons
                deleteButton.setDisable(false);
                updateButton.setDisable(false);

                // get the patient data from the text fields
                if (editFirstname.getText().isEmpty()) {
                    style.tfErrorStyle(editFirstname);
                    editFirstname.setPromptText("Cannot be empty!");
                } else {
                    style.tfSuccessStyle(editFirstname);
                    employee.setFirstname(editFirstname.getText());
                }

                if (editLastname.getText().isEmpty()) {
                    style.tfErrorStyle(editLastname);
                    editLastname.setPromptText("Cannot be empty!");
                } else {
                    style.tfSuccessStyle(editLastname);
                    employee.setLastname(editLastname.getText());
                    editLastname.setPromptText("Edit Lastname");
                }

                if (editPhone.getText().isEmpty()) {
                    style.tfErrorStyle(editPhone);
                    editPhone.clear();
                    editPhone.setPromptText("Phone Cannot be empty!");
                } else if (!editPhone.getText().matches("\\d{8}")) {
                    style.tfErrorStyle(editPhone);
                    editPhone.setPromptText("Invalid Format");
//            return;
                } else {
                    style.tfSuccessStyle(editPhone);
                    employee.setPhoneNumber(editPhone.getText());
                    editPhone.setPromptText("Edit Phone Number");
                }

                if (!(editEmail.getText().isEmpty())) {
                    if (editEmail.getText().contains("@") && editEmail.getText().contains(".")) {
                        style.tfSuccessStyle(editEmail);
                        employee.setEmail(editEmail.getText());
                        editEmail.setPromptText("Edit Email");
                    } else {
                        style.tfErrorStyle(editEmail);
                        editEmail.setPromptText("Invalid format!");
                    }
                } else {
                    style.tfStyle(editEmail);
                }

                if (editGender.getSelectedToggle().equals(male)) {
                    employee.setGender("Male");
                    System.out.println(employee.getGender());
                    genderTf.clear();
                } else if (editGender.getSelectedToggle().equals(female)) {
                    employee.setGender("Female");
                    System.out.println(employee.getGender());
                    genderTf.clear();
                } else if (editGender.getSelectedToggle().equals(other)) {
                    if (!(genderTf.getText().isEmpty())) {
                        employee.setGender(genderTf.getText());
                        style.tfSuccessStyle(genderTf);
                        System.out.println(employee.getGender());
                    } else {
                        style.tfErrorStyle(genderTf);
                        genderTf.setPromptText("Cannot be empty!");
                    }
                }

                if (editRole.getText().isEmpty()) {
                    style.tfErrorStyle(editRole);
                    editRole.setPromptText("Cannot be empty!");
                } else {
                    employee.setCategory(editRole.getText());
                    style.tfSuccessStyle(editRole);
                    editRole.setPromptText("Edit role");
                }

                // update the patient data in the database
                PreparedStatement updateStmt = conn.prepareStatement(
                        "UPDATE medical_doctor SET first_name=?, last_name=?, phone_number=?, speciality=?, email=?, gender=? WHERE md_id=?");
                updateStmt.setString(1, employee.getFirstname());
                updateStmt.setString(2, employee.getLastname());
                updateStmt.setString(3, employee.getPhoneNumber());
                updateStmt.setString(4, employee.getCategory());
                updateStmt.setString(5, employee.getEmail());
                updateStmt.setString(6, employee.getGender());
                updateStmt.setInt(7, employee.getId());

                int rows = updateStmt.executeUpdate();
                if (rows > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee updated successfully!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Fail");
                    alert.setHeaderText(null);
                    alert.setContentText("Couldn't update successfully!");
                    alert.showAndWait();
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
        refreshTable(employeeTableView);
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void deleteEmployee(TextField editId, TextField editfname, TextField editlname, TextField editphone, TextField editemail, TextField editrole, ToggleGroup editgender, RadioButton male, TextField gendertf, TableView<Employees> employeesTableView) {
        try {
            employee.setId(Integer.parseInt(editId.getText()));
            DatabaseConnection connection = new DatabaseConnection();
            Connection conn = connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM medical_doctor WHERE md_id=?");
            stmt.setInt(1, employee.getId());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                // Display a success message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Employee deleted successfully!");
                alert.showAndWait();

                // Clear text fields and disable buttons
                editId.clear();
                editfname.clear();
                editlname.clear();
                editphone.clear();
                editemail.clear();
                editrole.clear();
                editgender.selectToggle(male);
                gendertf.clear();
                gendertf.setVisible(false);
                gendertf.setDisable(true);
                gendertf.setDisable(true);
            } else {
                // Display an error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to delete employee!");
                alert.showAndWait();
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        refreshTable(employeesTableView);
    }

    private void searchEmployees(TableView<Employees> tableView, TextField searchField) {
        // get search query from text field
        String query = searchField.getText().trim();

        // perform search in database
        List<Employees> employees = new ArrayList<>();
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        try {
            String sql = "SELECT * FROM medical_doctor WHERE medical_doctor.first_name LIKE ? OR medical_doctor.last_name LIKE ?";
            PreparedStatement stmt = connectDB.prepareStatement(sql);
            stmt.setString(1, "%" + query + "%");
            stmt.setString(2, "%" + query + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Employees employee = new Employees();
                employee.setId(rs.getInt(1));
                employee.setFirstname(rs.getString(2));
                employee.setLastname(rs.getString(3));
                employee.setPhoneNumber(rs.getString(4));
                employee.setCategory(rs.getString(5));
                employee.setEmail(rs.getString(6));
                employee.setGender(rs.getString(7));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace(); //Added Comment
        } finally {
            if (connectDB != null) {
                try {
                    connectDB.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}