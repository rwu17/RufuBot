import java.util.ArrayList;
import java.util.Formatter;

public class Profile extends Command{

    Formatter profileList;

    String profileName;

    ArrayList<Profile> Profiles = new ArrayList<>();

    ArrayList<Command> Commands = new ArrayList<>();

    public Profile(String profileName) {
        this.profileName = profileName;
    }

    void CreateProfileDocument() {
        try {
            profileList = new Formatter("Profiles.txt");
        } catch (Exception e) {
            System.out.println("Error on file creation");
        }

        profileList.close();

    }

    void CreateProfile(String profileName) {
        Profile name = new Profile(profileName);
        Profiles.add(name);


    }

    void DeleteProfile(String profileName) {
        Profiles.remove(profileName);
    }

    static void loadProfile() {

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
