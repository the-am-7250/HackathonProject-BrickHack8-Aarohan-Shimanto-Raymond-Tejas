package src;
/**
 * File Name: myTeam.java
 * @author: Aarohan Mishra and Shimanto Bhowmik
 */
public class myTeam extends TeamBase implements Team{
    private int Morale;
    private String NAME;
    private double cash;
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
    @Override
    public String getName(){
        return NAME;
    }
    public double getTotalCost(){
        return cash;
    }
    public int getGamesPlayed(){
        return gamesPlayed;
    }
    @Override
    public int getPoints(){
        return pointsGained;
    }
    public void addPoints(int points){
        pointsGained+=points;
    }
    public void gamePlayed(){
        gamesPlayed+=1;
    }

    public void affectMorale(int moraleAffect){
        Morale+= moraleAffect;
    }
    public void affectCash(int cashAffect){
        cash+=cashAffect;
    }
    public boolean isCashZero(){
        boolean bool = false;
        if(cash ==0){
            bool = true;
        }
        return bool;
    }
    public boolean isMoraleZero(){
        boolean bool = false;
        if(Morale ==0){
            bool = true;
        }
        return bool;
    }
}