import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class GUIMain extends javafx.application.Application{
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
}
