public class TicTacToe {
    public int tSpot;
    private int outcome = 0;
    public int pTotal = 0;
    public int cpuTotal;
    private int wins = 0;
    private int loses = 0;
    public boolean play = false;
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
    public TicTacToe(){
        }
    public void setPlay(){
        tSpot = 9;
        play = true;
        }

    public String displayGrid(){
        String s = "_______\n";
        for (int r = 0;r<3;r++){
            for (int c = 0; c < 4;c++){
                if (c < 3) {
                    s += "|" + grid[r][c];
                }
                else s +=  grid[r][c]+"|";
            }
            s+="\n";

        }
        s+= "-------";
        return s;
    }
    public void clownGrid(int row,int column,String input){
        grid[row][column] = input;
    }
    public void playerGrid(int row,int column,String input){
        grid[row][column] = input;
    }
    public void clown(String symbol){
        int column = 0;
        int row = 0;
        int check = 0;
        getOutcome();
        while (!spot(outcome) && check == 0){
            getOutcome();
            if (spot(outcome)) {
                check++;
            }
            if (winCondition().equals(symbol)){
                tSpot = 0;
                loses ++;
                play = false;
            }
    }
        cpuTotal += outcome;
        tSpot--;
        if (outcome%3==0)row = (outcome/3)-1;
        else row = (outcome/3);
        if (outcome%3==0) column = 2;
        else column = (outcome%3)-1;
    clownGrid(row,column,symbol);}

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
        if (spotnum == 1 && tLC){ tLC = false; check++;}
        if (spotnum == 2 && tC){ tC = false; check++;}
        if (spotnum == 3 && tRC){ tRC = false; check++;}
        if (spotnum == 4 && mL){ mL = false; check++;}
        if (spotnum == 5 && mC){ mC = false; check++;}
        if (spotnum == 6 && mR){ mR = false; check++;}
        if (spotnum == 7 && bLC){ bLC = false; check++;}
        if (spotnum == 8 && bC){ bC = false; check++;}
        if (spotnum == 9 && bRC){ bRC = false; check++;}
        if (check == 1) {
            tSpot--;
            return true;}
        else return false;
    }
    public String winCondition(){
        if (tSpot<=4){
                String c1 = grid[0][0]+grid[0][1]+grid[0][2];
                String c2 = grid[1][0]+grid[1][1]+grid[1][2];
                String c3 = grid[2][0]+grid[2][1]+grid[2][2];
                String r1 = grid[0][0]+grid[1][0]+grid[2][0];
                String r2 = grid[0][1]+grid[1][1]+grid[2][1];
                String r3 = grid[0][2]+grid[1][2]+grid[2][2];
                String ld = grid[0][0]+grid[1][1]+grid[2][2];
                String rd = grid[0][2]+grid[1][1]+grid[2][0];

                if(c1.equals("XXX")) return "X";
                if(c2.equals("XXX")) return "X";
                if(c3.equals("XXX")) return "X";
                if(r1.equals("XXX")) return "X";
                if(r2.equals("XXX")) return "X";
                if(r3.equals("XXX")) return "X";
                if(ld.equals("XXX")) return "X";
                if(rd.equals("XXX")) return "X";

                if(c1.equals("OOO")) return "O";
                if(c2.equals("OOO")) return "O";
                if(c3.equals("OOO")) return "O";
                if(r1.equals("OOO")) return "O";
                if(r2.equals("OOO")) return "O";
                if(r3.equals("OOO")) return "O";
                if(ld.equals("OOO")) return "O";
                if(rd.equals("OOO")) return "O";
            }
        return "";
    }

    public void pInputChecker(int pInput,String preference){
        int pcheck =0;
        int column = 0;
        int row = 0;
        if (play){
            while (!spot(pInput) && pcheck == 0){
                if (spot(pInput)){
                    pcheck++;
                    pTotal += pInput;
                    if (pInput%3==0)row = (pInput/3)-1;
                    else row = (pInput/3);
                    if (pInput%3==0) column = 2;
                    else column = (pInput%3)-1;
                    playerGrid(row,column,preference);
                    if (winCondition().equals(preference)){
                    tSpot = 0;
                    wins ++;
                    play = false;
                }
            }
        }
        }
    }

    private void getOutcome(){
        outcome = (int)((Math.random()*9)+1);
    }
    public String toString(){return "Wins: "+wins +"\n"+"Loses: " +loses;}



}