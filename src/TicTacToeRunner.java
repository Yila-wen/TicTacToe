import java.util.Scanner;

public class TicTacToeRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe, if you don't know the rules search it up."+ "\n"
                + "Please type in either \"clown\" or \"mald\" to choose the difficulty you want.");
        String choice = s.nextLine();


        TicTacToe game1 = new TicTacToe(choice);
        System.out.println(game1.displayGrid());
        System.out.println("remove this");




        if (game1.winCondition(game1.cpuTotal)==-1){
            System.out.println("You Lost!");
        }
        else if (game1.winCondition(game1.pTotal)==1){
            System.out.println("You Won!");
        }
        else if (game1.winCondition(game1.cpuTotal)!=1 && game1.winCondition(game1.pTotal)!=1){
        if (game1.winCondition(game1.tSpot)==0){
            System.out.println("It's a Draw!");
        }
        }

    }
}