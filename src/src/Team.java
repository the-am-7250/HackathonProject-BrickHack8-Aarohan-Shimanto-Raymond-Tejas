package src;



/**
 * File Name: TeamComparator.java
 * @author: Shimanto Bhowmik
 */
public interface Team  {

    public int getPoints();
    public String getName();
    public int getMorale();
    public double getTotalCost();
    public int getGamesPlayed();
    public void addPoints(int points);
    public void gamePlayed();
    public void affectMorale(int moraleAffect);
    public void affectCash(int cashAffect);
    }
    

