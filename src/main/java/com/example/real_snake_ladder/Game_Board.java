package com.example.real_snake_ladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Game_Board {

     public Game_Board()
     {
         PopulateCoordinates();
         setSnakeLadderPosition();
     }
    public int getXvalue(int CurrentpiecePosition)
    {
           return  Coordinates.get(CurrentpiecePosition).getKey();
    }
    public int getYvalue(int CurrentpiecePosition)
    {
        return  Coordinates.get(CurrentpiecePosition).getValue();
    }
// how to resize the circle
    // label not working
    // start button has no funcationalities;
    static int tilesize = 40;
    static int width = 10;
    static int height = 10;
    static ArrayList<Pair<Integer,Integer>> Coordinates ;
    static ArrayList<Integer> snakeLadderPosition;
    public int playerPositionAtsnakeOrladder(int piecePosition)
    {
        if(piecePosition!= snakeLadderPosition.get(piecePosition))
        {
            return snakeLadderPosition.get(piecePosition);
        }
        return -1;
    }
    private void setSnakeLadderPosition()
    {
        snakeLadderPosition = new ArrayList<>();
        for (int i = 0 ; i < 101 ; i++)
        {
            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.set(1,38);
        snakeLadderPosition.set(4,14);
        snakeLadderPosition.set(9,31);
        snakeLadderPosition.set(17,7);
        snakeLadderPosition.set(21,42);
        snakeLadderPosition.set(28,84);
        snakeLadderPosition.set(51,67);
        snakeLadderPosition.set(54,34);
        snakeLadderPosition.set(62,19);
        snakeLadderPosition.set(64,60);
        snakeLadderPosition.set(71,91);
        snakeLadderPosition.set(80,100);
        snakeLadderPosition.set(93,73);
        snakeLadderPosition.set(95,75);
        snakeLadderPosition.set(98,79);


    }
    private static void PopulateCoordinates(){
        Coordinates  =  new ArrayList<>();
        Coordinates.add(new Pair<Integer,Integer>(20,420)); // doubt
        int x =0, y=0;
        for (int i = height-1 ; i>=0 ; i--)
        {
            for(int j = width-1 ; j>=0 ;j--)
            {
                if( i%2 != 0 )
                {
                x = tilesize*width - (tilesize/2 + j*tilesize);}
                else{
                    x = tilesize/2 + j*tilesize;
                }
                y = tilesize/2 + i*tilesize;
                Coordinates.add(new Pair<Integer,Integer>(x,y));

            }
        }
        for(int i = 0 ; i< Coordinates.size() ; i++)
        {
            System.out.println(i + "x: "+ Coordinates.get(i).getKey()+ "y: "+ Coordinates.get(i).getValue());
        }
    }


}
