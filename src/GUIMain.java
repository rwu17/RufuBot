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
        VBox root = new VBox();
        SplitPane splt = new SplitPane();
        ScrollPane scrl = new ScrollPane();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setMinWidth(260);

        Label profile = new Label("Profile");
        //Print the lable

        ChoiceBox<String> profiles = new ChoiceBox<>();
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

        scrl.setContent(grid);
        VBox Menu = new VBox(5);

        splt.getItems().add(scrl);
        splt.getItems().add(Menu);
        splt.setDividerPositions(0);

        root.getChildren().add(splt);


        HBox ButtonBox = new HBox(5);
        ButtonBox.getChildren().add(newProfile);
        grid.add(ButtonBox,0,1);

        return new Scene(root, 800, 600);
    }

}
