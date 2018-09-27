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

    void CreateProfile(String profileName) {
        Profile name = new Profile(profileName);
        Profiles.add(name);


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
