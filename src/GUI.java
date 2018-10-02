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
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.TOP_LEFT);

        Label profile = new Label("Profiles");
        GridPane.setConstraints(profile, 0, 0);
        grid.add(profile,0,0);

        ArrayList<String> Profiles = new ArrayList<>();
        ComboBox<String> profiles = new ComboBox();

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
        GridPane.setConstraints(newProfile, 1,1);

        Button deleteProfile = new Button("Delete");
        deleteProfile.setOnAction(event -> {
            if (Profiles.isEmpty()) { //profiles.getSelectionModel().getSelectedItem().equals(" ")
                Profile.None();
            } else {
                Profile.DeleteProfile(profilesList, Profiles, profiles);
            }
        });
        GridPane.setConstraints(deleteProfile,2,1);

        Button editProfile = new Button("Edit Profile");
        editProfile.setOnAction(event -> {
            //Edit profile
            if (Profiles.isEmpty()) { //profiles.getSelectionModel().getSelectedItem().equals(" ")
                Profile.None();
            }
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

        HBox Inputs = new HBox(5);
        Inputs.getChildren().add(profiles);
        Inputs.getChildren().add(newProfile);
        Inputs.getChildren().add(deleteProfile);
        grid.add(Inputs,0,1);

        HBox EditProfile = new HBox(5);
        EditProfile.getChildren().add(proceed);
        EditProfile.getChildren().add(editProfile);
        grid.add(EditProfile,0,2);



        Scene scene = new Scene(grid, 800, 600);

        return scene;
    }
}
