package com.tic_tac_toe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<String> board;

    public Board() {
        board = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            board.add(" ");
        }
    }

    public boolean replaceSymbol(int position, String symbol) {
        try {
            if (!board.get(position).equals(" ")) return false;
            board.set(position, symbol);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public List<String> getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.println("TIC-TAC-TOE");
        System.out.println(board.get(0) + " | " + board.get(1) + " | " + board.get(2));
        System.out.println(board.get(3) + " | " + board.get(4) + " | " + board.get(5));
        System.out.println(board.get(6) + " | " + board.get(7) + " | " + board.get(8) + "\n");
    }
}
