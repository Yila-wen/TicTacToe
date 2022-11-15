import java.util.Scanner;
public class TicTacToe {
    private boolean play = false;
    private int ws = 0;
    private int outcome = 0;
    private int cpuCount = 0;
    private int pCount = 1;
    public int pInput = 0;
    private int pTotal = 0;
    private int cpuTotal = 0;
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
        cpuTotal = 0;
        int pcheck = 1;
        play = true;
        if (choice.contains("c")){
            for (int tSpot = 9; tSpot> 0;tSpot--){
                if (cpuCount < pCount){
                clown();
                cpuCount++;
                tSpot--;
                if (winCondiiton(tSpot) == -1){
                    tSpot = 0;
                    System.out.println("WC: "+winCondiiton(cpuTotal));
                }

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
                        pTotal += pInput;
                        if (winCondiiton(tSpot) == 1){
                            tSpot = 0;
                            winCondiiton(pTotal);
                        }
            }}}}
                System.out.println("Spot: "+tSpot);
                if (winCondiiton(cpuTotal) != -1 && winCondiiton(pTotal) != 1){
                if (winCondiiton(tSpot)==0){
                    System.out.println("It's a draw!");}}
            }
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
        cpuTotal += outcome;
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
    private int winCondiiton(int number){
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
    private void getOutcome(){
        outcome = (int)((Math.random()*9)+1);
    }

}