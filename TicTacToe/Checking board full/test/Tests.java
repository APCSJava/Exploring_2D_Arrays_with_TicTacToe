import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void testDefaultBoardNotFull() {
        TicTacToe t = new TicTacToe();
        int[][] board = t.getBoard();
        Assert.assertFalse("Default board should not be full", t.checkBoardFull());
    }

    @Test
    public void testSingleSpotNotFull() {
        TicTacToe t = new TicTacToe();
        int[][] board = t.getBoard();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = -1;
                Assert.assertFalse("Filling a single space should not be detected as full",
                        t.checkBoardFull());
                board[r][c] = 0;
            }
        }
    }

    @Test
    public void testNoZeroesIsFull() {
        TicTacToe t = new TicTacToe();
        int[][] board = t.getBoard();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = Math.random()>0.5 ? 1 : 2;
            }
        }
        Assert.assertTrue(t.toString()+"\nThe board should be detected as full if no zeroes remain.",
                t.checkBoardFull());
    }

    @Test
    public void testSingleZeroNotFull() {
        // fill the board with 1s and 2s
        TicTacToe t = new TicTacToe();
        int[][] board = t.getBoard();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = Math.random()>0.5 ? 1 : 2;
            }
        }
        // replace each element singly with zero
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = 0;
                String feedback = String.format(t.toString()+"\nThe board should indicate not full", r, c);
                Assert.assertFalse(feedback, t.checkBoardFull());
                board[r][c] = Math.random()>0.5 ? 1 : 2;
            }
        }
    }
}