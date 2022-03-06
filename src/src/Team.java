package src;



/**
 * File Name: Team.java
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
    public void updatePlayCounter(Team a);
    public boolean hasPlayed(Team a);
    public String toString();
    public boolean isCashZero();
    public boolean isMoraleZero();
    public boolean isPlayerTeam();
}

    

