package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
     List<Player> players;
     List<Thread> threads;
     Board board;

    int n; // tokens count
    int i;

    public Game(int n, int i, List<String> names) {
        board = new Board(n);
        players = names.stream().map(name -> new Player(name, board)).collect(Collectors.toList());
        this.n = n;
        this.i = i;
    }
    public void run(){
        threads = players.stream().map(Thread::new).collect(Collectors.toList());
        for (Thread t : threads){
            t.start();
        }
        boolean gameOver = false;

        for (Thread t : threads) {
            try {
                if (gameOver)
                    t.interrupt();
                else
                    t.join();
            }
            catch (InterruptedException ex){
                System.out.println("Exception thrown. Game over !");
                gameOver = true;
            }
        }

        System.out.println("Game completed. Results:");
        for(Player p : players){
            int result = p.longestRun();
            if (result == i)
                System.out.println("Player " + p.getName() + " has won");
            else
                System.out.println("Player " + p.getName() + " has " + result + " score");
        }
    }
}
