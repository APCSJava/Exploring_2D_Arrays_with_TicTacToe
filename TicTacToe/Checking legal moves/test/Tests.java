import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void testConstructor() {
        TicTacToe t = new TicTacToe();
        int[][] arr = t.getBoard();
        String s1 = "The board should have 3 rows.";
        String s2 = "The board should have 3 columns";
        assertEquals(s1, 3, arr.length);
        assertEquals(s2, 3, arr[0].length);
    }

    @Test
    public void testDefaultValues() {
        TicTacToe t = new TicTacToe();
        int[][] arr = t.getBoard();
        String feedback = "The array values should be left at the default value of 0";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                assertEquals(feedback, 0, arr[i][j]);
            }
        }
    }

    @Test
    public void testLocationSetCorrectly() {
        TicTacToe t = new TicTacToe();
        int[][] arr = t.getBoard();
        t.place(2, 2, 1);
        String feedback = "The element at row 2, column 1 should be 2";
        assertEquals(feedback, 2, arr[2][1]);
    }

    @Test
    public void testNonLocationsSetCorrectly() {
        TicTacToe t = new TicTacToe();
        int[][] arr = t.getBoard();
        t.place(2, 2, 1);
        String feedback = "Elements other than row 2 column 1 should remain unchanged";
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                if (r == 2 && c == 1) continue;
                assertEquals(feedback, 0, arr[r][c]);
            }
        }
    }

    // test specific to 2a
    @Test
    public void testToStringDefault() {
        TicTacToe t = new TicTacToe();
        t.place(1, 0, 0);
        t.place(2, 1, 1);
        t.place(3, 2, 2);
        String result = t.toString();
        int[][] test = {{1, 0, 0}, {0, 2, 0}, {0, 0, 3}};
        String expected = Arrays.toString(test[0]) + "\n" + Arrays.toString(test[1]) + "\n" + Arrays.toString(test[2]);
        assertEquals("Incorrect string formatting", expected, result);
    }

    @Test
    public void testOutOfBoundsArrayIndicesNotLegalMoves() {
        TicTacToe t = new TicTacToe();
        String feedback = "Array location [%d][%d] is not legal.";
        try {
            t.checkLegalMove(-5, 2);
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.fail(String.format(feedback, -5, 2));
        }
        try {
            t.checkLegalMove(2, -1);
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.fail(String.format(feedback, 2, -1));
        }
        try {
            t.checkLegalMove(3, 2);
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.fail(String.format(feedback, 3, 0));
        }
        try {
            t.checkLegalMove(-5, 2);
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.fail(String.format(feedback, 2, 3));
        }
    }

    @Test
    public void testAvailableUntilClaimed() {
        TicTacToe t = new TicTacToe();
        int[][] arr = t.getBoard();
        String feedTrue = "Accessing unclaimed location [%d][%d] should return true.";
        String feedFalse = "Accessing non-zero value at location [%d][%d] should return false.";
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                feedTrue = t.toString() + "\n" + feedTrue;
                feedFalse = t.toString() + "\n" + feedFalse;
                assertTrue(String.format(feedTrue, r, c), t.checkLegalMove(r, c));
                t.place(Math.random() < 0.5 ? 1 : 2, r, c);
                assertFalse(String.format(feedFalse, r, c), t.checkLegalMove(r, c));
            }
        }
    }

}