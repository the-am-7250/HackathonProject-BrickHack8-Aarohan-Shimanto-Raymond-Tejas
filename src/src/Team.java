package src;

import java.util.Comparator;

/**
 * File Name: TeamComparator.java
 * @author: Shimanto Bhowmik
 */
public class Team implements Comparator<myTeam> {

    @Override
    public int compare(myTeam first, myTeam second) {
        int result = first.getTotalPoints() - second.getTotalPoints();
        if(result ==0){
            result = first.getTeamName().compareTo(second.getTeamName());
        }
        return result;
    }
    
}
