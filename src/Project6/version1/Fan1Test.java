package Project6.version1;

public class Fan1Test {
    public static void main(String[] args) {
        Fan1 fan1 = new Fan1();
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println(fan1.toString());
    }
}
