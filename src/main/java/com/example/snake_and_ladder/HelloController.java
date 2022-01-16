package com.example.snake_and_ladder;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;


public class HelloController extends HelloApplication {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Button Botbutton;

    @FXML
    public void onHelloButtonClick(ActionEvent event) throws IOException {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene1.fxml")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        assert root != null;
        scene = new Scene(root);
        stage.setWidth(930);
        stage.setHeight(710);
        stage.setScene(scene);
        stage.show();
    }

    public void onBotButtonClick(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene1.fxml")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        assert root != null;
        scene = new Scene(root);
        stage.setWidth(930);
        stage.setHeight(710);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void onExitButtonClick(ActionEvent event) {
        System.exit(0);
    }


    public void onCredisButtonClick(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("credits.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
            }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        assert root != null;
        scene = new Scene(root);
        stage.setWidth(430);
        stage.setHeight(750);
        stage.setScene(scene);
        stage.show();
    }

}