import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scan = new Scanner(System.in);

        int player = 1;
        System.out.println(game);
        while(true) {
            System.out.println("Player " + player + ": Enter the row and column for your move:");
            int r = scan.nextInt();
            int c = scan.nextInt();
            while (!game.checkLegalMove(r, c)) {
                System.out.println("Illegal move.  Please try again:");
                r = scan.nextInt();
                c = scan.nextInt();
            }
            game.place(player, r, c);
            System.out.println(game);
            if (game.checkGameWon(player)){
                System.out.println("Player "+player+" wins!");
                break;
            }
            if (game.checkBoardFull()) {
                System.out.println("Game is a draw.");
                break;
            }
            if (player == 2) player = 1;
            else player = 2;
        }
    }
}
