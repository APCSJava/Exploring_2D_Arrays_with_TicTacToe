public class Runner {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        System.out.println(game);
        game.checkGameWon(2); // false
        game.checkLegalMove(1, 1); // true
        game.checkLegalMove(-4, 12); // false
        game.checkBoardFull(); // false
        game.place(2, 1, 0);
        game.checkLegalMove(1, 0); // false, already taken
        game.place(2, 1, 1);
        game.place(2, 1, 2);
        game.checkGameWon(1); // false, player 1 has not won
        game.checkGameWon(2); // true, player 2 has the middle row
        System.out.println(game);
    }
}
