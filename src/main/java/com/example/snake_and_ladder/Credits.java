package com.example.snake_and_ladder;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Stack;

public class Credits{

    private Object Main;
    private Stage stage;
    private Scene scene;

    public void onback1ButtonClick(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage= (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        assert root != null;
        scene = new Scene(root);
        stage.setWidth(582);
        stage.setHeight(795);
        stage.setScene(scene);
        stage.show();
    }
}
