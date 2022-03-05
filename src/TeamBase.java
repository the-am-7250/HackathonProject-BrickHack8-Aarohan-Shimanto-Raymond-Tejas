package src;

public abstract class TeamBase {
    
    public final int MAX_MORALE = 100;
    public final int MIN_MORALE = 0;
    public final double MIN_CASH = 0;


    public TeamBase(String name){
    
    }

    public abstract int getMorale();

    public abstract String getName();

    public abstract double getTotalCost();

}
