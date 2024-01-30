package com.example.psudoproject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenu extends Application {
    public TextField usernameField = new TextField();
    public PasswordField passwordField = new PasswordField();
    public Label successLabel = new Label();
    Users user = new Users();
    LayoutPane style = new LayoutPane();

    public Button patientsBtn = new Button("Patients");
    public Button pharmacyBtn = new Button("Pharmacy");
    public Button usersBtn = new Button("Users");
    public Button employeesBtn = new Button("Employees");
    public Button medsBtn = new Button("Medications");
    public Button logout = new Button("Logout");
    FlowPane adminMenuBtnBox = new FlowPane();
    FlowPane userMenuBtnBox = new FlowPane();
    FlowPane doctorNurseBtnBox = new FlowPane();
    FlowPane nurseMenuBtnBox = new FlowPane();
    public LayoutPane adminMenuPane = new LayoutPane();
    public LayoutPane userMenuPane = new LayoutPane();
    public LayoutPane doctorNurseMenuPane = new LayoutPane();

    public Scene adminScene = new Scene(adminMenuPane);


    @Override
    public void start(Stage menuStage) {

        Font generalFont = Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 15);
        menuStage.setTitle("Healthcare Login");

        adminMenuPane.makePane();
        userMenuPane.makePane();
        doctorNurseMenuPane.makePane();


        ImageView patientsIcon = new ImageView(new Image("https://static.thenounproject.com/png/2071020-200.png"));
        ImageView employeesIcon = new ImageView(new Image("https://static.thenounproject.com/png/2909354-200.png"));
        ImageView medicationIcon = new ImageView(new Image("https://static.thenounproject.com/png/2287928-200.png"));
        ImageView pharmacyIcon = new ImageView(new Image("https://static.thenounproject.com/png/4186067-200.png"));
        ImageView usersIcon = new ImageView(new Image("https://static.thenounproject.com/png/5394408-200.png"));
        ImageView logoutIcon = new ImageView(new Image("https://static.thenounproject.com/png/738610-200.png"));


        buttonStyle(patientsBtn, patientsIcon);
        buttonStyle(employeesBtn, employeesIcon);
        buttonStyle(medsBtn, medicationIcon);
        buttonStyle(pharmacyBtn, pharmacyIcon);
        buttonStyle(usersBtn, usersIcon);
        buttonStyle(logout, logoutIcon);

        logout.setOnAction( e -> {
            buttonStyleOnAction(logout, logoutIcon);
            Login login = new Login();
            try {
                login.start(new Stage());
            }catch (Exception ex){
                throw new RuntimeException();
            }
        });

        patientsBtn.setOnAction( e-> {
            buttonStyleOnAction(patientsBtn, patientsIcon);
            PatientsMenu patientsMenu = new PatientsMenu();
            try {
                patientsMenu.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        employeesBtn.setOnAction( e-> {
            buttonStyleOnAction(employeesBtn, employeesIcon);
            EmployeesMenu employeesMenu = new EmployeesMenu();
            try {
                employeesMenu.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        medsBtn.setOnAction( e-> {
            buttonStyleOnAction(medsBtn, medicationIcon);
            MedicationsMenu medicationsMenu = new MedicationsMenu();
            try {
                medicationsMenu.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        pharmacyBtn.setOnAction(e -> {
            buttonStyleOnAction(pharmacyBtn, pharmacyIcon);
            PharmacyMenu pharmacyMenu = new PharmacyMenu();
            try {
                pharmacyMenu.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        usersBtn.setOnAction( e -> {
            buttonStyleOnAction(usersBtn, usersIcon);
            UsersMenu usersMenu = new UsersMenu();
            try {
                usersMenu.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        menuStage.setMaximized(true);
        menuStage.setResizable(true);
        menuStage.setMinWidth(700);

        menuStage.setTitle("Main Menu");
        menuStage.getIcons().add(new Image("https://static.thenounproject.com/png/5394408-200.png"));
        menuStage.show();
    }

    void buttonStyle(Button btn, ImageView imageView) {
        btn.setStyle("-fx-background-color: white; -fx-border-color: darkblue; " +
                "-fx-border-radius: 20px; -fx-border-width: 5px; -fx-background-radius: 20px;" +
                "-fx-font-weight:  bold");
        btn.setGraphic(imageView);
        btn.setContentDisplay(ContentDisplay.TOP);
        btn.setTextFill(Color.DARKBLUE);
        btn.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
    }

    void buttonStyleOnAction(Button btn, ImageView imageView) {

        btn.setStyle("-fx-background-color: aliceblue;  -fx-border-color: darkblue;" +
                "-fx-border-radius: 20px; -fx-border-width: 5px; -fx-background-radius: 20px; " +
                "-fx-font-weight: bold;-fx-opacity: 0.5;");
        btn.setGraphic(imageView);
        btn.setContentDisplay(ContentDisplay.TOP);
        btn.setTextFill(Color.DARKBLUE);
        btn.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(200), evt -> buttonStyle(btn, imageView))
        );
        timeline.play();
    }


    void btnBoxSet(FlowPane btnBox, LayoutPane menuPane, Stage stage) {
        btnBox.setStyle("-fx-background-color: aliceblue");
        btnBox.setAlignment(Pos.CENTER);
        btnBox.setHgap(50);
        btnBox.setVgap(50);
        menuPane.setCenter(btnBox);
//        stage.setScene(adminScene);
        stage.setMaximized(true);
        stage.setResizable(false);
//        stage.setTitle("Main Menu");
    }

}

