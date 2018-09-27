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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MouseMover)) return false;
        MouseMover that = (MouseMover) o;
        return getxCoord() == that.getxCoord() &&
                getyCoord() == that.getyCoord();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getxCoord(), getyCoord());
    }

    @Override
    public String toString() {
        return "MouseMover{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                '}';
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
