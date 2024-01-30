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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.*;

public class UsersMenu extends Application {
    LayoutPane style = new LayoutPane();
    Users user = new Users();
    @Override
    public void start(Stage stage) throws Exception {

        GridPane userAddPane = new GridPane();
        userAddPane.setStyle("-fx-background-color: aliceblue;");

        Label addUserLabel = new Label("Add a user");
        addUserLabel.setFont(style.titleFont);
        addUserLabel.setTextFill(Color.DARKBLUE);

        userAddPane.add(addUserLabel, 0, 0);

        Label addUserFirstnameLbl = new Label("User Firstname");
        addUserFirstnameLbl.setFont(style.generalFont);

        TextField addUserFirstnameTf = new TextField();
        style.tfStyle(addUserFirstnameTf);
        addUserFirstnameTf.setPromptText("Firstname");

        Label addUserLastnameLbl = new Label("User Lastname");
        addUserLastnameLbl.setFont(style.generalFont);

        TextField addUserLastnameTf = new TextField();
        style.tfStyle(addUserLastnameTf);
        addUserLastnameTf.setPromptText("Lastname");

        Label addUserUsername = new Label("Username");
        addUserUsername.setFont(style.generalFont);

        TextField addUserUsernameTf = new TextField();
        style.tfStyle(addUserUsernameTf);
        addUserUsernameTf.setPromptText("Username");

        Label addUserPassword = new Label("Password");
        addUserPassword.setFont(style.generalFont);

        PasswordField addUserPasswordF = new PasswordField();
        style.tfStyle(addUserPasswordF);
        addUserPasswordF.setPromptText("Password");

        Label addUserConfirm = new Label("Confirm Password");
        addUserConfirm.setFont(style.generalFont);

        PasswordField addUserConfirmPf = new PasswordField();
        style.tfStyle(addUserConfirmPf);
        addUserConfirmPf.setPromptText("Confirm Password");

        Label categoryLabel = new Label("User Category");
        categoryLabel.setFont(style.generalFont);

        ComboBox<String> userCategory = new ComboBox<>();
        userCategory.getItems().addAll("admin", "user", "doctor", "nurse");
        userCategory.setValue("user");
        userCategory.setStyle("-fx-background-color: white; -fx-border-color: darkblue; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px; " +
                "radius: 10px; -fx-font-family: Tahoma;");
        userCategory.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item);
                    setFont(style.generalFont);
                }
            }
        });
        // Set the font of the selected value
        userCategory.setStyle("-fx-font-family: Tahoma; -fx-font-size: 15px; " +
                "-fx-font-style: italic; -fx-font-weight: bold; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px; " +
                "-fx-border-color: darkblue; -fx-background-radius: 10px;" +
                "-fx-background-color: white");

        Button addUserBtn = new Button("Add");
        style.btStyle(addUserBtn);

        Button addUserClearBtn = new Button("Clear");
        style.btStyle(addUserClearBtn);

        userAddPane.add(addUserFirstnameLbl, 0, 1);
        userAddPane.add(addUserFirstnameTf, 1, 1);
        userAddPane.add(addUserLastnameLbl, 0, 2);
        userAddPane.add(addUserLastnameTf, 1, 2);
        userAddPane.add(addUserUsername, 0, 3);
        userAddPane.add(addUserUsernameTf, 1, 3);
        userAddPane.add(addUserPassword, 0, 4);
        userAddPane.add(addUserPasswordF, 1, 4);
        userAddPane.add(addUserConfirm, 0, 5);
        userAddPane.add(addUserConfirmPf, 1, 5);
        userAddPane.add(categoryLabel, 0, 6);
        userAddPane.add(userCategory, 1, 6);
        userAddPane.add(addUserBtn, 0, 7);
        userAddPane.add(addUserClearBtn, 1, 7);
        userAddPane.setAlignment(Pos.CENTER);
        addUserLabel.setAlignment(Pos.TOP_CENTER);
        userAddPane.setHgap(10);
        userAddPane.setVgap(10);


        addUserClearBtn.setOnAction( e -> {
            addUserFirstnameTf.clear();
            style.tfStyle(addUserFirstnameTf);

            addUserLastnameTf.clear();
            style.tfStyle(addUserLastnameTf);

            addUserUsernameTf.clear();
            style.tfStyle(addUserUsernameTf);

            addUserPasswordF.clear();
            style.tfStyle(addUserPasswordF);

            addUserConfirmPf.clear();
            style.tfStyle(addUserConfirmPf);
        });

