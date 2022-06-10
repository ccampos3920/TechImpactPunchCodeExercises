package com.techelevator;

public class Elevator {
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;
    int numberOfLevels;

    public Elevator(int numberOfLevels) {
        this.numberOfLevels = numberOfLevels;
    }


    void openDoor() {
        doorOpen = true;
    }

    void closeDoor() {
        doorOpen = false;
    }

    int getCurrentFloor(){
        return currentFloor;
    }

    void goUp(int desiredFloor) {
        while (!doorOpen && desiredFloor <= numberOfFloors) {
            desiredFloor++;
        }

    }

    void goDown(int desiredFloor) {
        while (!doorOpen && desiredFloor <= numberOfFloors) {
            desiredFloor--;

        }


    }
}
