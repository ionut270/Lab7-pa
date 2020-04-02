package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    String name = "";
    Board board;
    List< Token > tokens = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List< Token > getTokens() {
        return tokens;
    }

    public void setTokens(List< Token > tokens) {
        this.tokens = tokens;
    }

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    @Override
    public void run() {
        try {
            int i = 1;
            while (true) {
                Token token;
                try { Thread.sleep(5); } catch (InterruptedException ignored) { }
                try { token = board.getToken(i); }
                catch (IllegalArgumentException ex) { continue; } finally { i++; }
                tokens.add(token);
            }

        } catch (IndexOutOfBoundsException ignored) { } //Stop the game somehow
    }
}
