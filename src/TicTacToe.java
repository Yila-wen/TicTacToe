import java.util.Scanner;
public class TicTacToe {
    public int tSpot;
    private int outcome = 0;
    private int cpuCount = 0;
    private int pCount = 1;
    public int pInput = 0;
    public int pTotal = 0;
    public int cpuTotal = 0;
    private boolean play = false;
    private boolean tLC = true;
    private boolean tC = true;
    private boolean tRC = true;
    private boolean mL = true;
    private boolean mC = true;
    private boolean mR = true;
    private boolean bLC = true;
    private boolean bC = true;
    private boolean bRC = true;
    private String[][] grid = {
            {" "," "," ",""},
            {" "," "," ",""},
            {" "," "," ",""}
    };

    Scanner s = new Scanner(System.in);


    public TicTacToe(String choice){
        cpuTotal = 0;
        play = true;
        if (choice.contains("c")){

            }
        }
    public String displayGrid(){
        String s = "_____________\n";
        for (int r = 0;r<3;r++){
            for (int c = 0; c < 4;c++){
                s+= "|" + grid[r][c];
                if (c < 3) {
                    s += "_" + grid[r][c];
                }
            }
            s+="\n";

        }
        s+= "-------------";
        return s;
    }
    public void start(){

    }
    public int clown(){
        int check = 0;
        getOutcome();
        while (!spot(outcome) && check == 0){
            getOutcome();
            if (spot(outcome)) {
                check++;
            }
            if (winCondition(tSpot) == -1){
                tSpot = 0;
                play = false;
            }
    }
        cpuTotal += outcome;
        cpuCount++;
        tSpot--;
    return outcome;}

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
    public int winCondition(int number){
        if (winCChecker()){
        if (number < 5 && number != 0){
        if (pTotal%6 == 0 || pTotal == 15){
            System.out.println("Player wins");
            return 1;
        }
        if (cpuTotal%6 == 0 || cpuTotal == 15){
            System.out.println("Computer wins");
            return -1;
        }
    }
        if (number == 0){
            return 0;
        }}
        return 5;
    }
    public boolean winCChecker(){
        if (!(tLC || tC || tRC)){
            return true;
        }
        else if (!(mL||mC||mR)){
            return true;
        }
        else if (!(bLC||bC||bRC)){
            return true;
        }
        else if (!(tLC||mL||bLC)){
            return true;
        }
        else if (!(tC||mC||mL)){
            return true;
        }
        else if (!(tRC||mR||bRC)){
            return true;
        }
        else if(!(tRC||mC||bLC)){
            return true;
        }
        else if (!(tLC||mC||bRC)){
            return true;
        }
        else return false;
    }

    public void pInputChecker(int pInput){
        int pcheck =0;
        if (play){
        while (!spot(outcome) && pcheck == 0){
            if (spot(pInput)){
                pcheck++;
                pCount++;
                pTotal += pInput;
                if (winCondition(tSpot) == 1){
                    tSpot = 0;
                    winCondition(pTotal);
                    play = false;
                }
            }
        }
    }}

    private void getOutcome(){
        outcome = (int)((Math.random()*9)+1);
    }
    public String pInput(){
        return "Please input your choice.";

    }

}