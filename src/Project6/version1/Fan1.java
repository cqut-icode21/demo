package Project6.version1;

public class Fan1 {

    //一些private型的数据域
    public final int SLOW = 1;
    public final int MEDIUM = 2;
    public final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    //无参构造方法
    Fan1() {
        speed = SLOW;
        on = false;
        radius = 0;
        color = "blue";
    }

    //数据域的get与set方法
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    public boolean getOn() {
        return on;
    }

    public void setOn(boolean newOn) {
        on = newOn;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius) {
        radius = newRadius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String newColor) {
        color = newColor;
    }

    //重写Object中的toString方法
    @Override
    public String toString() {
        if (on)
            return "fan's speed is " + speed + ",color is " + color + " and the radius is " + radius;
        else
            return "fan is off,color is " + color + " and the radius is " + radius;
    }
}