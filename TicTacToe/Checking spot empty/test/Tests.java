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
        String expected = Arrays.toString(test[0])+"\n"+Arrays.toString(test[1])+"\n"+Arrays.toString(test[2]);
        assertEquals("Check string formatting", expected, result);
    }

    // specific to task 3
    @Test
    public void testAvailableUntilClaimed() {
        TicTacToe t = new TicTacToe();
        int[][] arr = t.getBoard();
        String feedTrue = "Unclaimed array location (%s, %s) should return true.";
        String feedFalse = "Claimed array location (%s, %s) should return false.";
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                assertTrue(String.format(feedTrue, r, c), t.checkEmpty(r, c));
                t.place(Math.random() < 0.5 ? 1 : 2, r, c);
                assertFalse(String.format(feedFalse, r, c), t.checkEmpty(r, c));
            }
        }
    }
}