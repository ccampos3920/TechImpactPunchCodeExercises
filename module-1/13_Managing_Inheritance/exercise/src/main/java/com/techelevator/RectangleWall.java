package com.techelevator;

public class RectangleWall extends Wall{
    private String name = "TEST";
    private String color;
    private int length;
    private int height;

    public RectangleWall(String name, String color, int length, int height){
        super(name, color);
        this.length = length;
        this.height = height;
    }


    public int getLength(){
        return length;
    }
    public int getHeight(){
        return height;
    }

    public int getArea(){
        return length*height;
    }

    public String toString(){
        return name +" ("+length+"x"+height+") rectangle";
    }

}
