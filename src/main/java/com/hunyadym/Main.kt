package com.hunyadym;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
            initbal(new Stage());
            initjobb(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void initbal(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("bal.fxml"));
        Scene scene = new Scene(root, 200, 100);
        scene.setFill(null);
        primaryStage.setScene(scene);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setY(0);
        primaryStage.setX(0);
        primaryStage.show();
    }

    private void initjobb(Stage primaryStage) throws IOException {

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        Parent root = FXMLLoader.load(getClass().getResource("jobb.fxml"));
        Scene scene = new Scene(root, 200, 100);
        scene.setFill(null);
        primaryStage.setScene(scene);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setX(primaryScreenBounds.getMaxX() - scene.getWidth());
        primaryStage.setY(0);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
