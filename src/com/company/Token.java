package com.company;

public class Token {
    int number = 0; // a number from 1 to m, 0 for blank
    public Token(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
