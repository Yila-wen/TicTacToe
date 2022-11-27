/**
 * The TicTacToe class represents the Tic-Tac-Toe game.
 * A Tic-Tac-Toe game is a game thus is either in play or not in play, you can either win, lose, or draw(no one cares about this)
 * it also has a set grid of 3 by 3
 *
 */
public class TicTacToe {
    public int tSpot;
    private int outcome = 0;
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

    /**
     * Constructor for the TicTacToe Class only creates a new instance of TicTacToe
     */
    public TicTacToe(){
        }

    /**
     * The setPlay method is a method that will set the preconditions before a game begins
     * Such as setting the # of valid spots to the max(9) and play to true
     */
    public void setPlay(){
        tSpot = 9;
        play = true;
        }

    /**
     * The displayGrid method creates a grid that can be shown to the user using a String
     *
     * @return returns a grid with intended information on it
     */

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

    /**
     * The clownGrid method allows the cpu to place their choice onto the grid
     *
     * @param row represents the row
     * @param column represents th column
     * @param input represents the symbol being put onto the grid
     */
    public void clownGrid(int row,int column,String input){
        grid[row][column] = input;
    }

    /**
     * The playerGrid methods allows the player to place their choice onto the grid
     *
     * @param row represents the row
     * @param column represents th column
     * @param input represents the symbol being put onto the grid
     */
    public void playerGrid(int row,int column,String input){
        grid[row][column] = input;
    }

    /**
     * The clown method is a difficulty for the TicTacToe class and dictates how the cpu
     * choice will be made.
     *
     * @param symbol represents the symbol that will be put onto the grid
     */
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
        }
        if (outcome%3==0)row = (outcome/3)-1;
        else row = (outcome/3);
        if (outcome%3==0) column = 2;
        else column = (outcome%3)-1;
        clownGrid(row,column,symbol);
        if (winCondition().equals(symbol)){
            tSpot = 0;
            loses ++;
            play = false;
        }}

    /**
     * The spot method checks whether a certain spot is occupied or not
     *
     * @param spotnum represents the numbered spot that will be checked
     * @return either false or true depending on if the spot was occupied or not
     */

    private boolean spot ( int spotnum ) {
        int check = 0;
        if (spotnum == 1 && tLC==true){ tLC = false; check++;}
        if (spotnum == 2 && tC==true){ tC = false; check++;}
        if (spotnum == 3 && tRC==true){ tRC = false; check++;}
        if (spotnum == 4 && mL==true){ mL = false; check++;}
        if (spotnum == 5 && mC==true){ mC = false; check++;}
        if (spotnum == 6 && mR==true){ mR = false; check++;}
        if (spotnum == 7 && bLC==true){ bLC = false; check++;}
        if (spotnum == 8 && bC==true){ bC = false; check++;}
        if (spotnum == 9 && bRC==true){ bRC = false; check++;}
        if (check == 1) {
            tSpot--;
            return true;}
        else return false;
    }

    /**
     * The winCondition class checks if the number of spots available are 4 or less else ends
     * if the above is met it checks if 1 of the 8 possible win scenarios in Tic-Tac-Toe has been met
     * then returns the corresponding symbol
     * @return nothing if the precondition is not met and if met either X or O is returned depending on which won
     */
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

    /**
     * The pInputChecker method checks if the player input's spot is occupied or not
     * if occupied it will not run
     * if not occupied it will place the symbol into the spot
     *
     * @param pInput represents the player's choice
     * @param preference represents the player's symbol
     */

    public void pInputChecker(int pInput,String preference){
        int pcheck =0;
        int column = 0;
        int row = 0;
        if (play){

            while (pcheck == 0){
                if (spot(pInput)){
                    pcheck++;
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

    /**
     * The method getOutcome gets an outcome for the clown method.
     */

    private void getOutcome(){
        outcome = (int)((Math.random()*9)+1);
    }

    /**
     * The toString method for the TicTacToe class. This method will return a String showing
     * the users Wins and Loses in a format.
     *
     * @return a string in a spaced format containing the user's wins and loses.
     */
    public String toString(){return "Wins: "+wins +"\n"+"Loses: " +loses;}



}