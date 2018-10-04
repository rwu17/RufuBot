import java.awt.*;

public class Delay {

    static void setDelay(int delayTime) {
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        rb.delay(delayTime);
    }
}
