package src;
/**
 * File Name: TeamBase.java
 * @author: Shimanto Bhowmik
 */
public abstract class TeamBase {
    
    protected final int MAX_MORALE = 100;
    protected final int MIN_MORALE = 0;
    protected final double MIN_CASH = 0;
    protected int TOTAL_GAMES_TO_PLAY = 18;

    public TeamBase(){
    
    }

    public abstract int getMorale();

    public abstract String getName();

    public abstract double getTotalCost();

   
}
