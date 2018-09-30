import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

import java.util.Optional;
import java.util.Scanner;

public class GUI extends javafx.application.Application{

    static Stage PrimaryStage;

    public void start(Stage primaryStage) throws IOException {
        PrimaryStage = primaryStage;
        primaryStage.setTitle("RufuBot");
        primaryStage.setScene(GenerateScene());
        primaryStage.show();
    }

    private Scene GenerateScene() throws IOException {

        File profilesList = new File("Profiles.txt");
        profilesList.createNewFile();
        //FileOutputStream ofile = new FileOutputStream(profilesList, true);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.TOP_LEFT);

        Label profile = new Label("Profiles");
        GridPane.setConstraints(profile, 0, 0);

        ArrayList<String> Profiles = new ArrayList<>();
        ChoiceBox<String> profiles = new ChoiceBox<>();

        Profile.LoadProfiles(profilesList, Profiles, profiles);

        if (Profiles.size() > 0) {
            profiles.getSelectionModel().selectFirst();
        }
        GridPane.setConstraints(profiles, 0, 1);

        Button proceed = new Button("Proceed");
        proceed.setOnAction(event -> {
            //Proceed event
        });
        GridPane.setConstraints(proceed, 0,2);

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
        GridPane.setConstraints(newProfile, 1,1);

        Button deleteProfile = new Button("Delete");
        deleteProfile.setOnAction(event -> {
            if (Profiles.isEmpty()) { //profiles.getSelectionModel().getSelectedItem().equals(" ")
                Alert none = new Alert(Alert.AlertType.ERROR);
                none.setTitle("RufuBot");
                none.setHeaderText(null);
                none.setContentText("Please select a profile!");
                Optional<ButtonType> ok = none.showAndWait();
            } else {
                Profile.DeleteProfile(profilesList, Profiles, profiles);
            }
        });
        GridPane.setConstraints(deleteProfile,2,1);

        Button editProfile = new Button("Edit");
        editProfile.setOnAction(event -> {
            //Edit profile
        });
        GridPane.setConstraints(editProfile, 1,2);

        Button apply = new Button("Apply");
        apply.setOnAction(event -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("RufuBot");
            confirm.setHeaderText(null);
            confirm.setContentText("Are you sure you want to apply the current settings?");
            Optional<ButtonType> answer = confirm.showAndWait();

            if (answer.isPresent() && answer.get() == ButtonType.OK){
                //Apply setting
            }
        });

        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> {
            //Cancel setting
        });

        ChoiceBox<String> action = new ChoiceBox<>();
        action.getItems().addAll("Click", "Type", "Delay");

        grid.getChildren().addAll(
                profile, profiles, proceed, newProfile, deleteProfile, editProfile
        );
        Scene scene = new Scene(grid, 800, 600);

        return scene;
    }
}
