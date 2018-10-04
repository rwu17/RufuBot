import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.awt.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Optional;
import java.util.Scanner;

public class Profile{

    String profileName;

    //ArrayList<Command> Commands = new ArrayList<>();

    private Scanner profile;

    /*
    public Profile(String profileName) {
        this.profileName = profileName;
        this.CreateProfileDocument(profileName);
    }
    */

    static void CreateProfileDocument(String profileName){
        File profileDocument = new File(profileName + ".txt");
        try {
            profileDocument.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void LoadProfiles(File profilesList, ArrayList<String> Profiles, ComboBox<String> profiles) {
        try (BufferedReader br = new BufferedReader(new FileReader(profilesList))) {
            String line;
            while ((line = br.readLine()) != null) {
                Profiles.add(line);
                profiles.getItems().add(line);
            }
            System.out.print(Profiles);
            System.out.println("\n---------------------\n");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void AddProfile(File profilesList, String name, ArrayList<String> Profiles, ComboBox<String> profiles){
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("RufuBot");
        confirm.setHeaderText(null);
        confirm.setContentText("Are you sure you want the profile name \"" + name + "\"?");
        Optional<ButtonType> answer = confirm.showAndWait();

        if (answer.isPresent() && answer.get() == ButtonType.OK) {
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(profilesList, true));
            } catch (IOException e) {
                System.out.println("bw = new bufferedwriter error");
                e.printStackTrace();
            }
            try {
                bw.append(name).append("\n");
            } catch (IOException e) {
                System.out.println("bw.append error");
                e.printStackTrace();
            }
            Profiles.add(name);
            profiles.getItems().add(name);
            //Profile.CreateProfileDocument(name);
            profiles.getSelectionModel().select(name);
            System.out.print(Profiles);
            System.out.println("\n---------------------\n");
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void DeleteProfile(File profilesList, ArrayList<String> Profiles, ComboBox<String> profiles) {
        try {
            String selected = profiles.getSelectionModel().getSelectedItem();
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("RufuBot");
            confirm.setHeaderText(null);
            confirm.setContentText("Are you sure you want to delete the profile \"" + selected + "\"?");
            Optional<ButtonType> answer = confirm.showAndWait();

            if (answer.isPresent() && answer.get() == ButtonType.OK) {
                Profiles.remove(selected);
                profiles.getItems().remove(selected);
                File ProfileFile = new File(selected + ".txt");
                FileOutputStream file = new FileOutputStream(ProfileFile);
                file.close();
                ProfileFile.delete();

                BufferedWriter bw = new BufferedWriter(new FileWriter(profilesList));
                for (String x: Profiles) {
                    bw.write(x + "\n");
                }
                profiles.getSelectionModel().selectFirst();
                bw.close();
                System.out.print(Profiles);
                System.out.println("\n---------------------\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void None(){
        Alert none = new Alert(Alert.AlertType.ERROR);
        none.setTitle("RufuBot");
        none.setHeaderText(null);
        none.setContentText("Please select a profile!");
        Optional<ButtonType> ok = none.showAndWait();
    }

    static boolean sameName(String name, ArrayList<String> Profiles) {
        for (int i = 0; i < Profiles.size(); i++) {
            if (Profiles.get(i).toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    void loadProfile(String profileName) {
        while(profile.hasNext()) {
            String line = profile.nextLine();
        }
    }
}