package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] players = new String[] {"Andrei", "Maria", "George", "Bogdan","Ionut"};
        Game g = new Game(10, 6, Arrays.asList(players));
        g.run();
    }
}
