package com.example.snake_and_ladder;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.StandardSocketOptions;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Scene2 extends HelloController {
    @FXML
    public Button cancel;


    @FXML
    private Button roll_button;

    @FXML
    private ImageView victoryplayer1;

    @FXML
    private ImageView board;
    @FXML
    private ImageView diceimage;

    @FXML
    private Button Player1;

    @FXML
    private Button Player2;

    @FXML
    private Label player1label;
    @FXML
    private Label player2label;
    @FXML
    private ImageView player1icon;

    @FXML
    private ImageView player2icon;

    @FXML
    private ImageView victoryplayer2;

    public int poscircl1 = 1;
    public int poscircl2 = 1;

    private Scene scene;

    @FXML
    public void onBackButtonClick(ActionEvent event) throws IOException {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("exitconfirmationn.fxml")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        assert root != null;
        scene = new Scene(root);
        stage.setWidth(930);
        stage.setHeight(660);
        stage.setScene(scene);
        stage.show();
    }



    int count1 = 0;
    public void onPlayer1ButtonClick(ActionEvent actionEvent) {
        try {
            Random random = new Random();
            int dice = random.nextInt(6) + 1;
            player1label.setText(Integer.toString(dice));
            onRolldiceButtonClick(dice);
            if (dice == 6 && count1 == 0) {
                count1++;
                return;
            }else if ( count1  > 0) {
                setPlayer1controller(dice);
            }
            Player1.setDisable(true);
            player2label.setText("Player 2 Turn");

            Player2.setDisable(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    int count2 = 0;
    public void onPlayer2ButtonClick(ActionEvent actionEvent) {
        try {
            Random random = new Random();
            int dice = random.nextInt(6) + 1;
            onRolldiceButtonClick(dice);
            if (dice == 6 && count2 == 0) {
                count2++;
                return;
            }else if ( count2  > 0) {
                setPlayer2controller(dice);
            }
            Player2.setDisable(true);
            player2label.setText("Player 1 Turn");
            Player1.setDisable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onRolldiceButtonClick(int dice) throws Exception {
        Thread thread = new Thread(() -> {
            try {
                Image image = new Image(Objects.requireNonNull(getClass().getClassLoader().getResource("images/dices/dice" + dice + ".png")).toString());
                diceimage.setImage(image);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }


    void setPlayer1controller(int dice) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), player1icon);
//        player1label.setText(Double.toString(player1icon.getTranslateX()));
//        player2label.setText(Double.toString(player1icon.getTranslateY()));
        snakesposition snake = new snakesposition();
        ladderposition ladder = new ladderposition();
        double xaxis = player1icon.getTranslateX();
        double yaxis = player1icon.getTranslateY();
        for (int i = 0; i < dice; i++) {
            if (poscircl1%2 == 1) {
                xaxis = xaxis + 70;
            }
            if (poscircl1%2 == 0) {
                xaxis = xaxis -70;
            }
            if(xaxis > 630){
                yaxis = yaxis - 60;
                xaxis = xaxis - 70;
                poscircl1++;
            }
            if(xaxis < 0){
                yaxis = yaxis - 60;
                xaxis = xaxis + 70;
                poscircl1++;
            }
            if(xaxis == 0 && yaxis == -540){
                player2label.setText("Player 1 won");
                board.setOpacity(0.30);
                victoryplayer1.setVisible(true);
            }
            if(yaxis < -540 ){
                yaxis = yaxis + 60;
                xaxis = xaxis - 70;
                return;
            }
//            translateTransition.setToX(xaxis);
//            translateTransition.setToY(yaxis);
        }
        if (snake.snakespositionxaxis()[0] == xaxis && snake.snakespositionyaxis()[0] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[0];
            yaxis = snake.snakepositiondestinationyaxis()[0];

        }
        if (snake.snakespositionxaxis()[1] == xaxis && snake.snakespositionyaxis()[1] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[1];
            yaxis = snake.snakepositiondestinationyaxis()[1];
            poscircl1++;
        }

        if (snake.snakespositionxaxis()[2] == xaxis && snake.snakespositionyaxis()[2] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[2];
            yaxis = snake.snakepositiondestinationyaxis()[2];
            poscircl1++;
        }
        if (snake.snakespositionxaxis()[3] == xaxis && snake.snakespositionyaxis()[3] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[3];
            yaxis = snake.snakepositiondestinationyaxis()[3];

        }
        if (snake.snakespositionxaxis()[4] == xaxis && snake.snakespositionyaxis()[4] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[4];
            yaxis = snake.snakepositiondestinationyaxis()[4];
            poscircl1++;
        }
        if (snake.snakespositionxaxis()[5] == xaxis && snake.snakespositionyaxis()[5] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[5];
            yaxis = snake.snakepositiondestinationyaxis()[5];
            poscircl1++;
        }
        if (snake.snakespositionxaxis()[6] == xaxis && snake.snakespositionyaxis()[6] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[6];
            yaxis = snake.snakepositiondestinationyaxis()[6];
            poscircl1++;
        }

        if (snake.snakespositionxaxis()[7] == xaxis && snake.snakespositionyaxis()[7] == yaxis) {
            System.out.println(xaxis + " " + yaxis);
            xaxis = snake.snakepositiondestinationxaxis()[7];
            yaxis = snake.snakepositiondestinationyaxis()[7];
            poscircl1++;
        }



        //ladder




        if (ladder.ladderpositionxaxis()[0] == xaxis && ladder.ladderpositionyaxis()[0] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[0];
            yaxis = ladder.ladderpositiondestinationyaxis1()[0];
        }
        if (ladder.ladderpositionxaxis()[1] == xaxis && ladder.ladderpositionyaxis()[1] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[1];
            yaxis = ladder.ladderpositiondestinationyaxis1()[1];
            poscircl1++;
        }
        if (ladder.ladderpositionxaxis()[2] == xaxis && ladder.ladderpositionyaxis()[2] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[2];
            yaxis = ladder.ladderpositiondestinationyaxis1()[2];
            poscircl1++;
        }
        if (ladder.ladderpositionxaxis()[3] == xaxis && ladder.ladderpositionyaxis()[3] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[3];
            yaxis = ladder.ladderpositiondestinationyaxis1()[3];
        }
        if (ladder.ladderpositionxaxis()[4] == xaxis && ladder.ladderpositionyaxis()[4] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[4];
            yaxis = ladder.ladderpositiondestinationyaxis1()[4];
        }
        if (ladder.ladderpositionxaxis()[5] == xaxis && ladder.ladderpositionyaxis()[5] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[5];
            yaxis = ladder.ladderpositiondestinationyaxis1()[5];
        }
        if (ladder.ladderpositionxaxis()[6] == xaxis && ladder.ladderpositionyaxis()[6] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[6];
            yaxis = ladder.ladderpositiondestinationyaxis1()[6];
        }

        translateTransition.setToX(xaxis);
        translateTransition.setToY(yaxis);
        translateTransition.play();

    }

    void setPlayer2controller(int dice) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), player2icon);
//        player1label.setText(Double.toString(player2icon.getTranslateX()));
//        player2label.setText(Double.toString(player2icon.getTranslateY()));
        snakesposition snake = new snakesposition();
        ladderposition ladder = new ladderposition();
        double xaxis = player2icon.getTranslateX();
        double yaxis = player2icon.getTranslateY();
        for (int i = 0; i < dice; i++) {
            if (poscircl2%2 == 1) {
                xaxis = xaxis + 70;
            }
            if (poscircl2%2 == 0) {
                xaxis = xaxis -70;
            }
            if(xaxis > 630){
                yaxis = yaxis - 60;
                xaxis = xaxis - 70;
                poscircl2++;
            }
            if(xaxis < 0){
                yaxis = yaxis - 60;
                xaxis = xaxis + 70;
                poscircl2++;
            }
            if(xaxis == 0 && yaxis == -540){
                player2label.setText("Player 2 won");
                board.setOpacity(0.30);
                victoryplayer2.setVisible(true);
            }
            if(yaxis < -540 ){
                yaxis = yaxis + 60;
                xaxis = xaxis - 70;
                return;
            }
//            translateTransition.setToX(xaxis);
//            translateTransition.setToY(yaxis);
        }
        if (snake.snakespositionxaxis()[0] == xaxis && snake.snakespositionyaxis()[0] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[0];
            yaxis = snake.snakepositiondestinationyaxis()[0];

        }
        if (snake.snakespositionxaxis()[1] == xaxis && snake.snakespositionyaxis()[1] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[1];
            yaxis = snake.snakepositiondestinationyaxis()[1];
            poscircl2++;
        }

        if (snake.snakespositionxaxis()[2] == xaxis && snake.snakespositionyaxis()[2] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[2];
            yaxis = snake.snakepositiondestinationyaxis()[2];
            poscircl2++;
        }
        if (snake.snakespositionxaxis()[3] == xaxis && snake.snakespositionyaxis()[3] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[3];
            yaxis = snake.snakepositiondestinationyaxis()[3];
        }
        if (snake.snakespositionxaxis()[4] == xaxis && snake.snakespositionyaxis()[4] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[4];
            yaxis = snake.snakepositiondestinationyaxis()[4];
            poscircl2++;
        }
        if (snake.snakespositionxaxis()[5] == xaxis && snake.snakespositionyaxis()[5] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[5];
            yaxis = snake.snakepositiondestinationyaxis()[5];
            poscircl2++;
        }
        if (snake.snakespositionxaxis()[6] == xaxis && snake.snakespositionyaxis()[6] == yaxis) {
            xaxis = snake.snakepositiondestinationxaxis()[6];
            yaxis = snake.snakepositiondestinationyaxis()[6];
            poscircl2++;
        }

        if (snake.snakespositionxaxis()[7] == xaxis && snake.snakespositionyaxis()[7] == yaxis) {
            System.out.println(xaxis + " " + yaxis);
            xaxis = snake.snakepositiondestinationxaxis()[7];
            yaxis = snake.snakepositiondestinationyaxis()[7];
            poscircl2++;
        }



        //ladder




        if (ladder.ladderpositionxaxis()[0] == xaxis && ladder.ladderpositionyaxis()[0] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[0];
            yaxis = ladder.ladderpositiondestinationyaxis1()[0];
        }
        if (ladder.ladderpositionxaxis()[1] == xaxis && ladder.ladderpositionyaxis()[1] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[1];
            yaxis = ladder.ladderpositiondestinationyaxis1()[1];
            poscircl2++;
        }
        if (ladder.ladderpositionxaxis()[2] == xaxis && ladder.ladderpositionyaxis()[2] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[2];
            yaxis = ladder.ladderpositiondestinationyaxis1()[2];
            poscircl2++;
        }
        if (ladder.ladderpositionxaxis()[3] == xaxis && ladder.ladderpositionyaxis()[3] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[3];
            yaxis = ladder.ladderpositiondestinationyaxis1()[3];
        }
        if (ladder.ladderpositionxaxis()[4] == xaxis && ladder.ladderpositionyaxis()[4] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[4];
            yaxis = ladder.ladderpositiondestinationyaxis1()[4];
        }
        if (ladder.ladderpositionxaxis()[5] == xaxis && ladder.ladderpositionyaxis()[5] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[5];
            yaxis = ladder.ladderpositiondestinationyaxis1()[5];
        }
        if (ladder.ladderpositionxaxis()[6] == xaxis && ladder.ladderpositionyaxis()[6] == yaxis) {
            xaxis = ladder.ladderpositiondestinationxaxis1()[6];
            yaxis = ladder.ladderpositiondestinationyaxis1()[6];
        }

        translateTransition.setToX(xaxis);
        translateTransition.setToY(yaxis);
        translateTransition.play();
    }

    public void onrollButtonClick(ActionEvent actionEvent) {
        try {
            count1 = 0;
            count2 = 0;
            victoryplayer1.setVisible(false);
            victoryplayer2.setVisible(false);
            board.setOpacity(1);
            board.setOpacity(1);
            poscircl1 = 1;
            poscircl2 = 1;
            player1icon.setTranslateX(0);
            player1icon.setTranslateY(0);
            player2icon.setTranslateX(0);
            player2icon.setTranslateY(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void oncancelButtonClick(ActionEvent actionEvent) {
        Parent root = null;
        try{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene1.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert root != null;
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(930);
        stage.setHeight(710);
        stage.setScene(scene);
        stage.show();
    }

    public void onExit2ButtonClick(ActionEvent actionEvent) {
        Parent root = null;
        try{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert root != null;
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setWidth(582);
        stage.setHeight(795);
        stage.setScene(scene);
        stage.show();
    }
}
