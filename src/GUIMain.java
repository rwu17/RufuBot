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
import java.util.Formatter;
import java.util.Optional;
import java.util.Scanner;

public class GUIMain extends javafx.application.Application{

    static Stage PrimaryStage;

    public void start(Stage primaryStage){
        PrimaryStage = primaryStage;
        primaryStage.setTitle("RufuBot");
        primaryStage.setScene(GenerateScene());
        primaryStage.show();
    }

    private Scene GenerateScene() {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        //grid.setAlignment(Pos.CENTER);

        Scene scene = new Scene(grid, 800, 600);

        Label profile = new Label("Profiles");
        GridPane.setConstraints(profile, 0, 0);

        ChoiceBox<String> profiles = new ChoiceBox<>();
        GridPane.setConstraints(profiles, 0, 1);
        /*
        profiles.getItems().add();
        */
        Button proceed = new Button("Proceed");

        Button newProfile = new Button("New Profile");

        newProfile.setOnAction(event -> {
            TextInputDialog createProfile = new TextInputDialog("");
            createProfile.setTitle("RufuBot");
            createProfile.setHeaderText("Please enter the name for profile");

            Scanner profileName = new Scanner(System.in);

            createProfile.setContentText("Profile Name: ");
            Optional<String> nameProfile = createProfile.showAndWait();

            nameProfile.ifPresent(name -> {
                try {
                    Profile.CreateProfile(name);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                profiles.getItems().add(name);

            });
        });

        Button deleteProfile = new Button("Delete Profile");

        deleteProfile.setOnAction(event -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("RufuBot");
            confirm.setHeaderText(null);
            confirm.setContentText("Sure you want to delete the selected profile?");
            Optional<ButtonType> answer = confirm.showAndWait();

            if (answer.isPresent() && answer.get() == ButtonType.OK){
                try {
                    Profile.DeleteProfile(profiles.getSelectionModel().getSelectedItem());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

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

        ChoiceBox<String> action = new ChoiceBox<>();
        action.getItems().addAll("Click", "Type", "Delay");

        /*
        HBox ButtonBox = new HBox(5);
        ButtonBox.getChildren().add(newProfile);
        grid.add(ButtonBox,0,1);
        */

        return scene;
    }

}
