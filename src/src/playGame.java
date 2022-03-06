package src;

import java.io.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.Random;
/**
 * File name: playGame.java
 * @author: Aarohan Mishra, Shimanto Bhowmik and Raymond Babich
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
            System.out.println(E.toString());
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
            int x= teams.indexOf(playerTeam);
            if(ans.compareTo("Y") == 0){
                teams.get(x).affectMorale(10);
                teams.get(x).affectCash(-300);
                break;
            }
            else if(ans.compareTo("N")==0){
                teams.get(x).affectMorale(-5);
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
                int x= teams.indexOf(playerTeam);
                teams.get(x).affectMorale(a);
                teams.get(x).affectCash(-700);
                break;
            }
            else if(ans.compareTo("N")==0){
                break;
            }
            else{
                System.out.println("Please enter Y or N. For the sake of this text coaching team, please");
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
        String ans= br.readLine();
        while(true){
            if(ans.compareTo("Y") == 0){
                int x= teams.indexOf(playerTeam);
                teams.get(x).affectMorale(-10);
                teams.get(x).affectCash(700);
                break;
            }
            else if(ans.compareTo("N")==0){
                break;
            }
            else{
                System.out.println("Please enter Y or N. For the sake of this text coaching team, please");
                ans= br.readLine();
            }
        }
    }
    public void situation4()throws IOException{
        System.out.println("Hey boss, wanted to make an ask of something. The lads and I have been working ");
        System.out.println("pretty hard in training this last week, and we're all burnt out because of it.");
        System.out.println("We were wondering if it were possible for us to get the day off from training. I know ");
        System.out.println("this is last minute, and would result in the team having a lit of loss in terms of money,");
        System.out.println("but its something we would all benefit from greatly. Final choice is of course, up to you boss");
        System.out.println();
        System.out.println("[Cash: -60");
        System.out.println("  Team Morale: +5]");
        System.out.println();
        String ans= br.readLine();
        while(true){
            if(ans.compareTo("Y") == 0){
                int x= teams.indexOf(playerTeam);
                teams.get(x).affectMorale(5);
                teams.get(x).affectCash(-100);
                break;
            }
            else if(ans.compareTo("N")==0){
                teams.get(teams.indexOf(playerTeam)).affectMorale(-5);
                break;
            }
            else{
                System.out.println("Please enter Y or N. For the sake of this text captain and his text players who are extremely tired and want a day off, please");
                ans= br.readLine();
            }
        }
    }
    public void situation5()throws IOException{
        System.out.println("Hey boss, wanted to make an ask of something.Just wanted to tell you about a dispute that occured recently.");
        System.out.println("One of our players were involved in a speeding violation. It would cause an issue if this situation were to come out to the press.");
        System.out.println("So, we can take care of the issue by spending some money. Final choice is of course, up to you boss");
        System.out.println();
        System.out.println("[Cash: -900/0");
        System.out.println(" [Team Morale: +0/-20]");
        System.out.println();
        String ans= br.readLine();
        while(true){
            if(ans.compareTo("Y") == 0){
                int index= teams.indexOf(playerTeam);
                teams.get(index).affectMorale(0);
                teams.get(index).affectCash(-900);
                break;
            }
            else if(ans.compareTo("N")==0){
                teams.get(teams.indexOf(playerTeam)).affectMorale(-20);
                break;
            }
            else{
                System.out.println("Please enter Y or N. For the sake of this text captain and his text players who are extremely tired and want a day off, please");
                ans= br.readLine();
            }
        }
    }
    public void playOneMatchday(){
        ArrayList<Team>team_= new ArrayList<>();
        int i;
        for(i=0;i<teams.size();i++){
            team_.add(teams.get(i));
        }
        while(!team_.isEmpty()){
            int randomIndex= r.nextInt(team_.size());
            Team a= team_.remove(randomIndex);
            randomIndex= r.nextInt(team_.size());
            Team b= team_.remove(randomIndex);
            if(a.hasPlayed(b)){
                while(true){
                    team_.add(a);
                    randomIndex= r.nextInt(team_.size());
                    a= team_.remove(randomIndex);
                    if(!a.hasPlayed(b)){
                        break;
                    }
                }
            }
            else if(b.hasPlayed(a)){
                while(true){
                    team_.add(b);
                    randomIndex= r.nextInt(team_.size());
                    b= team_.remove(randomIndex);
                    if(!b.hasPlayed(a)){
                        break;
                    }
                }
            }
            else{
                if(a instanceof myTeam || b instanceof myTeam){
                    int result= compare(a, b);
                    if(result>0){
                        a.addPoints(3);
                        a.affectMorale(10);
                        a.affectCash(200);
                        b.affectMorale(-10);
                        b.affectCash(-100);
                    }
                    else{
                        b.addPoints(3);
                        b.affectMorale(10);
                        b.affectCash(200);
                        a.affectMorale(-10);
                        a.affectCash(-100);
                    }
                }
                else if(a instanceof NPCTeam || b instanceof NPCTeam){
                    int res= r.nextInt(3);
                    if(res == 0){
                        a.addPoints(3);
                        a.affectMorale(10);
                        a.affectCash(200);
                        b.affectMorale(-10);
                        b.affectCash(-100);
                    }
                    else if(res == 1){
                        a.addPoints(1);
                        a.affectMorale(5);
                        a.affectCash(50);
                        b.addPoints(1);
                        b.affectMorale(5);
                        b.affectCash(50);
                    }
                    else{
                        b.addPoints(3);
                        b.affectMorale(10);
                        b.affectCash(200);
                        a.affectMorale(-10);
                        a.affectCash(-100);
                    }
                }
            }
        }
    }
    public void play()throws IOException{
        createYourTeam();
        int i;
        for(i=0;i<10;i++){
            if(playerTeam.isCashZero()|| playerTeam.isMoraleZero()){
                terminationLetter();
                break;
            }
            System.out.println("Team Morale: "+playerTeam.getMorale());
            System.out.println("Total money left: "+ playerTeam.getTotalCost());
            int j=0;
            for(j=0;j<2;j++){
                int randomIndex= r.nextInt(100);
                if(randomIndex == 47){
                    situation5();
                }
                else if(randomIndex%5 == 0){
                    situation2();
                }
                else if(randomIndex%7 == 0){
                    situation4();
                }
                else if(randomIndex%3 == 0){
                    situation3();
                }
                else{
                    situation1();
                }
            }
            playOneMatchday();
            System.out.println("Table after Matchday "+ (i+1) +": ");
            sortTeams();
            displayTeams();
        }
    }
    public void sortTeams(){
        int i,j;
        int size= teams.size();
        Team[] holder= new Team[size];
        for(i=0;i<size;i++){
            holder[i]= teams.get(i);
        }
        for(i=0;i<size-1;i++){
            Team a= holder[i];
            Team mostPoints= a;
            int index= i;
            for(j=i+1;j<size;j++){
                Team b= holder[j];
                if(b.getPoints()> mostPoints.getPoints()){
                    mostPoints= b;
                    index= j;
                }
            }
            Team temp= holder[i];
            holder[i]= holder[index];
            holder[index]= temp;
        }
        teams= new ArrayList<>();
        for(i=0;i<size;i++){
            teams.add(holder[i]);
        }
    }
    public void terminationLetter(){
        try{
            BufferedReader fr= new BufferedReader(new FileReader("TerminationLetter.txt"));
            String s= fr.readLine();
            while(s!=null){
                System.out.println(s);
                s= fr.readLine();
            }
        }
        catch(IOException E){
            System.err.println(E);
        }
    }
    public static void main(String[] args)throws IOException{
        playGame obj= new playGame();
        obj.play();
    }
}