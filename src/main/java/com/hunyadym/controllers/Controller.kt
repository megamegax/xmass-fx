package com.hunyadym.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    ImageView image;

    Image izzo1;
    Image izzo2;

    boolean light = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            System.out.println(getClass().getResource("izzo_jobb_1.png").toURI().toString());

            izzo1 = new Image(getClass().getResource("izzo_jobb_1.png").toURI().toString());
            izzo2 = new Image(getClass().getResource("izzo_jobb_2.png").toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {
                    if (light) {
                        image.setImage(izzo1);
                        light = !light;
                    } else {
                        image.setImage(izzo2);
                        light = !light;
                    }
                });
            }
        }).start();
    }
}
