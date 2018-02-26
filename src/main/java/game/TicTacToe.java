package game;

import lombok.Getter;
import model.BoardState;

import java.util.HashSet;
import java.util.Set;

@Getter
public class TicTacToe {
    private BoardState boardState;

    public TicTacToe(int dimension, char player1, char player2) {
        initializeBoard(dimension,player1,player2);
    }

    private void initializeBoard(int dimension, char player1, char player2) {
        this.boardState = new BoardState();
        this.boardState.setBoardDimension(dimension);
        this.boardState.setFirstPlayer(player1);
        this.boardState.setSecondPlayer(player2);
        this.boardState.initializeBoard();
    }

    public boolean isWinner() {
        return (checkRowsColumns(true) || checkRowsColumns(false) || checkDiagonals());
    }

    private boolean checkDiagonals() {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < this.boardState.getBoardDimension(); i++) {
            characters.add(this.boardState.getBoard()[i][i]);
        }
        return characters.size() == 1 && !characters.contains('-');
    }


    private boolean checkRowsColumns(boolean checkRows) {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < this.boardState.getBoardDimension(); i++) {
            for (int j = 0; j < this.boardState.getBoardDimension(); j++) {
                if (checkRows) {
                    characters.add(this.boardState.getBoard()[j][i]);
                } else {
                    characters.add(this.boardState.getBoard()[i][j]);
                }
            }
            if (characters.size() == 1 && !characters.contains('-')) {
                return true;
            }
        }
        return false;
    }

    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < this.boardState.getBoardDimension() && col >= 0 && col < this.boardState.getBoardDimension()) {
            if (this.boardState.getBoard()[row][col] == '-') {
                this.boardState.getBoard()[row][col] = this.boardState.getCurrentPlayer();
                return true;
            }
        }

        return false;
    }

    public boolean boardFull() {
        for (int i = 0; i < this.boardState.getBoardDimension(); i++) {
            for (int j = 0; j < this.boardState.getBoardDimension(); j++) {
                if (this.boardState.getBoard()[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isComputerTurn() {
        return this.boardState.getCurrentPlayer() == this.boardState.getComputer();
    }
}
