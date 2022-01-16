package com.example.snake_and_ladder;

public class snakesposition {
    public int[] snakespositionxaxis() {
        int[] snakesxaxis1 = {420, 0, 140, 420, 350, 280, 560, 70};
        return snakesxaxis1;
    }
    public int[] snakespositionyaxis() {
        int[] snakesyaxis = {-120, -180, -240, -300, -360, -420, -480, -540};
        return snakesyaxis;
    }

    public int[] snakepositiondestinationxaxis(){
        int[] snakesdestinationxaxis = {280, 140, 140, 630, 0, 140, 490, 0};
        return snakesdestinationxaxis;
    }
    public int[] snakepositiondestinationyaxis(){
        int[] snakesdestinationyaxis = {0, 0, -60, -180, -240, -300, -300, -240};
        return snakesdestinationyaxis;
    }
}
