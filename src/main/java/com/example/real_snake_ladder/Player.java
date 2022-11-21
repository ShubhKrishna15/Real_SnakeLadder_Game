package com.example.real_snake_ladder;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private Circle gamePiece;
    int xPosition;
    int yPosition;
    int currentPiecePosition;
    static Game_Board gameBoard= new Game_Board();

    public void movePlayer (int diceValue)
    {
        if(currentPiecePosition <= 100)
        {
            currentPiecePosition += diceValue;
            if(currentPiecePosition<=100){
               translatePlayer();}
            else {
                currentPiecePosition -=diceValue;
            }
        }
    }
    public void restartGame()
    {
        currentPiecePosition = 0;
        translatePlayer();
    }
    public void playerAtSnakeOrladder()
    {
        int newPosition =0;
        if(currentPiecePosition<=100)
        { newPosition= gameBoard.playerPositionAtsnakeOrladder(currentPiecePosition);
            if(newPosition!= -1)
            {
                currentPiecePosition= newPosition;
                translatePlayer();
            }

        }

    }
    private void translatePlayer()
    {
        xPosition = gameBoard.getXvalue(currentPiecePosition);
        yPosition = gameBoard.getYvalue(currentPiecePosition);
        TranslateTransition animate = new TranslateTransition(Duration.millis(1000),this.gamePiece);
        animate.setToX(this.xPosition);
        animate.setToY(this.yPosition);
        animate.setAutoReverse(true);
        animate.play();

//        gamePiece.setTranslateY(yPosition);
//        gamePiece.setTranslateX(xPosition);
    }

    Player (int tilesize , Color pieceColor) {
        currentPiecePosition = 0;
        xPosition = gameBoard.getXvalue(currentPiecePosition);
        yPosition = gameBoard.getYvalue(currentPiecePosition);

        gamePiece = new Circle(tilesize / 2);
        gamePiece.setFill(pieceColor);
        gamePiece.setTranslateX(this.xPosition);
        gamePiece.setTranslateY(this.yPosition);
    }
    public Circle getGamePiece() // doubt
    {
        return this.gamePiece;
    }

}




