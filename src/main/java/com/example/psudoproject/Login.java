package com.example.psudoproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Login extends Application {
    public TextField usernameField = new TextField();
    public PasswordField passwordField = new PasswordField();
    public Label successLabel = new Label();
    Users user = new Users();
    LayoutPane style = new LayoutPane();
    public MainMenu mainMenu = new MainMenu();

    @Override
    public void start(Stage primaryStage) {
        Font generalFont = Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 15);
        primaryStage.setTitle("Healthcare Login");

        LayoutPane layoutPane = new LayoutPane();
        layoutPane.makePane();

        // Create the header text
        Text headerText = new Text("Hospital Corporation of America");
        headerText.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        headerText.setFill(Color.DARKBLUE);

        // Create the username label and field
        Label usernameLabel = new Label("Username:");
        usernameLabel.setFont(generalFont);
        usernameField.setPromptText("Enter your username");
        usernameField.setFont(generalFont);
        style.tfStyle(usernameField);

        // Create the password label and field
        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(generalFont);
        passwordField.setPromptText("Enter your password");
        passwordField.setFont(generalFont);
        style.tfStyle(passwordField);

        // Create the login button
        Button loginButton = new Button("Login");
        style.btStyle(loginButton);
        loginButton.setOnAction(event -> {
            validate(primaryStage);
        });

        Button clearButton = new Button("Clear");
        style.btStyle(clearButton);
        clearButton.setOnAction(e -> {
            usernameField.clear();
            style.tfStyle(usernameField);

            passwordField.clear();
            style.tfStyle(passwordField);

            successLabel.setText("");
        });

        ButtonBar buttonBar = new ButtonBar();
        buttonBar.getButtons().addAll(loginButton, clearButton);
        loginButton.setFont(generalFont);
        clearButton.setFont(generalFont);

        // Create a VBox to hold the elements
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));
        vBox.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.getChildren().addAll(headerText, usernameLabel, usernameField, passwordLabel, passwordField, successLabel, buttonBar);
        vBox.setMaxWidth(500);
        vBox.setAlignment(Pos.CENTER);
        // Create the scene and set it on the stage
        Scene scene = new Scene(vBox, 400, 250);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER){
                validate(primaryStage);
            }
        });


        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("https://static.thenounproject.com/png/5394408-200.png"));
        primaryStage.show();
    }

    public void validate(Stage primaryStage) {

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        try {
            Statement stmt = connectDB.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                user.setId(rs.getInt("userId"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setCategory(rs.getString("category"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));

                if (Objects.equals(usernameField.getText(), user.getUsername()) && Objects.equals(passwordField.getText(), user.getPassword())) {
                    successLabel.setText("Welcome " + user.getFirstname() + " " + user.getLastname());
                    successLabel.setTextFill(Color.GREEN);
                    successLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 15));
//                    primaryStage.close();

                    MainMenu mainMenu = new MainMenu();
                    mainMenu.adminMenuBtnBox.getChildren().addAll(mainMenu.patientsBtn, mainMenu.employeesBtn, mainMenu.medsBtn, mainMenu.pharmacyBtn, mainMenu.usersBtn);

                    if (user.getCategory().matches("admin")) {
                        primaryStage.close();
                        Stage mainStage = new Stage();
                        mainStage.setScene(mainMenu.adminScene);
                        mainMenu.btnBoxSet(mainMenu.adminMenuBtnBox, mainMenu.adminMenuPane, mainStage);
                        mainStage.setTitle("Admin Main Menu");
                        mainMenu.start(mainStage);
                    }

                    if (user.getCategory().matches("user")) {
                        primaryStage.close();
                        Stage mainStage = new Stage();
                        mainStage.setScene(mainMenu.adminScene);
                        mainMenu.adminMenuBtnBox.getChildren().remove(mainMenu.usersBtn);
                        mainMenu.btnBoxSet(mainMenu.adminMenuBtnBox,mainMenu.adminMenuPane, mainStage);
                        primaryStage.setTitle("User Main Menu");
                        mainMenu.start(mainStage);
                    }

                    if (user.getCategory().matches("doctor") || (user.getCategory().matches("nurse"))) {
                        PatientsMenu patientsMenu = new PatientsMenu();
                        patientsMenu.patAddPane.setDisable(true);
                        primaryStage.close();
                        Stage mainStage = new Stage();
                        mainStage.setScene(mainMenu.adminScene);
                        mainMenu.adminMenuBtnBox.getChildren().removeAll(mainMenu.usersBtn, mainMenu.medsBtn,mainMenu.employeesBtn);
                        mainMenu.btnBoxSet(mainMenu.adminMenuBtnBox, mainMenu.adminMenuPane, mainStage);
                        mainMenu.start(mainStage);

                        primaryStage.setResizable(false);
                    }

                    return;
                }

            }
            // If the loop completes without finding a match, display error message
            successLabel.setText("Wrong username or password!");
            successLabel.setTextFill(Color.RED);
            successLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 15));

            if(Objects.equals(usernameField.getText(), "") || (Objects.equals(passwordField.getText(), ""))){

                if(Objects.equals(usernameField.getText(), "") && (Objects.equals(passwordField.getText(), ""))){
                    style.tfErrorStyle(usernameField);
                    style.tfErrorStyle(passwordField);
                    successLabel.setText("Fields cannot be empty");
                    successLabel.setTextFill(Color.RED);
                    successLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 15));
                }

                if(Objects.equals(usernameField.getText(), "")){
                    style.tfErrorStyle(usernameField);
                    successLabel.setText("Fields cannot be empty");
                    successLabel.setTextFill(Color.RED);
                    successLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 15));
                }
                else {
                   style.tfSuccessStyle(usernameField);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            successLabel.setText("Connection unsuccessful");
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


    public static void main(String[] args) {
        launch(args);
    }
}
