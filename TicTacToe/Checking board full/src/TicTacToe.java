import java.util.Arrays;

public class TicTacToe {

    private int[][] board;

    public TicTacToe() {
        board = new int[3][3];
    }

    public boolean checkLegalMove(int row, int column) {
        return board[row][column] == 0;
    }

    public void place(int player, int row, int column) {
        board[row][column]=player;
    }

    public boolean checkBoardFull() {
        for (int r = 0; r<board.length; r++) {
            for (int c = 0; c<board[r].length; c++){
                if (board[r][c]==0) return false;
            }
        }
        return true;
    }

    public int[][] getBoard() {
        return board;
    }

    public String toString() {
        String row0 = Arrays.toString(board[0]);
        String row1 = Arrays.toString(board[1]);
        String row2 = Arrays.toString(board[2]);
        return row0+"\n"+row1+"\n"+row2;
    }
}