//----------------------------------------------------------------------------------------------------------------------
        GridPane userEditPane = new GridPane();
        userEditPane.setStyle("-fx-background-color: aliceblue;");

        Label editUserLabel = new Label("Edit User");
        editUserLabel.setFont(style.titleFont);
        editUserLabel.setTextFill(Color.DARKBLUE);

        Label editIdLabel = new Label("Enter User ID");
        editIdLabel.setFont(style.generalFont);

        TextField editIdTf = new TextField();
        editIdTf.setPromptText("Patient ID");
        editIdTf.setFont(style.generalFont);
        style.tfStyle(editIdTf);

        Label editFirstnameLabel = new Label("Edit Firstname");
        editFirstnameLabel.setFont(style.generalFont);

        TextField editFirstname = new TextField();
        editFirstname.setPromptText("Edit Firstname");
        editFirstname.setFont(style.generalFont);
        style.tfStyle(editFirstname);

        Label editLastnameLabel = new Label("Edit Lastname");
        editLastnameLabel.setFont(style.generalFont);

        TextField editLastname = new TextField();
        editLastname.setPromptText("Edit Lastname");
        editLastname.setFont(style.generalFont);
        style.tfStyle(editLastname);

        Label editUsernameLabel = new Label("Edit Username");
        editUsernameLabel.setFont(style.generalFont);

        TextField editUsername = new TextField();
        editUsername.setPromptText("Edit Username");
        editUsername.setFont(style.generalFont);
        style.tfStyle(editUsername);

        Label editPassLabel = new Label("Edit Password");
        editPassLabel.setFont(style.generalFont);

        PasswordField editPass = new PasswordField();
        editPass.setPromptText("Edit Password");
        editPass.setFont(style.generalFont);
        style.tfStyle(editPass);

        Label editConfirmLabel = new Label("Confirm Password");
        editConfirmLabel.setFont(style.generalFont);

        PasswordField editConfirm = new PasswordField();
        editConfirm.setPromptText("Edit Password");
        editConfirm.setFont(style.generalFont);
        style.tfStyle(editConfirm);

        Label editCategoryLabel = new Label("Edit Category");
        editCategoryLabel.setFont(style.generalFont);

        ComboBox<String> editCategory = new ComboBox<>();
        editCategory.getItems().addAll("admin", "user", "doctor", "nurse");
        editCategory.setValue("user");
        editCategory.setStyle("-fx-background-color: white; -fx-border-color: darkblue; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px; " +
                "radius: 10px; -fx-font-family: Tahoma;");
        editCategory.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item);
                    setFont(style.generalFont);
                }
            }
        });
//         Set the font of the selected value
        editCategory.setStyle("-fx-font-family: Tahoma; -fx-font-size: 15px; " +
                "-fx-font-style: italic; -fx-font-weight: bold; " +
                "-fx-border-radius: 10px; -fx-border-width: 2px; " +
                "-fx-border-color: darkblue; -fx-background-radius: 10px;" +
                "-fx-background-color: white");


        Button deleteButton = new Button("Delete");
        deleteButton.setFont(style.generalFont);
        style.btStyle(deleteButton);

        Button updateButton = new Button("Update");
        updateButton.setFont(style.generalFont);
        style.btStyle(updateButton);

        viewUser(editIdTf, editUsername, editFirstname, editLastname, editPass, editConfirm, editCategory, deleteButton, updateButton);

        userEditPane.add(editUserLabel, 0, 0);
        userEditPane.add(editIdLabel, 0, 1);
        userEditPane.add(editIdTf, 1, 1);
        userEditPane.add(editUsernameLabel, 0, 2);
        userEditPane.add(editUsername, 1, 2);
        userEditPane.add(editPass, 1, 3);
        userEditPane.add(editPassLabel, 0, 3);
        userEditPane.add(editConfirmLabel, 0, 4);
        userEditPane.add(editConfirm, 1, 4);
        userEditPane.add(editFirstnameLabel, 0, 5);
        userEditPane.add(editFirstname, 1, 5);
        userEditPane.add(editLastnameLabel, 0, 6);
        userEditPane.add(editLastname, 1, 6);
        userEditPane.add(editCategoryLabel, 0, 7);
        userEditPane.add(editCategory, 1, 7);
        userEditPane.add(updateButton, 0, 8);
        userEditPane.add(deleteButton, 1, 8);
        userEditPane.setVgap(10);
        userEditPane.setHgap(10);
        userEditPane.setAlignment(Pos.CENTER);


