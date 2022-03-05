package src;
/**
 * File Name: myTeam.java
 * @author: Aarohan Mishra
 */
public class myTeam{
    private int Morale;
    private final int MAX_MORALE= 100;
    private final int MIN_MORALE= 0;
    private String NAME;
    private double cash;
    private double MIN_CASH= 0.0;
    private final int totalGamesToPlay= 18;
    private int gamesPlayed;
    private int pointsGained;
    public myTeam(String name){
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