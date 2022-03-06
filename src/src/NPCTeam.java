package src;

import java.util.HashMap;

/**
 * File name: NPCTeam.java
 * @author: Aarohan Mishra
 */
public class NPCTeam extends TeamBase implements Team{
    private int Morale;
    private int cash;
    private String NAME;
    private int gamesPlayed;
    private int pointsGained;
    private HashMap<Team, Integer> playCounter;
    public NPCTeam(String name){
        super();
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
    public String getName(){
        return NAME;
    }
    public double getTotalCost(){
        return cash;
    }
    @Override
    public int getPoints(){
        return pointsGained;
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
    public void affectMorale(int moraleAffect){
        Morale+= moraleAffect;
    }
    public void affectCash(int cashAffect){}
    public void updatePlayCounter(Team a){
        playCounter.put(a, 1);
    }
    public boolean hasPlayed(Team a){
        return playCounter.containsValue(a);
    }
    public String toString(){
        return getName() + " "+getTotalPoints();
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
    public boolean isPlayerTeam(){
        return false;
    }
}