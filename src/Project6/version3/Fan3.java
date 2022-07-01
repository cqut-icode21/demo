package Project6.version3;

import javafx.animation.Animation;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Fan3 extends Application {
    //一些private型的数据域
    private Circle circle = new Circle(300,300,150);
    private Arc arc1 = new Arc(300,300,135,135,0,30);
    private Arc arc2 = new Arc(300,300,135,135,90,30);
    private Arc arc3 = new Arc(300,300,135,135,180,30);
    private Arc arc4 = new Arc(300,300,135,135,270,30);

    @Override
    public void start(Stage stage) {
        //设置圆的颜色
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        //设置扇形的颜色
        arc1.setFill(Color.RED);
        arc1.setType(ArcType.ROUND);
        arc2.setFill(Color.RED);
        arc2.setType(ArcType.ROUND);
        arc3.setFill(Color.RED);
        arc3.setType(ArcType.ROUND);
        arc4.setFill(Color.RED);
        arc4.setType(ArcType.ROUND);

        //创建Button
        Button btStart = new Button("Start");
        btStart.setPrefWidth(200);
        btStart.setPrefHeight(100);
        Button btStop = new Button("Stop");
        btStop.setPrefWidth(200);
        btStop.setPrefHeight(100);
        Button btReverse = new Button("Reverse");
        btReverse.setPrefWidth(200);
        btReverse.setPrefHeight(100);

        //将创建的Button放在hbox上，使其能够整齐排成一横列
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(30);
        hBox.getChildren().addAll(btStart,btStop,btReverse);

        //创建风扇逆时针转动的动画
        EventHandler<ActionEvent> eventHandler1 = e -> {
            arc1.setStartAngle(arc1.getStartAngle() + 1);
            arc2.setStartAngle(arc2.getStartAngle() + 1);
            arc3.setStartAngle(arc3.getStartAngle() + 1);
            arc4.setStartAngle(arc4.getStartAngle() + 1);
        };

        //创建风扇顺时针转动的动画
        EventHandler<ActionEvent> eventHandler2 = e -> {
            arc1.setStartAngle(arc1.getStartAngle() - 1);
            arc2.setStartAngle(arc2.getStartAngle() - 1);
            arc3.setStartAngle(arc3.getStartAngle() - 1);
            arc4.setStartAngle(arc4.getStartAngle() - 1);
        };

        //生成动画
        Timeline animation1 = new Timeline(new KeyFrame(Duration.millis(100),eventHandler1));
        animation1.setCycleCount(Animation.INDEFINITE);
        Timeline animation2 = new Timeline(new KeyFrame(Duration.millis(100),eventHandler2));
        animation2.setCycleCount(Animation.INDEFINITE);

        //创建ScrollBar，并将ScrollBar的数值与动画的速度绑定在一起
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setPrefHeight(30);
        scrollBar.setVisibleAmount(10);
        scrollBar.valueProperty().addListener(ov -> animation1.setRate(scrollBar.getValue()));
        scrollBar.valueProperty().addListener(ov -> animation2.setRate(scrollBar.getValue()));

        //创建单击Button时的指令
        btStart.setOnAction(actionEvent -> {
            animation2.stop();
            animation1.play();
        });

        btStop.setOnAction(actionEvent -> {
            animation1.stop();
            animation2.stop();
        });

        btReverse.setOnAction(actionEvent -> {
            animation1.stop();
            animation2.play();
        });

        //创建BorderPane，把按钮放在顶部，滑动条在底部
        BorderPane borderPane = new BorderPane();
        borderPane.getChildren().addAll(circle,arc1,arc2,arc3,arc4);
        borderPane.setTop(hBox);
        borderPane.setBottom(scrollBar);
        Scene scene = new Scene(borderPane,600,600);
        stage.setScene(scene);
        stage.show();
    }
}
