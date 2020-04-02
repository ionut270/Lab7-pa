package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    List<Token> tokens = new ArrayList<Token>();
    Board(int n){
        tokens = IntStream.range(1, n).mapToObj(Token::new).collect(Collectors.toList());
    }
    public synchronized Token getToken(int number) throws IllegalArgumentException, IndexOutOfBoundsException {

        //empty board ...
        if (tokens.isEmpty())
            throw new IndexOutOfBoundsException("The board is empty");

        for (Token t : tokens){
            if (t.getNumber() == number)
            {
                tokens.remove(t);
                return t;
            }
        }
        throw new IllegalArgumentException("Number is not in the array, try another token");
        //System.out.println("Token not in array !, try another one !");
        //return new Token(0); // returns blank token
    }
}
