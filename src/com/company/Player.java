package com.company;

import java.util.ArrayList;
import java.util.Arrays;
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

    int longestAp() //Source:  https://www.geeksforgeeks.org/longest-arithmetic-progression-dp-35/
    {
        if (tokens.size() <= 2)  return tokens.size();
        int m[][] = new int[tokens.size()][tokens.size()];
        int llap = 2;

        for (int i = 0; i < tokens.size(); i++) {
            m[i][tokens.size() - 1] = 2;
        }
        for (int j = tokens.size() - 2; j >= 1; j--)
        {
            // Search for i and k for j
            int i = j -1 , k = j + 1;
            while (i >= 0 && k <= tokens.size() - 1)
            {
                if (tokens.get(i).getNumber() + tokens.get(k).getNumber() < 2*tokens.get(j).getNumber())
                    k++;
                else if (tokens.get(i).getNumber() + tokens.get(k).getNumber() > 2*tokens.get(j).getNumber())
                {
                    m[i][j] = 2;
                    i--;
                } else {
                    m[i][j] = m[j][k] + 1;
                    llap = Math.max(llap, m[i][j]);
                    i--; k++;
                }
            }
            while (i >= 0)
            {
                m[i][j] = 2;
                i--;
            }
        }
        return llap;
    }

    @Override
    public void run() {
        try {
            int i = 1;
            while (true) {
                Token token;
                try { Thread.sleep(1); } catch (InterruptedException ignored) { }
                try { token = board.getToken(i); }
                catch (IllegalArgumentException ex) { continue; } finally { i++; }
                tokens.add(token);
            }

        } catch (IndexOutOfBoundsException ignored) { } //Stop the game somehow
    }
}
