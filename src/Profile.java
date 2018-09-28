import javafx.scene.control.ChoiceBox;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Profile extends Command{

    String profileName;

    ArrayList<Command> Commands = new ArrayList<>();

    private Scanner profile;

    public Profile(String profileName) {
        this.profileName = profileName;
        //this.CreateProfileDocument(profileName);
    }
/*
    static void CreateProfileDocument(String profileName) {
        try {
            Formatter profile = new Formatter(profileName + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
*/

    void loadProfile(String profileName) {
        while(profile.hasNext()) {
            String line = profile.nextLine();

        }
    }

    static void CreateProfile(String profileName, ChoiceBox<String> profile, ArrayList<String> Profiles) throws IOException {

        File profiles = new File("Profiles.txt");
        FileWriter fw = new FileWriter(profiles, true);
        BufferedWriter bw = new BufferedWriter(fw);
        Profiles.add(profileName);
        bw.write(profileName + "\n");
        profile.getItems().add(profileName);


        bw.close();
        fw.close();
    }

    static void DeleteProfile(String profileName, ArrayList<String> Profiles) throws IOException {

        Profiles.remove(profileName);

        /*
        File file = new File(profileName + ".txt");

        if (file.delete()) {
            System.out.println(file.getName() + " is deleted.");
        } else {
            System.out.println("Operation failed");
        }
        */

        File profiles = new File("Profiles.txt");
        FileWriter fw = new FileWriter(profiles, false);
        BufferedWriter bw = new BufferedWriter(fw);

        for (String x: Profiles) {
            bw.write(x + "\n");
        }

        bw.close();
        fw.close();
    }

    static void LoadProfiles(ChoiceBox<String> profiles, ArrayList<String> Profiles) throws IOException {
        String line;
        File profilesList = new File("Profiles.txt");
        BufferedReader br = new BufferedReader(new FileReader(profilesList));
        while ((line = br.readLine()) != null) {
            Profiles.add(line);
            profiles.getItems().add(line);
            /*
            if (!(profiles.getItems().contains(line))) {
                profiles.getItems().add(line);
            }
            */
        }
        br.close();
    }

    @Override
    public void addCommand(Command command) {
        Commands.add(command);
    }

    public void removeCommand(Command command){
        Commands.remove(command);
    }

    @Override
    public void upCommand(Command command) {

    }

    @Override
    public void downCommand(Command command) {

    }

}