//----------------------------------------------------------------------------------------------------------------------
        GridPane userViewPane = new GridPane();
        userViewPane.setStyle("-fx-background-color: lightblue;");
        userViewPane.setAlignment(Pos.CENTER);

        TableView<Users> usersTableView = new TableView<>();
        usersTableView.setPrefWidth(600);

        TableColumn<Users, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Users, String> usernameCol = new TableColumn<>("Username");
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<Users, String> passwordCol = new TableColumn<>("Password");
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn<Users, String> categoryCol = new TableColumn<>("Category");
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Users, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));

        TableColumn<Users, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setStyle("background-color:darkblue");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));

        usersTableView.getColumns().addAll(idCol, usernameCol, passwordCol, categoryCol, firstNameCol, lastNameCol);

        refreshTable(usersTableView);

        userViewPane.add(usersTableView,0, 0);

        addUserBtn.setOnAction( e -> {
            insertUser(user, addUserFirstnameTf, addUserLastnameTf, addUserUsernameTf, addUserPasswordF, addUserConfirmPf, userCategory);
            refreshTable(usersTableView);
        });

        updateButton.setOnAction( e -> {
            updateUser(deleteButton, updateButton, editFirstname, editLastname, editUsername, editPass, editConfirm, editIdTf, editCategory, usersTableView);
        });

        usersTableView.setStyle("-fx-border-color: darkblue");

//----------------------------------------------------------------------------------------------------------------------
        // create the split panes
        SplitPane leftPane = new SplitPane();
        leftPane.getItems().addAll(userAddPane, userEditPane);
        leftPane.setOrientation(Orientation.VERTICAL);
        SplitPane main = new SplitPane();
        main.getItems().addAll(leftPane, userViewPane);

        // create the scene and show the stage
        Scene scene = new Scene(main);
        stage.getIcons().add(new Image("https://static.thenounproject.com/png/5394408-200.png"));
        stage.setTitle("Users");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
