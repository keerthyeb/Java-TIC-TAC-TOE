package com.tic_tac_toe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        System.out.println("TIC-TAC-TOE\n");
        System.out.println("Enter the 1st player name");
        String player1 = scanner.nextLine();
        game.addPlayer(player1, "X");
        System.out.println("Enter the 2nd player name");
        String player2 = scanner.nextLine();
        game.addPlayer(player2, "O");
        Integer numberOfTurn = 0;
        String currentPlayer = game.getCurrentPlayer();

        boolean hasWon = game.hasWon(player1);
        while (!hasWon) {
            game.printBoard();
            numberOfTurn++;
            System.out.println(currentPlayer + "'s turn \n" + "Enter the position to play");
            Integer move = scanner.nextInt();
            boolean isValidMove = game.addMove(currentPlayer, move);
            if (!isValidMove) {
                System.out.println("Invalid Move try again\n");
                continue;
            }
            currentPlayer = game.getCurrentPlayer();
            hasWon = game.hasWon(currentPlayer);
            if (numberOfTurn == 9 && !hasWon) break;
        }
        if (hasWon) {
            game.printBoard();
            System.out.println(game.getWinner() + "has won the game");
            System.exit(0);
        }
        System.out.println("Game come to draw");


    }
}
