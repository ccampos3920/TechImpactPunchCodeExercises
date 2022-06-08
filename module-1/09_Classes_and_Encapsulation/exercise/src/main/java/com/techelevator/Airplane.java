package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats = 0;
    private int BookedCoachedSeats = 0;
    private boolean forFirstClass;
    private int availableCoachSeats;

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats){
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats= totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    public String getPlaneNumber(){
        return planeNumber;
    }

    public int getTotalFirstClassSeats(){
        return totalFirstClassSeats;
    }

    public int getTotalCoachSeats(){
        return totalCoachSeats;
    }

        public int getBookedFirstClassSeats(){
        return bookedFirstClassSeats;
    }

    public int getBookedCoachedSeats(){
        return BookedCoachedSeats;
    }

    public boolean getforFirstClass(){
        return forFirstClass;
    }
    public int getAvailableCoachSeats(){
        return availableCoachSeats;
    }


    public int reserveSeats(boolean forFirstClass, int totalNumberOfSeats){
        if(forFirstClass){
            bookedFirstClassSeats += totalNumberOfSeats;
            return bookedFirstClassSeats;
        }

        else if(!forFirstClass){
            BookedCoachedSeats+= totalNumberOfSeats;
            return BookedCoachedSeats;
        }

        return totalNumberOfSeats;

    }

    }







