package Project6.version2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class Fan2 extends Application {
    //一些private型的数据域
    private double radius = 20 * (Math.random() * 5 + 1);//随机生成半径
    private Color color = randomColor();
    private Circle circle = new Circle();
    private Arc arc1 = new Arc();
    private Arc arc2 = new Arc();
    private Arc arc3 = new Arc();
    private Arc arc4 = new Arc();

    //随机生成颜色的方法
    public static Color randomColor() {
        Random rand = new Random();
        int n = rand.nextInt(5);
        switch (n) {
            default:
            case 1:return Color.RED;
            case 2:return Color.BLUE;
            case 3:return Color.GREEN;
            case 4:return Color.YELLOW;
            case 5:return Color.ORANGE;
        }
    }

    public void start(Stage stage) {
        Pane pane = new Pane();

        //设置圆的中心坐标，并将其与pane动态绑定起来
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(radius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        //设置扇形的中心坐标，并将其与pane动态绑定起来
        arc1.centerXProperty().bind(pane.widthProperty().divide(2));
        arc1.centerYProperty().bind(pane.heightProperty().divide(2));
        arc1.setRadiusX(radius);
        arc1.setRadiusY(radius);
        arc1.setStartAngle(60);
        arc1.setLength(30);
        arc1.setType(ArcType.ROUND);
        arc1.setFill(color);
        arc2.centerXProperty().bind(pane.widthProperty().divide(2));
        arc2.centerYProperty().bind(pane.heightProperty().divide(2));
        arc2.setRadiusX(radius);
        arc2.setRadiusY(radius);
        arc2.setStartAngle(150);
        arc2.setLength(30);
        arc2.setType(ArcType.ROUND);
        arc2.setFill(color);
        arc3.centerXProperty().bind(pane.widthProperty().divide(2));
        arc3.centerYProperty().bind(pane.heightProperty().divide(2));
        arc3.setRadiusX(radius);
        arc3.setRadiusY(radius);
        arc3.setStartAngle(240);
        arc3.setLength(30);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(color);
        arc4.centerXProperty().bind(pane.widthProperty().divide(2));
        arc4.centerYProperty().bind(pane.heightProperty().divide(2));
        arc4.setRadiusX(radius);
        arc4.setRadiusY(radius);
        arc4.setStartAngle(330);
        arc4.setLength(30);
        arc4.setType(ArcType.ROUND);
        arc4.setFill(color);

        //将圆与扇形放在pane上，并生成新的舞台
        pane.getChildren().addAll(circle,arc1,arc2,arc3,arc4);
        Scene scene = new Scene(pane,500,500);
        stage.setScene(scene);
        stage.show();
    }
}