import java.awt.*;

public class MouseMover {
    public static void main(String[] args) {
        System.out.println("Mouse Clicker");

        try {
            int xCoord = 500;
            int yCoord = 500;

            Robot robot = new Robot();
            robot.mouseMove(xCoord,yCoord);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
