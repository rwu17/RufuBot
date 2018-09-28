import java.io.*;
<<<<<<< HEAD
import java.nio.file.Files;
=======
import java.nio.file.Path;
import java.nio.file.Paths;
>>>>>>> parent of edb1451... Profile Completed (guess)
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

    static void CreateProfile(String profileName) throws IOException {

        File profiles = new File("Profiles.txt");
        FileWriter fr = new FileWriter(profiles, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(profileName + "\n");

        br.close();
        fr.close();
    }

<<<<<<< HEAD
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

=======
    static void DeleteProfile(String profileName) throws IOException {
        Scanner match = new Scanner(System.in);
>>>>>>> parent of edb1451... Profile Completed (guess)
        File profiles = new File("Profiles.txt");
        BufferedReader br = new BufferedReader(new FileReader(profiles));
        PrintWriter pw = new PrintWriter(new FileWriter(profiles));

        while (match.hasNext()) {
            if (match.equals(profileName)) {
                pw.println(profileName);
                pw.flush();
            }
        }

        pw.close();
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
