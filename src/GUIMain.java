import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Optional;
import java.util.Scanner;

public class GUIMain extends javafx.application.Application{

    static Stage PrimaryStage;

    public void start(Stage primaryStage) throws IOException {
        PrimaryStage = primaryStage;
        primaryStage.setTitle("RufuBot");
        primaryStage.setScene(GenerateScene());
        primaryStage.show();
    }

    private Scene GenerateScene() throws IOException {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.TOP_LEFT);

        Label profile = new Label("Profiles");
        GridPane.setConstraints(profile, 0, 0);

        ChoiceBox<String> profiles = new ChoiceBox<>();
        profiles.setTooltip(new Tooltip("Select a profile"));

        ArrayList<String> Profiles = new ArrayList<>();

        Profile.LoadProfiles(profiles, Profiles);
        if (profiles.getItems().size() > 0) {
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
            TextInputDialog createProfile = new TextInputDialog("");
            createProfile.setTitle("RufuBot");
            createProfile.setHeaderText("Please enter the name for profile");
            Optional<String> nameProfile = createProfile.showAndWait();

            nameProfile.ifPresent(name -> {
                try {
                    for (String x: Profiles) {
                        if (x.toLowerCase().equals(name.toLowerCase())){
                            Alert nameTaken = new Alert(Alert.AlertType.ERROR);
                            nameTaken.setTitle("RufuBot");
                            nameTaken.setHeaderText(null);
                            nameTaken.setContentText("The entered name already exists!");
                            Optional<ButtonType> confirm = nameTaken.showAndWait();
                        }
                        else {
                            Profile.CreateProfile(name, Profiles);
                            profiles.getItems().add(name);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
        GridPane.setConstraints(newProfile, 1,1);

        Button deleteProfile = new Button("Delete");
        deleteProfile.setOnAction(event -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("RufuBot");
            confirm.setHeaderText(null);
            confirm.setContentText("Sure you want to delete the selected profile?");
            Optional<ButtonType> answer = confirm.showAndWait();

            String selected = profiles.getSelectionModel().getSelectedItem();

            if (answer.isPresent() && answer.get() == ButtonType.OK){
                try {
                    profiles.getItems().remove(selected);
                    Profile.DeleteProfile(selected, Profiles);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        GridPane.setConstraints(deleteProfile,2,1);

        Button editProfile = new Button("Edit");
        editProfile.setOnAction(event -> {

        });
        GridPane.setConstraints(editProfile, 1,2);

        Button apply = new Button("Apply");
        apply.setOnAction(event -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("RufuBot");
            confirm.setHeaderText(null);
            confirm.setContentText("Sure you want to apply the current settings?");
            Optional<ButtonType> answer = confirm.showAndWait();

        });

        Button cancel = new Button("Cancel");

        cancel.setOnAction(event -> {

        });

        ChoiceBox<String> action = new ChoiceBox<>();
        action.getItems().addAll("Click", "Type", "Delay");

        /*
        HBox ButtonBox = new HBox(5);
        ButtonBox.getChildren().add(newProfile);
        grid.add(ButtonBox,0,1);
        */
        grid.getChildren().addAll(
                profile, profiles, proceed, newProfile, deleteProfile, editProfile
        );
        Scene scene = new Scene(grid, 800, 600);

        return scene;
    }

}
