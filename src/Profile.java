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

    static Formatter CreateProfileList() {

        Formatter profiles_txt;

        Path profiles = Paths.get("Profiles.txt");

        try {
            profiles_txt = new Formatter("Profiles.txt");
            profiles_txt.format("Profiles: \n");
            profiles_txt.close();

        } catch (Exception e) {
            System.out.println("Error on file creation.");
        }

        return profiles_txt;
    }

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

    static void CreateProfile(String profileName) {

        Formatter addProfile = Profile.CreateProfileList();

        Profile name = new Profile(profileName);

        addProfile.format();


    }

    void DeleteProfile(String profileName) {
        Profiles.remove(profileName);
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
