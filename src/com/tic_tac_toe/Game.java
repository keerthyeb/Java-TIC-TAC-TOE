package com.tic_tac_toe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private List<List> winningCombinations;
    private List<Player> players;
    private Integer currentPlayerIndex;
    private Board board;
    private String winner;

    public Game() {
        board = new Board();
        winningCombinations  = new ArrayList<>(8);
        players  = new ArrayList<>();
        currentPlayerIndex  = 0;
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

    public void addPlayer(String playername, String symbol) {
        Player player = new Player(playername, symbol);
        players.add(player);
    }

    public void addMove(String playerName, Integer position) {
        Player player = getPlayer(playerName);
        player.addMove(position);
        updateboard(position-1,player.getSymbol());
    }

    public Player getPlayer(String playerName) {
        for (Player player : players)
            if (player.getName().equals(playerName)) return player;
        return null;
    }

    public String getCurrentPlayer(){
        String currentPlayer = players.get(currentPlayerIndex).getName();
        currentPlayerIndex = Math.abs(currentPlayerIndex - 1);
        return  currentPlayer;
    }

    public boolean hasWon(String playerName){
        Player player = getPlayer(playerName);
        List<Integer> currentPlayerMoves = player.getMoves();
        boolean hasWon = winningCombinations.stream().anyMatch(combination-> combination.stream().allMatch(move ->currentPlayerMoves.contains(move)));
        if(hasWon){
            this.winner = playerName;
            return true;
        }
        return false;
    }

    private void updateboard(Integer position, String symbol){
        board.replaceSymbol(position,symbol);
    }

    public void printBoard(){
        board.printBoard();
    }

    public String getWinner() {
        return winner;
    }
}
