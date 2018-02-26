package game;

import lombok.Getter;
import model.BoardState;

import java.util.HashSet;
import java.util.Set;

@Getter
public class TicTacToe {
    private BoardState boardState;

    public TicTacToe(int dimension) {
        initializeBoard(dimension);
    }

    private void initializeBoard(int dimension) {
        this.boardState = new BoardState();
        this.boardState.setBoardDimension(dimension);
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
        if (characters.size() == 1 && !characters.contains('-')) {
            return true;
        }
        return false;
    }


    private boolean checkRowsColumns(boolean checkRows) {
        this.boardState.getBoard();
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
        if (row >= 0 && row < this.boardState.getBoardDimension() && row >= 0 && row < this.boardState.getBoardDimension()) {
            if (this.boardState.getBoard()[row][col] == '-') {
                this.boardState.getBoard()[row][col] = this.boardState.getCurrentPLayer();
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


}
