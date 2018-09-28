import javafx.scene.control.ChoiceBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Profile extends Command{

    String profileName;

    ArrayList<Command> Commands = new ArrayList<>();

    private Scanner profile;

    public Profile(String profileName) {
        this.profileName = profileName;
        this.CreateProfileDocument(profileName);
    }

    void CreateProfileDocument(String profileName) {
        try {
            profile = new Scanner( profileName + ".txt");
        } catch (Exception e) {
            System.out.println("Could not find file");
        }
    }

    void loadProfile(String profileName) {
        while(profile.hasNext()) {
            String line = profile.nextLine();

        }
    }

    static void CreateProfile(String profileName, ArrayList<String> Profiles) throws IOException {

        File profiles = new File("Profiles.txt");
        FileWriter fw = new FileWriter(profiles, true);
        BufferedWriter bw = new BufferedWriter(fw);
        Profiles.add(profileName);
        bw.write(profileName + "\n");

        bw.close();
        fw.close();
    }

    static void DeleteProfile(String profileName, ArrayList<String> Profiles) throws IOException {

        Profiles.remove(profileName);

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
            if (!(profiles.getItems().contains(line))) {
                profiles.getItems().add(line);
            }
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
