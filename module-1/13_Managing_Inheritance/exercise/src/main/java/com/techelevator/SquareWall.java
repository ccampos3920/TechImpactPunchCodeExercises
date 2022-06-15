package com.techelevator;

public class SquareWall extends RectangleWall{
    private String name = "TEST";
    private String color;
    private int sideLength = 3;

    public SquareWall(String name, String color, int sideLength){
        super(name,color, sideLength, sideLength);
    }

    
    public String toString(){
        return name+" ("+sideLength+"x"+sideLength+") square";
    }


}
