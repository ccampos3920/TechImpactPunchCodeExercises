package com.techelevator;

public class Elevator {
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;
    private int numberOfLevels;

    public Elevator(int numberOfLevels){
        this.numberOfLevels = numberOfLevels;
        currentFloor = 1;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public int getNumberOfFloors(){
        return numberOfFloors;
    }

    public boolean doorOpen(){
        return doorOpen;
    }



    void openDoor(){
        doorOpen = true;
    }

    void closeDoor(){
        doorOpen = false;
    }

    void goUp(int desiredFloor){
        while(!doorOpen && desiredFloor<=numberOfFloors){
            desiredFloor+= 1;
        }
    }

    void goDown(int desiredFloor){
        while(!doorOpen && desiredFloor<=numberOfFloors){
            desiredFloor -= 1;
        }

    }




}
