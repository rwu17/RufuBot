import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Formatter;

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



        return new Scene(root, 800, 600);
    }

}
