import java.awt.*;
import java.util.Objects;

public class Mover {

    private Double xCoord, yCoord;

    public void setxCoord(Double xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(Double yCoord) {
        this.yCoord = yCoord;
    }

    void createRange() {
        
    }

    void proceed(Double xCoord, Double yCoord) {

        int x = (int) Math.round(xCoord);

        int y = (int) Math.round(yCoord);

        try {
            Robot robot = new Robot();
            robot.mouseMove(x,y);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
