import game.GameHelper;
import game.TicTacToe;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the dimension of the board:");
        int dimension = scanner.nextInt();


        System.out.println("Please enter symbol for player 1: ");
        char player1 = scanner.next().trim().charAt(0);

        char player2;

        do {
            System.out.println("Please enter symbol for player 2: ");
            player2 = scanner.next().trim().charAt(0);
        }
        while (player1 == player2);


        TicTacToe ticTacToe = new TicTacToe(dimension, player1, player2);

        do {
            System.out.println("Board Layout:");
            GameHelper.printBoard(ticTacToe.getBoardState());
            int row;
            int col;
            do {

                if (ticTacToe.isComputerTurn()) {
                    row = GameHelper.randInt(1, dimension) - 1;
                    col = GameHelper.randInt(1, dimension) - 1;
                } else {
                    System.out.println("Player " + ticTacToe.getBoardState().getCurrentPlayer() + ", Please enter your mark with empty row and column!");
                    row = scanner.nextInt() - 1;
                    col = scanner.nextInt() - 1;
                }

            }
            while (!ticTacToe.placeMark(row, col));
            if (!ticTacToe.isWinner()) {
                ticTacToe.getBoardState().changePlayer();
            }
        }
        while (!ticTacToe.isWinner() && !ticTacToe.boardFull());

        if (ticTacToe.boardFull() && !ticTacToe.isWinner()) {
            System.out.println("The game was a tie!");
        } else {
            System.out.println("Current board layout:");
            GameHelper.printBoard(ticTacToe.getBoardState());
            if (ticTacToe.getBoardState().getCurrentPlayer() == ticTacToe.getBoardState().getComputer()) {
                System.out.println("Computer Wins!");
            } else {
                System.out.println("Player " + Character.toUpperCase(ticTacToe.getBoardState().getCurrentPlayer()) + " Wins!");
            }

        }

    }
}

