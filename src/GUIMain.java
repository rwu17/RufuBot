import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.TOP_LEFT);

        Label profile = new Label("Profiles");
        GridPane.setConstraints(profile, 0, 0);

        ArrayList<String> Profiles = new ArrayList<>();

        ChoiceBox<String> profiles = new ChoiceBox<>();
        Profile.LoadProfiles(profiles, Profiles);
        GridPane.setConstraints(profiles, 0, 1);
        /*
        profiles.getItems().add();
        */
        Button proceed = new Button("Proceed");
        proceed.setOnAction(event -> {
            //Proceed event
        });
        GridPane.setConstraints(proceed, 0,2);

        Button newProfile = new Button("New Profile");
        newProfile.setOnAction(event -> {
            TextInputDialog createProfile = new TextInputDialog("");
            createProfile.setTitle("RufuBot");
            createProfile.setHeaderText("Please enter the name for profile");

            Scanner profileName = new Scanner(System.in);

            createProfile.setContentText("Profile Name: ");
            Optional<String> nameProfile = createProfile.showAndWait();

            nameProfile.ifPresent(name -> {
                for (String x: Profiles) {
                    if (x.toLowerCase().equals(name.toLowerCase())){
                        Alert nameTaken = new Alert(Alert.AlertType.ERROR);
                        nameTaken.setTitle("RufuBot");
                        nameTaken.setHeaderText(null);
                        nameTaken.setContentText("The entered name already exists!");
                        Optional<ButtonType> confirm = nameTaken.showAndWait();
                    }
                    else {
                        try {
                            profiles.getItems().add(name);
                            Profile.CreateProfile(name, Profiles);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //Profile.CreateProfileDocument(name);
                    }
                }
            });
        });
        GridPane.setConstraints(newProfile, 1,1);

        Button deleteProfile = new Button("Delete Profile");
        deleteProfile.setOnAction(event -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("RufuBot");
            confirm.setHeaderText(null);
            confirm.setContentText("Sure you want to delete the selected profile?");
            Optional<ButtonType> answer = confirm.showAndWait();

            String selected = profiles.getSelectionModel().getSelectedItem();

            if (answer.isPresent() && answer.get() == ButtonType.OK){
                try {
                    Profile.DeleteProfile(selected, Profiles, profiles);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        GridPane.setConstraints(deleteProfile,2,1);

        Button editProfile = new Button("Edit Profile");

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

        grid.getChildren().addAll(
                profile, profiles, proceed, newProfile, deleteProfile
        );
        Scene scene = new Scene(grid, 800, 600);

        return scene;
    }

}
