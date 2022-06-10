package com.techelevator;

public class FruitTree {
    private String typeOfFruit;
    private int piecesOfFruitLeft;

    public FruitTree(String typeOfFruit, int startingpiecesOfFruitLeft) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingpiecesOfFruitLeft;
    }

    // Setters and getters
    public String getTypeOfFruit() {
        return typeOfFruit;
    }
    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }
    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            // Simplified version   piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
            return true;
        } else {
            return false;
        }
    }

}