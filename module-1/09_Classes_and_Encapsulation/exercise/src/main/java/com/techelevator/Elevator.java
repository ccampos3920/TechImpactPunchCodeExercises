package com.techelevator;

public class Elevator {
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;
    private int numberOfLevels = 10;
    boolean isDoorOpen;

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
        while(!doorOpen && currentFloor<=numberOfFloors && currentFloor<desiredFloor){
            currentFloor+= 1;
        }
        if(desiredFloor == currentFloor){
            openDoor();
        }
    }

    void goDown(int desiredFloor){
        while(!doorOpen && desiredFloor<=numberOfFloors){
            desiredFloor -= 1;
        }

    }




}
