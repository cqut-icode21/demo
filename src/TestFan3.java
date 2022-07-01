
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TestFan3 extends Application {

    Circle circle = new Circle();
    //随机生成圆半径50-150
    double radius = 50 * (Math.random() * 2 + 1);
    //创建randomColor方法随机产生5种颜色
    Color color = randomColor();

    public static Color randomColor() {
        int n = (int) (Math.random() * 5) + 1;
        switch (n) {
            case 1:
                return Color.RED;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.GREEN;
            case 5:
                return Color.ORANGE;
            default:
                return null;
        }
    }

    @Override
    public void start(Stage stage) {

        //创建4个扇形对象，分别传入坐标XY,半径XY,起始角度和跨度
        Arc arc1 = new Arc(circle.getCenterX(), circle.getCenterY(), radius - 10, radius - 10, 0, 45);
        Arc arc2 = new Arc(circle.getCenterX(), circle.getCenterY(), radius - 10, radius - 10, 90, 45);
        Arc arc3 = new Arc(circle.getCenterX(), circle.getCenterY(), radius - 10, radius - 10, 180, 45);
        Arc arc4 = new Arc(circle.getCenterX(), circle.getCenterY(), radius - 10, radius - 10, 270, 45);

        //设置圆，并将圆的中心坐标与pane动态绑定起来
        Pane pane = new Pane();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(radius);//将随机生成的半径设为圆半径
        circle.setStroke(Color.BLACK);//黑色描边
        circle.setFill(Color.WHITE);//白色填充

        //设置4个扇形，并将它们的的中心坐标与pane动态绑定起来
        bind(arc1, arc2, pane);

        bind(arc3, arc4, pane);

        //创建Button
        Button btStart = new Button("启动");
        btStart.setPrefWidth(50);//设置btStart的宽度
        btStart.setPrefHeight(50);//设置btStart的高度
        Button btStop = new Button("停止");
        btStop.setPrefWidth(50);//设置btStop的宽度
        btStop.setPrefHeight(50);//设置btStop的高度
        Button btReverse = new Button("反转");
        btReverse.setPrefWidth(50);//设置btReverse的宽度
        btReverse.setPrefHeight(50);//设置btReverse的高度

        //将创建的Button放在hBox上，使其能够整齐排成一横列
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);//对齐方式为居中
        hBox.setSpacing(30);//结点垂直间距为30
        hBox.getChildren().addAll(btStart, btStop, btReverse);//将结点加到水平面板中

        //通过改变其起始角度，创建风扇顺时针转动的动画
        EventHandler<ActionEvent> eventHandler1 = e -> {
            arc1.setStartAngle(arc1.getStartAngle() - 1);
            arc2.setStartAngle(arc2.getStartAngle() - 1);
            arc3.setStartAngle(arc3.getStartAngle() - 1);
            arc4.setStartAngle(arc4.getStartAngle() - 1);
        };

        //通过改变其起始角度，创建风扇逆时针转动的动画
        EventHandler<ActionEvent> eventHandler2 = e -> {
            arc1.setStartAngle(arc1.getStartAngle() + 1);
            arc2.setStartAngle(arc2.getStartAngle() + 1);
            arc3.setStartAngle(arc3.getStartAngle() + 1);
            arc4.setStartAngle(arc4.getStartAngle() + 1);
        };

        //生成动画
        Timeline animation1 = new Timeline(new KeyFrame(Duration.millis(100), eventHandler1));//每100毫秒执行一次动画
        animation1.setCycleCount(Timeline.INDEFINITE);//无限循环
        Timeline animation2 = new Timeline(new KeyFrame(Duration.millis(100), eventHandler2));
        animation2.setCycleCount(Timeline.INDEFINITE);//无限循环

        //创建ScrollBar，并将ScrollBar的数值与动画的速度绑定在一起
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setPrefHeight(30);//设置滚动条的高度
        scrollBar.setPrefWidth(15);//滚动条的宽度
        scrollBar.valueProperty().addListener(ov -> animation1.setRate(scrollBar.getValue()));
        scrollBar.valueProperty().addListener(ov -> animation2.setRate(scrollBar.getValue()));

        //单击Button时执行的指令
        btStart.setOnAction(e -> {
            animation1.play();
            animation2.stop();
        });

        btStop.setOnAction(e -> {
            animation1.stop();
            animation2.stop();
        });

        btReverse.setOnAction(e -> {
            animation1.stop();
            animation2.play();
        });

        //创建BorderPane，把按钮放在顶部，滑动条在底部
        BorderPane borderPane = new BorderPane();
        borderPane.getChildren().addAll(circle, arc1, arc2, arc3, arc4);
        borderPane.setTop(hBox);//将hBOx放在borderPane的顶部
        borderPane.setCenter(pane);//将pane放在borderPane的中央
        borderPane.setBottom(scrollBar);//将scrollBar放在borderPane的底部
        Scene scene = new Scene(borderPane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    private void bind(Arc arc1, Arc arc2, Pane pane) {
        arc1.centerXProperty().bind(pane.widthProperty().divide(2));
        arc1.centerYProperty().bind(pane.heightProperty().divide(2));
        arc1.setType(ArcType.ROUND);//弧的闭合类型为ROUND
        arc1.setFill(color);//将随机生成的颜色设为填充色

        arc2.centerXProperty().bind(pane.widthProperty().divide(2));
        arc2.centerYProperty().bind(pane.heightProperty().divide(2));
        arc2.setType(ArcType.ROUND);//弧的闭合类型为ROUND
        arc2.setFill(color);//将随机生成的颜色设为填充色
    }
}
