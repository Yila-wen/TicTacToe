import java.util.Scanner;

public class TicTacToeRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe, if you don't know the rules search it up."+ "\n"
                + "Please type in either \"clown\" or \"mald\" to choose the difficulty you want.");
        String choice = s.nextLine();

        TicTacToe game1 = new TicTacToe(choice);

    }
}