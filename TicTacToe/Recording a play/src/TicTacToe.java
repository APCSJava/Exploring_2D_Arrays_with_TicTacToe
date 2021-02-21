public class TicTacToe {

    private int[][] board;

    /**
     * Initializes the board to a 3x3 array
     */
    public TicTacToe() {
        board = new int[3][3];
    }

    /**
     * Records a player's move on the board
     * @param player an integer representing the player
     * @param row
     * @param column
     */
    public void place(int player, int row, int column) {
        board[row][column]=player;
    }

    public int[][] getBoard() {
        return board;
    }

}