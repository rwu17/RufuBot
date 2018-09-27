import java.awt.*;
import java.awt.event.InputEvent;

public class Clicker {

    private Robot robot;
    private int delay;

    void proceed(int delay){
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Delay between clicks (ms): ");
        int delay = scanner.nextInt();
        */
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        //robot.delay(3000); //Start in 3 seconds

        Clicker clicker = new Clicker();
        clicker.setDelay(delay);

        clicker.clickMouse(InputEvent.BUTTON1_DOWN_MASK);
    }
/*
    public Clicker() {
        try {
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        delay = 300;
    }
*/
    public void clickMouse(int button) {
        try {
            robot.mousePress(button);
            robot.delay(delay);
            robot.mouseRelease(button);
            robot.delay(delay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDelay(int ms) {
        this.delay = ms;
    }
}
