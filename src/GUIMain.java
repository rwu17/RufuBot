import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Formatter;

public class GUIMain extends javafx.application.Application{

    Formatter profiles = new Formatter();


    static Stage primaryStage;

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("RufuBot");

        VBox root = new VBox(5.0);
        root.setAlignment(Pos.CENTER);

        root.setPadding(new Insets(20));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        primaryStage.setX(screenSize.width / 2 - (600 / 2));
        primaryStage.setY(screenSize.height / 2 - (400 / 2));

        primaryStage.show();

    }

    private Scene GenerateScene() {
        VBox root = new VBox();
        SplitPane splt = new SplitPane();
        ScrollPane scrl = new ScrollPane();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setMinWidth(260);
        return null;
    }

}
