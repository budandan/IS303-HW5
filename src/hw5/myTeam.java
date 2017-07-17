/*
Daniel Ferolino
IS303
Sec 002
HW5

Program Description: This program will create an array of three teams. Each team will
                        have getters and setters for its name, wins, losses, pointsFor 
                        and pointsAgainst. It will also have the method of getting 
                        all the points and setting the win-loss percentages. The
                        program will prompt the user to input the names, wins, losses
                        and points scored. The program will store the values and then
                        will prompt the user to search for a team. Searching for a
                        valid team will output its wins and losses. Any invalid input
                        will be caught by the system and will reprompt the user.
 */
package hw5;

import java.util.*;

public class myTeam {
    
    private String teamName;
    private int wins;
    private int losses;
    private int totalPointsFor;
    private int totalPointsAgainst;
    private double winLossPct;
    
    public String getTeam() {
        return teamName;
    }
    
    public void setTeam(String teamName) {
        this.teamName = teamName;
    }
    
    public void setWins (int wins) {
        this.wins = wins;
    }
    
    public void setLosses (int losses) {
        this.losses = losses;
    }
    
    public void setWinsLosses(int wins, int losses) {
        this.wins = wins;
        this.losses = losses;
        this.winLossPct = ((double)wins/((double)wins + (double)losses));
    }
    
    public int getWins() {
        return wins;
    }
    
    public int getLosses() {
        return losses;
    }
    
    public void addPointsFor(int score) {
        this.totalPointsFor += score;
    }
    
    public void addPointsAgainst(int score) {
        this.totalPointsAgainst += score;
    }
    
    public void getAllPoints() {
        System.out.println("Points For " + totalPointsFor + " and Points Against " + totalPointsAgainst);
    }
    
    
    public static void main(String[] args) {
        Scanner userinput = new Scanner(System.in);
        
        myTeam[] team_array = new myTeam[3];
        int errorflag = 1;
        String myName;
        int myWins;
        int myLosses;
        int myPointsFor;
        int myPointsAgainst;
        boolean match;
                
        String searchName;
        
        for (int i = 0; i < team_array.length; i++) {
            team_array[i] = new myTeam();
        }
        
        for (int i = 0; i < team_array.length; i++) {
            System.out.println("\n\nInput values for Team " + (i + 1) + ": ");
            
            System.out.print("\tTeam Name: ");
            myName = userinput.nextLine();
            team_array[i].setTeam(myName); // set team name
            
            errorflag = 1; // reset error flag
            
            while (errorflag == 1) {
                try {
                    System.out.print("\tWins: ");
                    myWins = userinput.nextInt();
                    userinput.nextLine();
                    team_array[i].setWins(myWins);
                    errorflag--;
                }
                catch (Exception e) {
                        System.out.println("\tInvalid Input...Try Again.");
                        userinput.nextLine();
                }
            }
            
            errorflag = 1; // reset error flag
            
            while (errorflag == 1) {
                try {
                    System.out.print("\tLosses: ");
                    myLosses = userinput.nextInt();
                    userinput.nextLine();
                    errorflag--;
                    team_array[i].setLosses(myLosses);
                }
                catch (Exception e) {
                    System.out.println("\tInvalid Input...Try Again.");
                    userinput.nextLine();
                }
            }
            
            team_array[i].setWinsLosses(team_array[i].getWins(), team_array[i].getLosses());
            
            errorflag = 1;
            
            while (errorflag == 1) {
                try {
                    System.out.print("\tEnter the Points For: ");
                    myPointsFor = userinput.nextInt();
                    userinput.nextLine();
                    team_array[i].addPointsFor(myPointsFor);
                    errorflag--;
                }
                catch (Exception e) {
                    System.out.println("\tInvalid Input...Try Again.");
                    userinput.nextLine();
                }
            }
            
            errorflag = 1;
            
            while (errorflag == 1) {
                try {
                    System.out.print("\tEnter the Points Against: ");
                    myPointsAgainst = userinput.nextInt();
                    userinput.nextLine();
                    team_array[i].addPointsAgainst(myPointsAgainst);
                    errorflag--;
                }
                catch (Exception e) {
                    System.out.println("\tInvalid Input...Try Again.");
                    userinput.nextLine();
                }
            }
        }
        
        System.out.println("Data Input Complete!\n");
        
        match = false;
        
        
        do {    
            System.out.print("Search for a team by name: ");
            searchName = userinput.nextLine();
            
            for (int j = 0; j < team_array.length; j++) {
                if (searchName.equalsIgnoreCase(team_array[j].getTeam())) {
                    match = true;
                    System.out.println("\n\nTeam Name: " + team_array[j].getTeam());
                    System.out.println("\tWins: " + team_array[j].getWins());
                    System.out.println("\tLosses: " + team_array[j].getLosses());
                }
            } 
            if (match == false)
                System.out.println("Team does not exist...try again.");
        } while (match == false);
    }
    
}
