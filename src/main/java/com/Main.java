package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Principal.fxml")));
        primaryStage.setTitle("Cassuz");
        Scene scene =new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.getIcons().add(new Image(String.valueOf(getClass().getResource("/img/cassuz.png"))));
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args);
    }
}
