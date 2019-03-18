package com.tic_tac_toe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private List<List> winningCombinations;
    private List<Player> players;
    private Integer currentPlayerIndex;
    private Board board;
    private Player winner;
    private Player currentPlayer;

    public Game() {
        board = new Board();
        winningCombinations = new ArrayList<>(8);
        players = new ArrayList<>();
        currentPlayerIndex = 0;
        board = new Board();
        winner = null;
        winningCombinations.add(Arrays.asList(1, 2, 3));
        winningCombinations.add(Arrays.asList(4, 5, 6));
        winningCombinations.add(Arrays.asList(7, 8, 9));
        winningCombinations.add(Arrays.asList(1, 4, 7));
        winningCombinations.add(Arrays.asList(2, 5, 8));
        winningCombinations.add(Arrays.asList(3, 6, 9));
        winningCombinations.add(Arrays.asList(1, 5, 9));
        winningCombinations.add(Arrays.asList(3, 5, 7));
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean isValidMove(Player player,Integer position){
        return updateboard(position-1,player.getSymbol());
    }

    public void makeMove(Player player, Integer position) {
         player.addMove(position);
    }

    public Player getCurrentPlayer() {
        this.currentPlayer = players.get(currentPlayerIndex);
        currentPlayerIndex = Math.abs(currentPlayerIndex - 1);
        return currentPlayer;
    }

    public boolean isFinished() {
        if (this.currentPlayer.hasWon(winningCombinations)) this.winner = currentPlayer;
        boolean isFinished = this.currentPlayer.hasWon(winningCombinations) || isDraw();
            return isFinished;
    }

    private boolean isDraw() {
        return !(board.getBoard().contains(" "));
    }

    private boolean updateboard(Integer position, String symbol) {
        return board.replaceSymbol(position, symbol);

    }

    public void printBoard() {
        board.printBoard();
    }

    public Player getWinner() {
        return winner;
    }
}
