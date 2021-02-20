import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Tests {

  @Test
  public void testWinCombinations() throws IllegalAccessException {
    TicTacToe t = new TicTacToe();
    Field boardField = null;
    try {
      boardField = t.getClass().getDeclaredField("board");
      boardField.setAccessible(true);
    } catch (NoSuchFieldException e) {
    }
    if (boardField == null) {
      Assert.fail("Your file should have a field of type int[][] named 'board'");
    }
    System.out.println("Printing:\n"+ Arrays.deepToString((Object[]) boardField.get(t)));
    String feedback = "The same player value across a row should produce a win.";
    boardField.set(t, new int[][] {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}});
    assertEquals(t.toString()+feedback, true, t.checkGameWon(1));
    assertEquals(t.toString()+feedback, false, t.checkGameWon(2));
    boardField.set(t, new int[][] {{0, 0, 0}, {2, 2, 2}, {0, 0, 0}});
    assertEquals(t.toString()+feedback, true, t.checkGameWon(2));
    assertEquals(t.toString()+feedback, false, t.checkGameWon(1));
    boardField.set(t, new int[][] {{0, 0, 0}, {0, 0, 0}, {3, 3, 3}});
    assertEquals(t.toString()+feedback, true, t.checkGameWon(3));
    assertEquals(t.toString()+feedback, false, t.checkGameWon(1));
    assertEquals(t.toString()+feedback, false, t.checkGameWon(2));
    String feedback2 = "The same player value down a column should produce a win.";
    boardField.set(t, new int[][] {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}});
    assertEquals(feedback, true, t.checkGameWon(1));
    assertEquals(feedback, false, t.checkGameWon(2));
    boardField.set(t, new int[][] {{0, 2, 0}, {0, 2, 0}, {0, 2, 0}});
    assertEquals(feedback, true, t.checkGameWon(2));
    assertEquals(feedback, false, t.checkGameWon(1));
    boardField.set(t, new int[][] {{0, 0, 3}, {0, 0, 3}, {0, 0, 3}});
    assertEquals(feedback, true, t.checkGameWon(3));
    assertEquals(feedback, false, t.checkGameWon(1));
    assertEquals(feedback, false, t.checkGameWon(2));
    String feedback3 = "The same player value along a diagonal should produce a win.";
    boardField.set(t, new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
    assertEquals(feedback, true, t.checkGameWon(1));
    assertEquals(feedback, false, t.checkGameWon(2));
    boardField.set(t, new int[][] {{0, 0, 2}, {0, 2, 0}, {2, 0, 0}});
    assertEquals(feedback, true, t.checkGameWon(2));
    assertEquals(feedback, false, t.checkGameWon(1));

  }
}