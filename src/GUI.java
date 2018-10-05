import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.Time;
import java.util.ArrayList;

import java.util.Optional;
import java.util.Scanner;

public class GUI extends javafx.application.Application{

    private static Stage PrimaryStage;
    private static boolean answer;

    public void start(Stage primaryStage) throws IOException {
        PrimaryStage = primaryStage;
        primaryStage.setTitle("RufuBot");
        primaryStage.setScene(GenerateScene());
        primaryStage.setOnCloseRequest(event -> {
                event.consume();
                closeProgram();
        });
        primaryStage.show();
    }

    private void closeProgram() {
        Boolean answer = GUI.display("Rufubot", "Sure you want to exit?");
        if (answer) {
            PrimaryStage.close();
        }
    }

    private static boolean display(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(message);
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == yes) {
            answer = true;
        } else if (result.get() == no) {
            answer = false;
        }
        return answer;
    }

    private Scene GenerateScene() throws IOException {

        File profilesList = new File("Profiles.txt");
        profilesList.createNewFile();
        //FileOutputStream ofile = new FileOutputStream(profilesList, true);

        BorderPane border = new BorderPane();

        Label profile = new Label("Profiles");

        Label actionList = new Label("Action list");
        actionList.setFont(new Font("Segoe UI", 20));

        TableView table = new TableView();

        TableColumn actionType = new TableColumn("Action Type");
        TableColumn actionInput = new TableColumn("Input");

        table.getColumns().addAll(actionType, actionInput);
        table.setDisable(true);

        ArrayList<String> Profiles = new ArrayList<>();
        ComboBox<String> profiles = new ComboBox();
        profiles.setMaxWidth(120);
        profiles.setMinWidth(120);

        ArrayList<String> Commands = new ArrayList<>();
        ChoiceBox<String> ActionType = new ChoiceBox<>();
        ActionType.setDisable(true);
        Label type = new Label("Action Type");

        Button proceed = new Button("Proceed");
        Button newProfile = new Button("Add");
        Button deleteProfile = new Button("Delete");
        Button editProfile = new Button("Edit Profile");
        Button cancel = new Button("Cancel");
        Button addCommand = new Button("Add Action");
        Button removeCommand = new Button("Remove Action");
        Button apply = new Button("Apply");

        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);

        Profile.LoadProfiles(profilesList, Profiles, profiles);

        if (Profiles.size() > 0) {
            profiles.getSelectionModel().selectFirst();
        }

        proceed.setOnAction(event -> {
            //Proceed event
            if (Profiles.isEmpty()) { //profiles.getSelectionModel().getSelectedItem().equals(" ")
                Profile.None();
            }
        });

        newProfile.setOnAction(event -> {
            TextInputDialog createProfile = new TextInputDialog("Profile Name");
            createProfile.setTitle("RufuBot");
            createProfile.setHeaderText("Please enter the name for profile");
            createProfile.setContentText("");
            Optional<String> nameProfile = createProfile.showAndWait();

            nameProfile.ifPresent((String name) -> {
                if (name.isEmpty()) {
                    Alert noName = new Alert(Alert.AlertType.ERROR);
                    noName.setTitle("RufuBot");
                    noName.setHeaderText(null);
                    noName.setContentText("Please enter your profile name:");
                    Optional<ButtonType> ok = noName.showAndWait();
                } /*else if (Profiles.isEmpty()){
                    Profile.AddProfile(profilesList, name, Profiles, profiles);
                }*/
                else if (name.trim().isEmpty()) {
                    Alert nameWrong = new Alert(Alert.AlertType.ERROR);
                    nameWrong.setTitle("RufuBot");
                    nameWrong.setHeaderText(null);
                    nameWrong.setContentText("The entered name is invalid.");
                    Optional<ButtonType> ok = nameWrong.showAndWait();
                }
                else if (Profile.sameName(name, Profiles)){ //Profiles.contains(name),Profile.sameName(name, Profiles)
                    Alert nameTaken = new Alert(Alert.AlertType.ERROR);
                    nameTaken.setTitle("RufuBot");
                    nameTaken.setHeaderText(null);
                    nameTaken.setContentText("A similar name already exists!");
                    Optional<ButtonType> ok = nameTaken.showAndWait();
                    /*
                    for (String x: Profiles) {
                        if (x.toLowerCase().equals(name.toLowerCase())) {}
                    }*/
                }
                else {
                    Profile.AddProfile(profilesList, name, Profiles, profiles);
                    Profile.CreateProfileDocument(name);
                }
            });
        });
        newProfile.setMinWidth(50);

        HBox Inputs = new HBox(10);
        Inputs.getChildren().add(profiles);
        Inputs.getChildren().add(newProfile);
        Inputs.getChildren().add(deleteProfile);

        HBox EditProfile = new HBox(10);
        editProfile.setMinWidth(110);
        proceed.setMinWidth(120);
        EditProfile.getChildren().addAll(proceed,editProfile);

        VBox top = new VBox(5);
        top.setPadding(new Insets(15,12,5,12));
        top.getChildren().add(profile);
        top.getChildren().add(Inputs);
        top.getChildren().add(EditProfile);

        VBox editCommand = new VBox(10);
        editCommand.setPadding(new Insets(33,0,0,0));
        editCommand.getChildren().addAll(addCommand, removeCommand, apply,cancel);

        VBox tableName = new VBox(10);
        tableName.getChildren().addAll(actionList, table);

        HBox Actions = new HBox(15);
        Actions.setPadding(new Insets(5,5,15,12));
        Actions.getChildren().add(tableName);
        Actions.getChildren().add(editCommand);

        VBox borderLeft = new VBox(5);
        borderLeft.setPadding(new Insets(5,5,15,12));
        borderLeft.getChildren().addAll(top, Actions);

        HBox leftSide = new HBox();
        leftSide.getChildren().addAll(borderLeft, separator);

        addCommand.setDisable(true);
        addCommand.setOnAction(event -> {
            //Add action
            ActionType.setDisable(false);
        });
        addCommand.setMinWidth(120);

        removeCommand.setDisable(true);
        removeCommand.setOnAction(event -> {
            //Remove action
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("RufuBot");
            confirm.setHeaderText(null);
            confirm.setContentText("Are you sure you want to remove the selected action?\n You cannot undo once the action is removed.");
            Optional<ButtonType> answer = confirm.showAndWait();

            if (answer.isPresent() && answer.get() == ButtonType.OK){
            }

        });
        removeCommand.setMinWidth(120);

        apply.setDisable(true);
        apply.setOnAction(event -> {
            //Apply setting
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("RufuBot");
            confirm.setHeaderText(null);
            confirm.setContentText("Are you sure you want to apply the current settings?\n The original settings will be overwritten.");
            Optional<ButtonType> answer = confirm.showAndWait();
            editProfileButtons(editProfile, cancel, addCommand, removeCommand, apply, answer);
            ActionType.setDisable(true);
            table.setDisable(true);
            profiles.setDisable(false);
            proceed.setDisable(false);
            newProfile.setDisable(false);
            deleteProfile.setDisable(false);
            editProfile.setDisable(false);
        });
        apply.setMinWidth(120);

        cancel.setDisable(true);
        cancel.setOnAction(event -> {
            //Cancel setting
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("RufuBot");
            confirm.setHeaderText(null);
            confirm.setContentText("Are you sure you want to cancel the current settings?\nThe changes will not be saved.");
            Optional<ButtonType> answer = confirm.showAndWait();
            editProfileButtons(editProfile, cancel, addCommand, removeCommand, apply, answer);
            ActionType.setDisable(true);
            table.setDisable(true);
            profiles.setDisable(false);
            proceed.setDisable(false);
            newProfile.setDisable(false);
            deleteProfile.setDisable(false);
            editProfile.setDisable(false);
        });
        cancel.setMinWidth(120);

        deleteProfile.setOnAction(event -> {
            if (Profiles.isEmpty()) { //profiles.getSelectionModel().getSelectedItem().equals(" ")
                Profile.None();
            } else {
                Profile.DeleteProfile(profilesList, Profiles, profiles);
                editProfile.setDisable(false);
                addCommand.setDisable(true);
                removeCommand.setDisable(true);
                apply.setDisable(true);
                cancel.setDisable(true);
                ActionType.setDisable(true);
            }
        });
        deleteProfile.setMinWidth(50);

        editProfile.setOnAction(event -> {
            //Edit profile
            if (Profiles.isEmpty()) {
                Profile.None();
            } else {
                profiles.setDisable(true);
                proceed.setDisable(true);
                newProfile.setDisable(true);
                deleteProfile.setDisable(true);
                editProfile.setDisable(true);
                table.setDisable(false);
                addCommand.setDisable(false);
                removeCommand.setDisable(false);
                apply.setDisable(false);
                cancel.setDisable(false);
            }
        });

        border.setLeft(leftSide);
        //-------------------------------------------Left Part of the screen ---------------------------
        VBox rightSide = new VBox(5);
        rightSide.setPadding(new Insets(20, 12, 15, 12));
        rightSide.getChildren().addAll(type, ActionType);
        border.setCenter(rightSide);

        Label MouseButton = new Label("Mouse Button");
        ChoiceBox<String> mouseButton = new ChoiceBox<>();
        mouseButton.getItems().addAll("Left Click", "Right Click", "Middle Click");

        Label ClickTime = new Label("Repeat Time");
        TextField TimeClick = new TextField();
        TimeClick.setMinWidth(70);
        TimeClick.setMaxWidth(70);

        Label ClickDelay = new Label("Click Delay");
        TextField clickDelay = new TextField();
        clickDelay.setMinWidth(70);
        clickDelay.setMaxWidth(70);

        Label mousePositionLabel = new Label("Clicking Position");
        Button mousePosition = new Button("Set Position");
        mousePosition.setMinWidth(149);

        Label x = new Label("X:");
        TextField xPos = new TextField();
        xPos.setPromptText("X-Coordinate");
        xPos.setMinWidth(243);

        Label y = new Label("Y:");
        TextField yPos = new TextField();
        yPos.setPromptText("Y-Coordinate");
        yPos.setMinWidth(243);

        VBox mouseButtonSet = new VBox(5);
        mouseButtonSet.getChildren().addAll(MouseButton, mouseButton);

        VBox clickTimeSet = new VBox(5);
        clickTimeSet.getChildren().addAll(ClickTime, TimeClick);

        VBox clickTimeSet2 = new VBox(5);
        clickTimeSet2.getChildren().addAll(ClickDelay, clickDelay);

        HBox mouseSetting = new HBox(10);
        mouseSetting.getChildren().addAll(mouseButtonSet, clickTimeSet, clickTimeSet2);

        HBox getPosition = new HBox(21);
        getPosition.getChildren().addAll(mousePositionLabel, mousePosition);
        getPosition.setAlignment(Pos.CENTER_LEFT);

        HBox xPosition = new HBox(5);
        xPosition.getChildren().addAll(x, xPos);
        xPosition.setAlignment(Pos.CENTER_LEFT);

        HBox yPosition = new HBox(5);
        yPosition.getChildren().addAll(y, yPos);
        yPosition.setAlignment(Pos.CENTER_LEFT);

        VBox Positions = new VBox(10);
        Positions.getChildren().addAll(getPosition, xPosition, yPosition);

        VBox mouseMenu = new VBox(15);
        mouseMenu.setPadding(new Insets(10,12,15,0));
        mouseMenu.getChildren().addAll(mouseSetting, Positions);

        //----------------------Mouse Menu----------------------------------------------
        Label keyboardInput = new Label("Text Input");
        TextField textInput = new TextField();



        VBox keyboardMenu = new VBox(5);
        keyboardMenu.setPadding(new Insets(10,12,15,0));
        //----------------------Keyboard Menu-------------------------------------------
        VBox delayMenu = new VBox(5);
        delayMenu.setPadding(new Insets(10,12,15,0));

        ActionType.getItems().addAll("Mouse Click", "Keyboard", "Delay");
        ActionType.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            switch (newValue) {
                case "Mouse Click":
                    rightSide.getChildren().removeAll(keyboardMenu, delayMenu);
                    rightSide.getChildren().addAll(mouseMenu);

                    break;
                case "Keyboard":
                    rightSide.getChildren().removeAll(mouseMenu, delayMenu);
                    rightSide.getChildren().addAll(keyboardMenu);

                    break;
                case "Delay":
                    rightSide.getChildren().removeAll(mouseMenu, keyboardMenu);
                    rightSide.getChildren().addAll(delayMenu);
                    break;
                default:
                    break;
            }
        });

        Scene scene = new Scene(border, 800, 600);
        return scene;
    }

    private void editProfileButtons(Button editProfile, Button cancel, Button addCommand, Button removeCommand, Button apply, Optional<ButtonType> answer) {
        if (answer.isPresent() && answer.get() == ButtonType.OK){
            cancel.setDisable(true);
            apply.setDisable(true);
            editProfile.setDisable(false);
            addCommand.setDisable(true);
            removeCommand.setDisable(true);
        }
    }
}
