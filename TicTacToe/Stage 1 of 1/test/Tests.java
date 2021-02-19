import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    for (int i = 0; i<arr.length; i++) {
      for (int j = 0; j<arr[i].length; j++) {
        assertEquals(feedback, 0, arr[i][j]);
      }
    }
  }
}