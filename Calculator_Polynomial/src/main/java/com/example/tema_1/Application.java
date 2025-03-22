package com.example.tema_1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 510, 390);
        stage.setTitle("Polynomial Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {

        launch();
    }
}