import java.awt.*;
import java.util.Objects;

public class MouseMover {

    Double xCoord, yCoord;

    public Double getxCoord() {
        return xCoord;
    }

    public void setxCoord(Double xCoord) {
        this.xCoord = xCoord;
    }

    public Double getyCoord() {
        return yCoord;
    }

    public void setyCoord(Double yCoord) {
        this.yCoord = yCoord;
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
