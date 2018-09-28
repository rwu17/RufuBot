import javafx.application.Application;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;


public class Main {
    public static void main(String[] args) {
        Application.launch(GUIMain.class);

        Path profiles = Paths.get("Profiles.txt");

        if (!Files.exists(profiles)){
            Formatter profiles_txt;

            try {
                profiles_txt = new Formatter("Profiles.txt");
                profiles_txt.format("Profiles: \n");
                profiles_txt.close();
            } catch (Exception e) {
                System.out.println("Error on file creation.");
            }

        }

    }
}
