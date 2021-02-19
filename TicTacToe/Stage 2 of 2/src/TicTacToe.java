public class TicTacToe {

    private int[][] board;

    public TicTacToe() {
        board = new int[3][3];
    }

    public void place(int player, int row, int column) {
        board[row][column]=player;
    }

    public int[][] getBoard() {
        return board;
    }
}