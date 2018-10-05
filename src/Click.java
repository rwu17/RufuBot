import java.awt.*;
import java.awt.event.InputEvent;

public class Click {

    static void proceed(String button, int delay/*ms*/){

        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        //robot.delay(3000); //Start in 3 seconds

        switch (button) {
            case "Left Click":
                try {
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.delay(delay);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    robot.delay(delay);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Right Click":
                try {
                    robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                    robot.delay(delay);
                    robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
                    robot.delay(delay);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Middle Click":
                try {
                    robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                    robot.delay(delay);
                    robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                    robot.delay(delay);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
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

    static void MousePosition() {

    }

    static void MoveMouse(Double xCoord, Double yCoord) {

        int x = (int) Math.round(xCoord);
        int y = (int) Math.round(yCoord);

        try {
            Robot robot = new Robot();
            robot.mouseMove(x,y);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /*
    public void setDelay(int ms) {
        this.delay = ms;
    }
    */
}
