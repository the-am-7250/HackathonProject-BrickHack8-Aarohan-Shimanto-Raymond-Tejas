package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
/**
 * File name: playGame.java
 * @author: Aarohan Mishra and Shimanto Bhowmik
 */
public class playGame implements Comparator<Team>{
    private ArrayList<NPCTeam> teams;
    private Random r;
    private BufferedReader br;
    public playGame()throws IOException{
        teams= new ArrayList<>();
        r= new Random();
        br= new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> animalNames= new ArrayList<>();
        ArrayList<String> attributes= new ArrayList<>();
        try{
        BufferedReader fr1= new BufferedReader(new FileReader("AnimalNames.txt"));
        String s1= fr1.readLine();
        while(s1!=null){
            animalNames.add(s1);
            s1= fr1.readLine();
        }
        }catch(IOException E){
            System.err.println(E);
        }
        try{
        BufferedReader fr2= new BufferedReader(new FileReader("Attributes.txt"));
        String s2= fr2.readLine();
        while(s2!= null){
            attributes.add(s2);
            s2= fr2.readLine();
        }
        }catch(IOException E){
            System.err.println(E);
        }
        int i;
        for(i=0;i<9;i++){
            int randomIndex= r.nextInt(animalNames.size());
            String animal= animalNames.remove(randomIndex);
            int indexRandom= r.nextInt(attributes.size());
            String attribute= attributes.remove(indexRandom);
            String name= attribute+" "+animal;
            NPCTeam e= new NPCTeam(name);
            teams.add(e);
        }
    }
    public void createYourTeam()throws IOException{
        System.out.println("Enter the name of your team: ");
        String teamName= br.readLine();
    }
    public int compare(Team a, Team b){
        return 0;
    }
    public void displayTeams(){
        for(NPCTeam E: teams){
            System.out.println(E.getName());
        }
    }
}
