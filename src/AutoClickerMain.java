import java.awt.*;
import java.awt.event.InputEvent;
import java.lang.Thread;
import java.util.Scanner;

public class AutoClickerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mouse Clicker");
        System.out.println("Left click anywhere on the screen.");

        System.out.println("Enter delay between clicks in milliseconds: ");
        int delay = scanner.nextInt();
        System.out.println();

        System.out.println("Program will start in 3 seconds.");

        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.delay(3000);

        AutoClicker clicker = new AutoClicker();
        clicker.setDelay(delay);

        clicker.clickMouse(InputEvent.BUTTON1_DOWN_MASK);

        System.out.println("AutoClicker completes.");

    }
}
