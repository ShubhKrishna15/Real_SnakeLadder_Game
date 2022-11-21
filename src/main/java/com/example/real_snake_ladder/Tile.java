package com.example.real_snake_ladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    public Tile(int width,int height) {
        setWidth(width) ;
        setHeight(height);
        setFill(Color.ROYALBLUE);
        setStroke(Color.BLACK);

    }


}
