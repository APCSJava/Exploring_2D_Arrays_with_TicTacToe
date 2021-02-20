import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        System.out.println(game);

        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1: Enter the row and column for your move:");
        int r = scan.nextInt();
        int c = scan.nextInt();
        game.place(1, r, c);
        System.out.println(game);
    }
}
