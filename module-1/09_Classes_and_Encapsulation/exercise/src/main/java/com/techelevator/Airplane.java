package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int availableFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;
    private int availableCoachSeats;

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }


    public int getAvailableFirstClassSeats() {
        return bookedCoachSeats - totalFirstClassSeats;

    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        return bookedCoachSeats - totalCoachSeats;
    }


    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass) {
            bookedFirstClassSeats += totalNumberOfSeats;
            if (totalNumberOfSeats > getAvailableFirstClassSeats()) {
                return false;
            }
        }
        else {
            bookedCoachSeats += totalNumberOfSeats;
            if (totalNumberOfSeats > getAvailableCoachSeats()) {
                return false;
            }
        }
        return true;
    }
}





