package com.techelevator;

public class SquareWall extends RectangleWall{
    private String name = "TEST";
    private String color;
    private int sideLength;
    
    public SquareWall(String name, String color, int sideLength){
        super(name,color);
        this.sideLength = sideLength;
    }

    public int getSideLength(){
        return sideLength;
    }

    public String toString(){
        return name+" ("+sideLength+"x"+sideLength+") square";
    }


}