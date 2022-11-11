import java.util.Scanner;
public class TicTacToe {
    private boolean play = false;
    private int ws = 0;
    private int outcome = 0;
    private int cpuCount = 0;
    private int pCount = 1;
    public int pInput = 0;
    private boolean tLC = true;
    private boolean tC = true;
    private boolean tRC = true;
    private boolean mL = true;
    private boolean mC = true;
    private boolean mR = true;
    private boolean bLC = true;
    private boolean bC = true;
    private boolean bRC = true;

    Scanner s = new Scanner(System.in);


    public TicTacToe(String choice){
        int pcheck = 1;
        play = true;
        if (choice.contains("c")){
            for (int tSpot = 9; tSpot> 0;tSpot--){
                if (cpuCount < pCount){
                clown();
                cpuCount++;
                tSpot--;
                }
                if (tSpot != 0){
                if (cpuCount >= pCount){
                    pcheck--;
                while (!spot(outcome) && pcheck == 0){
                    System.out.println("please input your choice");
                    pInput = s.nextInt();
                    if (spot(pInput)){
                        pcheck++;
                        pCount++;
            }}}}}System.out.println("It's a draw!");

    }
    }
    // print statements = where display code should be
    public void clown(){
        int check = 0;
        getOutcome();
        while (!spot(outcome) && check == 0){
            getOutcome();
            if (spot(outcome)) {
                check++;
            }

    }
    System.out.println(outcome);}

    private int mald(){
        outcome = 5;
        if (spot(outcome)) return outcome;
        outcome = (int)((Math.random()*4)+1);
        if (outcome == 2)outcome = 3;
        else if (outcome == 3)outcome = 7;
        else if (outcome == 4)outcome = 9;
        if (spot(outcome)) return outcome;
        return 0;
    }

    private boolean spot ( int spotnum ) {
        int check = 0;
        if (spotnum == 1 && tLC == true){ tLC = false; check++;}
        if (spotnum == 2 && tC == true){ tC = false; check++;}
        if (spotnum == 3 && tRC == true){ tRC = false; check++;}
        if (spotnum == 4 && mL == true){ mL = false; check++;}
        if (spotnum == 5 && mC == true){ mC = false; check++;}
        if (spotnum == 6 && mR == true){ mR = false; check++;}
        if (spotnum == 7 && bLC == true){ bLC = false; check++;}
        if (spotnum == 8 && bC == true){ bC = false; check++;}
        if (spotnum == 9 && bRC == true){ bRC = false; check++;}
        if (check == 1) {

            return true;}
        else return false;
    }
    private void getOutcome(){
        outcome = (int)((Math.random()*9)+1);
    }

}