package game;

import model.BoardState;

import java.util.Random;

public class GameHelper {

    public static void printBoard(BoardState boardState)
    {
        System.out.println(" — — — — — — -");
        for (int i = 0; i < boardState.getBoardDimension(); i++)
        {
            System.out.print("|");
            for (int j = 0; j < boardState.getBoardDimension(); j++)
            {
                System.out.print(boardState.getBoard()[i][j] + " | ");
            }
            System.out.println();
            System.out.println(" — — — — — — -");
        }
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}
