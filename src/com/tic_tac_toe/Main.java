package com.tic_tac_toe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("TIC-TAC-TOE\n");

        System.out.println("Enter the 1st player name");
        String playerName = scanner.nextLine();
        Player player1 = new Player(playerName, "X");
        game.addPlayer(player1);

        System.out.println("Enter the 2nd player name");
        playerName = scanner.nextLine();
        Player player2 = new Player(playerName, "O");
        game.addPlayer(player2);

        Player currentPlayer = game.getCurrentPlayer();
        Integer move;

        boolean isFinished;
        while (!game.isFinished()) {
            game.printBoard();
            System.out.println(currentPlayer + "'s turn \n" + "Enter the position to play");

            while (!scanner.hasNextInt()) {
                printInvalidMove();
                scanner.nextLine();
            }

            move = scanner.nextInt();
            if (!game.isValidMove(currentPlayer, move)) {
                printInvalidMove();
                continue;
            }

            game.makeMove(currentPlayer, move);
            isFinished = game.isFinished();
            if (isFinished) printResult(game);
            currentPlayer = game.getCurrentPlayer();
        }

    }

    public static void printResult(Game game) {
        game.printBoard();
        Player player = game.getWinner();
        if (player != null) {
            System.out.println(game.getWinner() + " has won the game");
            System.exit(0);
        }
        System.out.println("Game came to draw");
    }

    public static void printInvalidMove() {
        System.out.println("Invalid Move try again\n");

    }
}
