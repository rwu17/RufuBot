import javafx.scene.control.ChoiceBox;

import java.io.*;

import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Profile extends Command{

    String profileName;

    ArrayList<Profile> Profiles = new ArrayList<>();

    ArrayList<Command> Commands = new ArrayList<>();

    private Scanner profile;

    public Profile(String profileName) {
        this.profileName = profileName;
        this.CreateProfileDocument(profileName);
    }

    static void CreateProfileDocument(String profileName) {
        try {
            Formatter profile = new Formatter(profileName + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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


    static void DeleteProfile(String profileName, ArrayList<String> Profiles, ChoiceBox<String> profilesList) throws IOException {

        Profiles.remove(profileName);
        profilesList.getItems().remove(profileName);

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
        Scanner line = new Scanner(System.in);
        File profilesList = new File("Profiles.txt");
        BufferedReader br = new BufferedReader(new FileReader(profilesList));
        while (line.hasNext()) {
            Profiles.add(line.nextLine());
            if (!(profiles.getItems().contains(line))) {
                profiles.getItems().add(line.nextLine());
            }
        }

        br.close();
    }
}