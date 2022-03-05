import src.TeamBase;

/**
 * File Name: myTeam.java
 * @author: Aarohan Mishra
 */
public class myTeam extends TeamBase{
    private int Morale;
    private String NAME;
    private double cash;
    private int gamesPlayed;
    private int pointsGained;
    public myTeam(String name){
        super();
        Morale= 60;
        cash= 1000;
        NAME= name;
        gamesPlayed= 0;
        pointsGained=0;
    }
    public int getMorale(){
        return Morale;
    }
    public String getTeamName(){
        return NAME;
    }
    public double getTotalCash(){
        return cash;
    }
    public int getGamesPlayed(){
        return gamesPlayed;
    }
    public int getTotalPoints(){
        return pointsGained;
    }
    public void addPoints(int points){
        pointsGained+=points;
    }
    public void gamePlayed(){
        gamesPlayed+=1;
    }
}