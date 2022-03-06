package src;

import java.util.HashMap;

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
    private HashMap<Team, Integer> playCounter;
    public myTeam(String name){
        Morale= 60;
        cash= 1000;
        NAME= name;
        gamesPlayed= 0;
        pointsGained=0;
        playCounter= new HashMap<>();
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
        if(cash <=0){
            bool = true;
        }
        return bool;
    }
    public boolean isMoraleZero(){
        boolean bool = false;
        if(Morale <=0){
            bool = true;
        }
        return bool;
    }
    public void updatePlayCounter(Team a){
        playCounter.put(a, 1);
    }
    public boolean hasPlayed(Team a){
        return playCounter.containsValue(a);
    }
    public String toString(){
        return getName() + " "+getPoints();
    }
    public boolean isPlayerTeam(){
        return true;
    }
}