//----------------------------------------------------------------------------------------------------------------------
    public void insertUser(Users user, TextField userFname, TextField userLname, TextField userUsername, TextField pass, TextField confirmPass, ComboBox<String> userCategory) {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        // Check for empty fields
        //            return;
        if (userFname.getText().isEmpty()){
            style.tfErrorStyle(userFname);
            userFname.clear();
            userFname.setPromptText("Cannot be empty!");
        }
        else {
            user.setFirstname(userFname.getText());
            style.tfSuccessStyle(userFname);
        }
        if (userLname.getText().isEmpty()) {
            style.tfErrorStyle(userLname);
            userLname.clear();
            userLname.setPromptText("Cannot be empty!");
//            return;
        }
        else {
            user.setLastname(userLname.getText());
            style.tfSuccessStyle(userLname);
        }

        if (userUsername.getText().isEmpty()){
            style.tfErrorStyle(userUsername);
            userUsername.clear();
            userUsername.setPromptText("Cannot be empty!");
        }
        else{
            style.tfSuccessStyle(userUsername);
            user.setUsername(userUsername.getText());
        }

        if (pass.getText().isEmpty()) {
            style.tfErrorStyle(pass);
            pass.clear();
            pass.setPromptText("Cannot be empty!");
        }
        if (!(pass.getText().isEmpty() && !(confirmPass.getText().isEmpty()))) {
            if (confirmPass.getText().matches(pass.getText())){
                user.setPassword(pass.getText());
                style.tfSuccessStyle(pass);
                style.tfSuccessStyle(confirmPass);
            }
            else {
                style.tfErrorStyle(pass);
                pass.clear();
                pass.setPromptText("Passwords do not match");

                style.tfErrorStyle(confirmPass);
                confirmPass.clear();
                confirmPass.setPromptText("Passwords do not match");
            }
        }

        user.setCategory(userCategory.getValue());

        // Check if a record with the same first name, last name, and phone number already exists
        try {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = connectDB.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // A record with the same username already exists
                style.tfErrorStyle(userUsername);
                userUsername.setPromptText("Username already exists");
                userUsername.clear();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Insert the patient record
        try {
            connectDB.setAutoCommit(false); // start transaction

            String query = "INSERT INTO users (username, password, category, firstname, lastname) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stmt = connectDB.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getCategory());
            stmt.setString(4, user.getFirstname());
            stmt.setString(5, user.getLastname());

            stmt.executeUpdate();
            System.out.println("User data inserted successfully!");
            confirmPass.setText("");
            pass.setText("");
            userUsername.setText("");
            userLname.setText("");
            userFname.setText("");
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
    //------------------------------------------------------------------------------------------------------------------
    public ObservableList<Users> getAllUsers() throws SQLException {
        ObservableList<Users> usersList = FXCollections.observableArrayList();
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String query = "SELECT * FROM users";
        Statement statement = connectDB.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Users user = new Users();
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setCategory(resultSet.getString(4));
            user.setFirstname(resultSet.getString(5));
            user.setLastname(resultSet.getString(6));
            usersList.add(user);
        }

        resultSet.close();
        statement.close();
        connectDB.close();

        return usersList;
    }
//----------------------------------------------------------------------------------------------------------------------
    public void refreshTable(TableView<Users> tableView) {
        try{
            ObservableList<Users> usersObservableList = getAllUsers();
            tableView.setItems(usersObservableList);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public void viewUser(TextField editId, TextField editUsername, TextField editFirstname, TextField editLastname, TextField editPass, TextField editConfirm, ComboBox<String> editCategory, Button deleteButton, Button updateButton) throws SQLException {
        editId.setOnKeyReleased( e-> {
            try {
                if (editId.getText().isEmpty()) {
                    editFirstname.clear();
                    editLastname.clear();
                    editPass.clear();
                    editId.clear();
                    editConfirm.clear();
                    editUsername.clear();
                } else {
                    int id = Integer.parseInt(editId.getText());
                    DatabaseConnection connection = new DatabaseConnection();
                    Connection conn = connection.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(
                            "SELECT * FROM users WHERE userId=?");
                    stmt.setInt(1, id);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        deleteButton.setDisable(false);
                        updateButton.setDisable(false);

                        editFirstname.setText(rs.getString("firstname"));
                        editLastname.setText(rs.getString("lastname"));
                        editPass.setText(rs.getString("password"));
                        editUsername.setText(rs.getString("username"));
                        editCategory.setValue(rs.getString("category"));

                    }else {
                        // Disable buttons if the ID doesn't exist
                        deleteButton.setDisable(true);
                        updateButton.setDisable(true);

                        // Clear text fields and text area
                        editFirstname.clear();
                        editLastname.clear();
                        editPass.clear();
                        editUsername.clear();
                        editUsername.clear();
                    }
                    stmt.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }
    public void updateUser(Button deleteButton, Button updateButton, TextField editFirstname, TextField editLastname, TextField editUsername, PasswordField editPass, PasswordField editConfirm, TextField editIdTf, ComboBox<String> editCategory, TableView<Users> usersTableView){
        try {
            user.setId(Integer.parseInt(editIdTf.getText()));
            DatabaseConnection connection = new DatabaseConnection();
            Connection conn = connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE userId=?");
            stmt.setInt(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // enable the delete and update buttons
                deleteButton.setDisable(false);
                updateButton.setDisable(false);

                if (!(editPass.getText().isEmpty())) {
                    if (!(editConfirm.getText().isEmpty()) && editConfirm.getText().matches(editPass.getText())){
                        style.tfSuccessStyle(editConfirm);
                        style.tfSuccessStyle(editPass);
                        user.setPassword(editPass.getText());

                    }else {
                        style.tfErrorStyle(editConfirm);
                        style.tfErrorStyle(editPass);
                    }
                }

                // get the patient data from the text fields
                if (editFirstname.getText().isEmpty()){
                    style.tfErrorStyle(editFirstname);
                }
                else {
                    style.tfSuccessStyle(editFirstname);
                    user.setFirstname(editFirstname.getText());
                }

                if (editLastname.getText().isEmpty()){
                    style.tfErrorStyle(editLastname);
                }
                else {
                    style.tfSuccessStyle(editLastname);
                    user.setLastname(editLastname.getText());
                }

                if (editUsername.getText().isEmpty()) {
                    style.tfErrorStyle(editUsername);
                }
                else {
                    style.tfSuccessStyle(editUsername);
                    user.setUsername(editUsername.getText());
                }
                user.setCategory(editCategory.getValue());


                // update the patient data in the database
                PreparedStatement updateStmt = conn.prepareStatement(
                        "UPDATE users SET firstname=?, lastname=?, username=?, password=?, category=? WHERE userId=?");
                updateStmt.setString(   1, user.getFirstname());
                updateStmt.setString(2, user.getLastname());
                updateStmt.setString(3, user.getUsername());
                updateStmt.setString(4, user.getPassword());
                updateStmt.setString(5, user.getCategory());
                updateStmt.setInt(6, user.getId());

                int rows = updateStmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("User with ID " + user.getId() + " updated successfully!");
                } else {
                    System.out.println("Failed to update user with ID " + user.getId());
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
        refreshTable(usersTableView);
    }
}
