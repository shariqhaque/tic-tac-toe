package model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class BoardState {
    private char[][] board;
    private int numberOfPlayers;
    private int boardDimension;
    private char currentPlayer;
    private char firstPlayer;
    private char secondPlayer;
    private char computer='C';



    public void initializeBoard() {
        board = new char[boardDimension][boardDimension];
        for (int i = 0; i < boardDimension; i++) {
            for (int j = 0; j < boardDimension; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void changePlayer() {
        if(currentPlayer == firstPlayer){
            currentPlayer = secondPlayer;
        }

        //currentPlayer = currentPlayer == firstPlayer ? secondPlayer : currentPlayer == secondPlayer ? computer
    }

}
