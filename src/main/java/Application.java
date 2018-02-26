import game.GameHelper;
import game.TicTacToe;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the dimension of the board:");
        int dimension=scanner.nextInt();
        TicTacToe ticTacToe = new TicTacToe(dimension);

        do {
            System.out.println("Board Layout:");
            GameHelper.printBoard(ticTacToe.getBoardState());
            int row;
            int col;
            do {
                System.out.println("Player " + ticTacToe.getBoardState().getCurrentPLayer() + ", Please enter your mark with empty row and column!");
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;
            }
            while (!ticTacToe.placeMark(row, col));
            ticTacToe.getBoardState().changePlayer();
        }
        while (!ticTacToe.isWinner() && !ticTacToe.boardFull());

        if (ticTacToe.boardFull() && !ticTacToe.isWinner()) {
            System.out.println("The game was a tie!");
        } else {
            System.out.println("Current board layout:");
            GameHelper.printBoard(ticTacToe.getBoardState());
            ticTacToe.getBoardState().changePlayer();
            System.out.println(Character.toUpperCase(ticTacToe.getBoardState().getCurrentPLayer()) + "Wins!");
        }

    }
}

