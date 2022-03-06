package src;
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
    public NPCTeam(String name){
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
    public String getName(){
        return NAME;
    }
    public double getTotalCost(){
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
    public void affectMorale(int moraleAffect){
        Morale+= moraleAffect;
    }
    public void affectCash(int cashAffect){}
    
}
