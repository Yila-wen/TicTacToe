import java.util.Scanner;

public class TicTacToeRunner {
    public static void main(String[] args) {
        TicTacToe game1 = new TicTacToe();
        Scanner s = new Scanner(System.in);
        String clownPref = "X";
        String answer = "y";


        System.out.println("Welcome to TicTacToe, A Grid will be displayed with each box representing a different " +
                "number(1-9), from left to right."+ "\n" + "Would you like to be \"X\" or \"O\"?");
        String preference = s.nextLine();

        while(!preference.equals("X")&&!preference.equals("x")&&!preference.equals("O")&&!preference.equals("o"))
        {
            System.out.println("Let's try again, Would you like to be \"X\" or \"O\"?");
            preference = s.nextLine();
        }
        if (preference.equals("X")||preference.equals("x")) clownPref = "O";
        if (preference.equals("x")) preference = "X";
        else if (preference.equals("o")) preference = "O";

        System.out.println("Please type in either \"clown\" or \"mald\" to choose the difficulty you want.");
        String choice = s.nextLine();


        if (choice.contains("c")||choice.contains("C")) {

            game1.setPlay();
            while(game1.play){
            System.out.println(game1.displayGrid());
                if (game1.winCondition().equals(preference)) System.out.println("You Won!");
                else if (game1.winCondition().equals(clownPref)) System.out.println("You Lost!");
                else if (game1.tSpot==0) System.out.println("It's a Draw!");

            System.out.println("Please choose a box");
            int pInput = s.nextInt();

                game1.pInputChecker(pInput,preference);
            System.out.println(game1.displayGrid());
                if (game1.winCondition().equals(preference)){
                    System.out.println("You Won!");
                }
                else if (game1.winCondition().equals(clownPref)){
                    System.out.println("You Lost!");
                }
                else if (game1.tSpot==0){
                    System.out.println("It's a Draw!");
                }

            game1.clown(clownPref);

    }
            System.out.println("Would you like to play again?");
            answer = s.nextLine();

        }


        System.out.println("Here are your stats. \n" + game1.toString());
}}