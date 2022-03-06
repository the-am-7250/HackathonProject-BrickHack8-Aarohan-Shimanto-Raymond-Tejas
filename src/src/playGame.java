package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * File name: playGame.java
 * @author: Aarohan Mishra and Shimanto Bhowmik
 */
public class playGame{
    private ArrayList<Team> teams;
    private Random r;
    private BufferedReader br;
    private Team playerTeam;
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
            Team e= new NPCTeam(name);
            teams.add(e);
        }
    }
    public void createYourTeam()throws IOException{
        System.out.println("Enter the name of your team: ");
        String teamName= br.readLine();
        playerTeam= new myTeam(teamName);
        teams.add(playerTeam);
    }
    public int compare(Team a, Team b){
        int result= a.getPoints() - b.getPoints();
        if(result == 0){
            result= a.getName().compareTo(b.getName());
        }
        return result;
    }
    public void displayTeams(){
        for(Team E: teams){
            System.out.println(E.getName());
        }
    }
    public void sort(){
        int i,j;
        int l= teams.size();
        for(i=0;i<l-1;i++){
            for(j= i+1;j<l;j++){
                Team a= teams.remove(i);
                Team b= teams.remove(j);
                if(compare(b, a) > 0){
                    teams.add(i, b);
                    teams.add(j, a);
                }
            }
        }
    }
     public void Simulation(){
         System.out.println("Do you want to train your team?(Cash-300,Morale+10)(Y/N)");
         System.out.println("Do you want to buy a player?(Cash-700,Morale- +10/-15)(Y/N)");
         System.out.println("DO you want to give rest to your team?(Cash-60,Morale+5)");
         System.out.println("Do you want to sell a player?(Cash+700,Morale- 10)(Y/N)");
         System.out.println("One of your pleayers is going to jail because of going over the speed limit.");
         System.out.println("Do you want to resolve this issue?(Cash-900, N-Moral-20)(Y/N)");
    }
    public void situation1()throws IOException{
        System.out.println("Your coaching team approaches you asking about whether investments can be made to the");
        System.out.println(" training ground, since some instruments have been found to not be up to the standards");
        System.out.println(" that the club upholds. Do you want to make these upgrades?");
        System.out.println();
        System.out.println(" [Cash: -300");
        System.out.println("  Team Morale: +10]");
        System.out.println();
        System.out.print("(Y/N): ");
        String ans= br.readLine();
        while(true){
            if(ans.compareTo("Y") == 0){
                teams.get(teams.indexOf(playerTeam)).affectMorale(10);
                teams.get(teams.indexOf(playerTeam)).affectCash(-300);
                break;
            }
            else if(ans.compareTo("N")==0){
                teams.get(teams.indexOf(playerTeam)).affectMorale(-5);
                break;
            }
            else{
                System.out.println("Please enter Y or N. For the sake of this text coaching team. Please");
                ans= br.readLine();
            }
        }
    }
    public void situation2()throws IOException{
        int age= r.nextInt(17, 43);
        System.out.println("Your assistant manager approaches you with a scouting report, its of a " + age + " years ");
        System.out.println("old who could be a good boost to our team. I'm not sure about his attitude though, so he could either ");
        System.out.println("be a great asset or someone who brings the mood down amongst the squad. Final call's up to you though ");
        System.out.println("for this one. What do you say? Should we sign him up?");
        System.out.println();
        System.out.println("[Cash: -700");
        System.out.println("  Team Morale: +15/-10]");
        System.out.println();
        int chance= r.nextInt(2);
        String ans= br.readLine();
        while(true){
            if(ans.compareTo("Y") == 0){
                int a;
                if(chance == 0){
                    a= 15;
                }
                else{
                    a= -10;
                }
                teams.get(teams.indexOf(playerTeam)).affectMorale(a);
                teams.get(teams.indexOf(playerTeam)).affectCash(-700);
                break;
            }
            else if(ans.compareTo("N")==0){
                break;
            }
            else{
                System.out.println("Please enter Y or N. For the sake of this text coaching team. Please");
                ans= br.readLine();
            }
        }

    }
    public void situation3()throws IOException{
        int age= r.nextInt(17, 43);
        System.out.println("Your assistant manager approaches you with a scouting report, its of a team player with" + age + " years ");
        System.out.println("We could sell this player, and earn some money for other improvements. But it would affect the team morale though. ");
        System.out.println("for this one. What do you say? Should we sell him?");
        System.out.println();
        System.out.println("[Cash: +700");
        System.out.println("  Team Morale: -10]");
        System.out.println();
        int chance= r.nextInt(2);
        String ans= br.readLine();
        while(true){
            if(ans.compareTo("Y") == 0){
                int a;
                if(chance == 0)
                    a= -10;     
                teams.get(teams.indexOf(playerTeam)).affectMorale(a);
                teams.get(teams.indexOf(playerTeam)).affectCash(700);
                break;
            }
            else if(ans.compareTo("N")==0){
                break;
            }
            else{
                System.out.println("Please enter Y or N. For the sake of this text coaching team. Please");
                ans= br.readLine();
            }

    }
}
