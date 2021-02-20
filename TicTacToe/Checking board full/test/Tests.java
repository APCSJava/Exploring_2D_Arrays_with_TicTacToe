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
                board[r][c] = -1;
            }
        }
        Assert.assertTrue("The board should be detected as full if no zeroes remain.",
                t.checkBoardFull());
    }

    @Test
    public void testSingleZeroNotFull() {
        TicTacToe t = new TicTacToe();
        int[][] board = t.getBoard();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = -1;
            }
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = 0;
                String feedback = String.format("With a zero at [%d][%d] the board should not be full", r, c);
                Assert.assertFalse(feedback, t.checkBoardFull());
                board[r][c] = -1;
            }
        }
    }
}