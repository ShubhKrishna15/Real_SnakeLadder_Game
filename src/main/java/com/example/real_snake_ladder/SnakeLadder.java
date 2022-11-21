package com.example.real_snake_ladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
// gui
public class SnakeLadder extends Application {
    public final int tilesize = 40;
    int height = 10;
    int width = 10;
    int diceValue;
    Player player1;
    Player player2;

    Label randomDiceValue2;
    Label indicator1 ;
    Label indicator2 ;

    boolean gameStart = false , playerOneChance = true , playerTwoChance = false;

    Group tileGroup  = new Group();
    public Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tilesize,height*tilesize+100);
        root.getChildren().addAll(tileGroup);
        for(int y = 0 ; y < height ; y++)
            for(int x =0 ; x< width ; x++)
            {
                Tile tile = new Tile(tilesize,tilesize);
                tile.setTranslateX(x*tilesize);
                tile.setTranslateY(y*tilesize);
                tileGroup.getChildren().addAll(tile);

            }
        player1 = new Player(tilesize-10, Color.DARKTURQUOISE);
        player2 = new Player(tilesize-10,Color.MEDIUMPURPLE);



        randomDiceValue2 = new Label("Dice");
        randomDiceValue2.setTranslateX(180);
        randomDiceValue2.setTranslateY(410);


        
        Button  playeronebutton = new Button("Player one");
        playeronebutton.setTranslateX(20);
        playeronebutton.setTranslateY(450);
        indicator1 = new Label("Click on 'Start game' ");
        indicator1.setTranslateY(480);
        indicator1.setTranslateX(20);



        playeronebutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart==true)
                {
                    if(playerOneChance==true)
                    {
                        getDiceValue();
                        player1.movePlayer(diceValue);
                        player1.playerAtSnakeOrladder();
                        if(player1.currentPiecePosition== player2.currentPiecePosition)
                        {
                            player2.restartGame();
                        }

                        playerOneChance=false;
                        playerTwoChance=true;
                        indicator2.setText("Your chance now!!");
                        indicator1.setText((""));
                        if(player1.currentPiecePosition==100)
                        {
                            indicator1.setText("You Won");
                            playerTwoChance=false;
                            indicator2.setText("");
                            gameStart=false;
                        }

                    }
                }

            }
        });
        Button  StartGameButton = new Button("Start game");
        StartGameButton.setTranslateX(160);
        StartGameButton.setTranslateY(430);
        StartGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStart=true;
                if(playerOneChance==true)
                {
                    indicator1.setText("Your chance now!!");
                    indicator2.setText("");
                }
                else if(playerTwoChance==true){
                    indicator2.setText("Your chance now!!");
                    indicator1.setText("");
                }
                else if(playerOneChance==false)
                {
                    player1.restartGame();
                    player2.restartGame();
                    playerOneChance= true;
                    indicator1.setText("Your chance now!!");
                    indicator2.setText("");

                }
            }
        });
        Button RestartButton = new Button("Restart Game");
        RestartButton.setTranslateX(152);
        RestartButton.setTranslateY(470);
        RestartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                player1.restartGame();
                player2.restartGame();
                gameStart=false;
               // randomDiceValue1.setText("Dice");
                randomDiceValue2.setText("Dice");
                if(playerOneChance){
                    playerTwoChance = true;
                    playerOneChance =false;
                    indicator2.setText("Click on 'Start game' ");
                    indicator1.setText("");
                }

                else if (playerTwoChance) {
                    playerOneChance = true;
                    playerTwoChance= false;
                    indicator1.setText(("Click on 'Start game' "));
                    indicator2.setText("");
                }
                else if(!playerOneChance)
                {

                    playerOneChance= true;
                    indicator1.setText("Click on Start game");
                    indicator2.setText("");

                }
            }
        });
        Button  playertwobutton = new Button("Player two");
        playertwobutton .setTranslateX(300);
        playertwobutton .setTranslateY(450);


        indicator2 = new Label("");
        indicator2.setTranslateY(480);
        indicator2.setTranslateX(270);
        playertwobutton .setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent actionEvent) {
                               if(gameStart)
                               {
                                   if(playerTwoChance)
                                   {
                                       getDiceValue();
                                       player2.movePlayer(diceValue);
                                       player2.playerAtSnakeOrladder();
                                       if(player1.currentPiecePosition== player2.currentPiecePosition)
                                       {
                                           player1.restartGame();
                                       }

                                       playerTwoChance=false;
                                       playerOneChance=true;
                                       indicator1.setText("Your chance now!!");
                                       indicator2.setText((""));
                                       if(player2.currentPiecePosition==100)
                                       {
                                           indicator2.setText("You Won");
                                           playerOneChance=false;
                                           indicator1.setText("");
                                           gameStart=false;
                                       }

                                   }
                               }

                           }
                       });


//        player1 = new Player(tilesize, Color.DARKTURQUOISE);
//        player2 = new Player(tilesize,Color.MEDIUMPURPLE);

        Image img  = new Image("C:\\Users\\Shubh Krishna\\IdeaProjects\\Real_Snake_Ladder\\src\\snake ladder img.jpg");
        ImageView boardImage = new ImageView();
        boardImage.setImage(img);
        boardImage.setFitHeight(tilesize*height);
        boardImage.setFitWidth(tilesize*width);
        tileGroup.getChildren().addAll(indicator1,indicator2,boardImage,playeronebutton,playertwobutton,StartGameButton,player1.getGamePiece(),player2.getGamePiece(),randomDiceValue2,RestartButton);




        return root;



    }
    private void getDiceValue()
    {
        diceValue = (int)(Math.random()*6+1);

        randomDiceValue2.setText(Integer.toString(diceValue));
    }
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Real_Snake_Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}