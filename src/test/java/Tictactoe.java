import game.GameHelper;
import game.TicTacToe;
import model.BoardState;
import org.junit.Assert;
import org.junit.Test;

public class Tictactoe {

    @Test
    public void  testInitializeBoard(){
       TicTacToe ticTacToe =new TicTacToe(5,'a','b');
       Assert.assertTrue(ticTacToe.getBoardState().getCurrentPlayer() == ticTacToe.getBoardState().getFirstPlayer());
       Assert.assertTrue(ticTacToe.getBoardState().getBoard()[0][0]=='-');
    }

    @Test
    public void testIsWinningForRow(){
        char[][]winningBoard= getRowWiningBoard();
        TicTacToe ticTacToe =new TicTacToe(3,'x','*');
        ticTacToe.getBoardState().setBoard(winningBoard);
        boolean winner = ticTacToe.isWinner();
        Assert.assertTrue(winner);

    }

    @Test
    public void testIsLosingRow(){
        char [][] board = new char[3][3];
        board[0][0]='x';
        board[0][1]='x';
        board[0][2]='u';
        board[1][0]='-';
        board[1][1]='c';
        board[1][2]='c';
        board[2][0]='-';
        board[2][1]='c';
        board[2][2]='-';
        TicTacToe ticTacToe =new TicTacToe(3,'x','*');
        ticTacToe.getBoardState().setBoard(board);
        boolean winner = ticTacToe.isWinner();
        Assert.assertFalse(winner);
    }

    @Test
    public void testIsWinningColumn(){
        char [][] board = new char[3][3];
        board[0][0]='x';
        board[0][1]='x';
        board[0][2]='u';
        board[1][0]='x';
        board[1][1]='c';
        board[1][2]='c';
        board[2][0]='x';
        board[2][1]='c';
        board[2][2]='-';
        TicTacToe ticTacToe =new TicTacToe(3,'x','*');
        ticTacToe.getBoardState().setBoard(board);
        boolean winner = ticTacToe.isWinner();
        Assert.assertTrue(winner);

    }

    @Test
    public void testIsWinningDiagonal(){
        char [][] board = new char[3][3];
        board[0][0]='x';
        board[0][1]='-';
        board[0][2]='u';
        board[1][0]='-';
        board[1][1]='x';
        board[1][2]='c';
        board[2][0]='-';
        board[2][1]='c';
        board[2][2]='x';
        TicTacToe ticTacToe =new TicTacToe(3,'x','*');
        ticTacToe.getBoardState().setBoard(board);
        boolean winner = ticTacToe.isWinner();
        Assert.assertTrue(winner);

    }

    @Test
    public void testIsLoosingDiagonal(){
        char [][] board = new char[3][3];
        board[0][0]='x';
        board[0][1]='-';
        board[0][2]='u';
        board[1][0]='-';
        board[1][1]='-';
        board[1][2]='c';
        board[2][0]='-';
        board[2][1]='c';
        board[2][2]='x';
        TicTacToe ticTacToe =new TicTacToe(3,'x','*');
        ticTacToe.getBoardState().setBoard(board);
        boolean winner = ticTacToe.isWinner();
        Assert.assertFalse(winner);

    }

    @Test
    public void placeSymbolSuccess(){
        char [][] board = new char[3][3];
        board[0][0]='x';
        board[0][1]='-';
        board[0][2]='u';
        board[1][0]='-';
        board[1][1]='-';
        board[1][2]='c';
        board[2][0]='-';
        board[2][1]='c';
        board[2][2]='x';
        TicTacToe ticTacToe =new TicTacToe(3,'x','*');
        ticTacToe.getBoardState().setBoard(board);
        boolean isMarked=ticTacToe.placeMark(0,1);
        Assert.assertTrue(isMarked);

    }

    @Test
    public void placeSymbolOccupied(){
        char [][] board = new char[3][3];
        board[0][0]='x';
        board[0][1]='x';
        board[0][2]='u';
        board[1][0]='-';
        board[1][1]='-';
        board[1][2]='c';
        board[2][0]='-';
        board[2][1]='c';
        board[2][2]='x';
        TicTacToe ticTacToe =new TicTacToe(3,'x','*');
        ticTacToe.getBoardState().setBoard(board);
        boolean isMarked=ticTacToe.placeMark(0,1);
        Assert.assertFalse(isMarked);

    }

    @Test
    public void checkSuccessBoardFull(){
        char [][] board = new char[3][3];
        board[0][0]='x';
        board[0][1]='x';
        board[0][2]='u';
        board[1][0]='x';
        board[1][1]='x';
        board[1][2]='c';
        board[2][0]='x';
        board[2][1]='c';
        board[2][2]='x';
        TicTacToe ticTacToe =new TicTacToe(3,'x','*');
        ticTacToe.getBoardState().setBoard(board);
        boolean full=ticTacToe.boardFull();
        Assert.assertTrue(full);

    }

    @Test
    public void checkSuccessBoardNotFull(){
        char [][] board = new char[3][3];
        board[0][0]='x';
        board[0][1]='x';
        board[0][2]='u';
        board[1][0]='-';
        board[1][1]='x';
        board[1][2]='c';
        board[2][0]='x';
        board[2][1]='c';
        board[2][2]='x';
        TicTacToe ticTacToe =new TicTacToe(3,'x','*');
        ticTacToe.getBoardState().setBoard(board);
        boolean full=ticTacToe.boardFull();
        Assert.assertFalse(full);

    }

    @Test
    public void checkComputerTurn(){
        TicTacToe ticTacToe =new TicTacToe(3,'x','*');
        ticTacToe.getBoardState().changePlayer();
        ticTacToe.getBoardState().changePlayer();

        boolean isComputer= ticTacToe.isComputerTurn();
        Assert.assertTrue(isComputer);
    }
    private char[][] getRowWiningBoard() {

        char [][] board = new char[3][3];
        board[0][0]='x';
        board[0][1]='x';
        board[0][2]='x';
        board[1][0]='-';
        board[1][1]='c';
        board[1][2]='c';
        board[2][0]='-';
        board[2][1]='c';
        board[2][2]='-';
        return board;
    }

}
