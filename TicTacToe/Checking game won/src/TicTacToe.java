import java.util.Arrays;

public class TicTacToe {

    private int[][] board;

    public TicTacToe() {
        board = new int[3][3];
    }

    /**
     * Checks whether the indicated player appears on the board in a winning configuration
     *
     * @return whether the indicated player has won
     */
    public boolean checkWin(int player) {
        if (board[0][0] == player && board[0][1] == player && board[0][2] == player) return true;
        if (board[1][0] == player && board[1][1] == player && board[1][2] == player) return true;
        if (board[2][0] == player && board[2][1] == player && board[2][2] == player) return true;
        if (board[0][0] == player && board[1][0] == player && board[2][0] == player) return true;
        if (board[0][1] == player && board[1][1] == player && board[2][1] == player) return true;
        if (board[0][2] == player && board[1][2] == player && board[2][2] == player) return true;
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public boolean checkEmpty(int row, int column) {
        return board[row][column] == 0;
    }

    public void place(int player, int row, int column) {
        board[row][column] = player;
    }

    public int[][] getBoard() {
        return board;
    }

    public String toString() {
        String row0 = Arrays.toString(board[0]);
        String row1 = Arrays.toString(board[1]);
        String row2 = Arrays.toString(board[2]);
        return row0 + "\n" + row1 + "\n" + row2;
    }
}