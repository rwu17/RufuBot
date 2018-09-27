import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;

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

        Button deleteProfile = new Button("Delete Profile");

        Button editProfile = new Button("Edit Profile");

        Button apply = new Button("Apply");

        apply.setOnAction(even -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("RufuBot");
            confirm.setHeaderText(null);
            confirm.setContentText("Sure you want to apply the current settings?");
            Optional<ButtonType> answer = confirm.showAndWait();

        });

        Button cancel = new Button("Cancel");

        ChoiceBox<String> action = new ChoiceBox<>();
        action.getItems().addAll("Click", "Type", "Delay");

        return new Scene(root, 800, 600);
    }

}
