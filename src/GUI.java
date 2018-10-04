import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
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

        TableView table = new TableView();

        TableColumn actionType = new TableColumn("Action Type");
        TableColumn actionInput = new TableColumn("Input");

        table.getColumns().addAll(actionType, actionInput);

        table.setEditable(false);

        ArrayList<String> Profiles = new ArrayList<>();
        ComboBox<String> profiles = new ComboBox();
        ArrayList<String> Commands = new ArrayList<>();

        Profile.LoadProfiles(profilesList, Profiles, profiles);

        if (Profiles.size() > 0) {
            profiles.getSelectionModel().selectFirst();
        }

        Button proceed = new Button("Proceed");
        proceed.setOnAction(event -> {
            //Proceed event
            if (Profiles.isEmpty()) { //profiles.getSelectionModel().getSelectedItem().equals(" ")
                Profile.None();
            }
        });

        Button newProfile = new Button("Add");
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

        Button deleteProfile = new Button("Delete");
        deleteProfile.setOnAction(event -> {
            if (Profiles.isEmpty()) { //profiles.getSelectionModel().getSelectedItem().equals(" ")
                Profile.None();
            } else {
                Profile.DeleteProfile(profilesList, Profiles, profiles);
            }
        });

        Button editProfile = new Button("Edit Profile");
        Button cancel = new Button("Cancel");
        Button addCommand = new Button("Add Action");
        Button removeCommand = new Button("Remove Action");
        Button apply = new Button("Apply");

        addCommand.setDisable(true);
        addCommand.setOnAction(event -> {
            //Add action
        });

        removeCommand.setDisable(true);
        removeCommand.setOnAction(event -> {
            //Remove action
        });

        apply.setDisable(true);
        apply.setOnAction(event -> {
            //Apply setting
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("RufuBot");
            confirm.setHeaderText(null);
            confirm.setContentText("Are you sure you want to apply the current settings?\n The original settings will be overwritten.");
            Optional<ButtonType> answer = confirm.showAndWait();

            editProfileButtons(editProfile, cancel, addCommand, removeCommand, apply, answer);
        });

        cancel.setDisable(true);
        cancel.setOnAction(event -> {
            //Cancel setting
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("RufuBot");
            confirm.setHeaderText(null);
            confirm.setContentText("Are you sure you want to cancel the current settings?\nThe changes will not be saved.");
            Optional<ButtonType> answer = confirm.showAndWait();

            editProfileButtons(editProfile, cancel, addCommand, removeCommand, apply, answer);

        });

        editProfile.setOnAction(event -> {
            //Edit profile
            if (Profiles.isEmpty()) { //profiles.getSelectionModel().getSelectedItem().equals(" ")
                Profile.None();
            } else {

                editProfile.setDisable(true);
                table.setEditable(true);
                addCommand.setDisable(false);
                removeCommand.setDisable(false);
                apply.setDisable(false);
                cancel.setDisable(false);
            }
        });
        GridPane.setConstraints(editProfile, 1,2);

        ChoiceBox<String> action = new ChoiceBox<>();
        action.getItems().addAll("Click", "Type", "Delay");

        HBox Inputs = new HBox(10);
        Inputs.getChildren().add(profiles);
        Inputs.getChildren().add(newProfile);
        Inputs.getChildren().add(deleteProfile);
        //grid.add(Inputs,0,1);

        HBox EditProfile = new HBox(10);
        EditProfile.getChildren().add(proceed);
        EditProfile.getChildren().add(editProfile);
        //grid.add(EditProfile,0,2);

        VBox top = new VBox(5);
        top.setPadding(new Insets(15,12,15,12));
        top.setSpacing(10);
        top.getChildren().add(profile);
        top.getChildren().add(Inputs);
        top.getChildren().add(EditProfile);

        border.setTop(top);

        VBox editCommand = new VBox(5);
        editCommand.getChildren().addAll(addCommand, removeCommand, apply,cancel);

        HBox Actions = new HBox(5);
        Actions.setPadding(new Insets(15,12,15,12));
        Actions.setSpacing(10);
        Actions.getChildren().add(table);
        Actions.getChildren().add(editCommand);

        border.setLeft(Actions);

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
