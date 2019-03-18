package com.tic_tac_toe;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String symbol;
    private List<Integer> moves;

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
        moves = new ArrayList<>();
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addMove(Integer position) {
        moves.add(position);
    }

    public boolean hasWon(List<List> winningCombinations) {
        return winningCombinations.stream().anyMatch(combination ->moves.containsAll(combination));
    }
}
