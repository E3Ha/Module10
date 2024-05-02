import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;

public class QuidditchTournament {

    public static void main(String[] args) {

        ArrayList<String> teams = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        teams.add("Wyverns");
        teams.add("Drakes");
        teams.add("Occamys");
        teams.add("Nifflers");
        teams.add("Demiguises");
        teams.add("Fwoopers");
        teams.add("Erumpents");
        teams.add("Bowtruckles");


        int team1Score = rand.nextInt(5) * 10;
        System.out.println(team1Score);



    }
    public static void playGame(Random rand, int team1, int team2, ArrayList<String> teamsArray){
        //Output teams in match
        System.out.println();
        System.out.println(teamsArray.get(team1) + " vs " + teamsArray.get(team2));
        //Each team randomly scores 0-4 goals per quarter
        int team1Score = rand.nextInt(5) * 10;
        int team2Score = rand.nextInt(5) * 10;

        boolean snitchCaught = false;

        //Determine if a team got the golden snitch - if they did they win
        int snitchChance = rand.nextInt(100) + 1;

        if (snitchChance <= 15){
            snitchCaught = true;
        }
        else{
            snitchCaught = false;
        }



        //If team1's score is greater than team2...
        if (team1Score > team2Score){
            //Output to user and remove team2
            System.out.println("The team: " + teamsArray.get(team1) + " won against team: " + teamsArray.get(team2));
            System.out.println(teamsArray.get(team1) + " | " + team1Score + ", " + teamsArray.get(team2) + " | " + team2Score);
            teamsArray.remove(team2);
        }
        //if team2's score is greater than team1...
        else if (team1Score < team2Score){
            //Output to user and remove team1
            System.out.println("The team: " + teamsArray.get(team2) + " won against team: " + teamsArray.get(team1));
            System.out.println(teamsArray.get(team1) + " | " + team1Score + ", " + teamsArray.get(team2) + " | " + team2Score);
            teamsArray.remove(team1);
        }
        //otherwise if they are equal, go into overtime
        else {
            System.out.println("Tie, going into OverTime...");
            do {
                int OTscore1 = rand.nextInt(10);
                int OTscore2 = rand.nextInt(10);

                team1Score = team1Score + OTscore1;
                team1Score = team1Score + OTscore2;

                if (team1Score > team2Score){
                    System.out.println("The team: " + teamsArray.get(team2) + " won against team: " + teamsArray.get(team1));
                    System.out.println(teamsArray.get(team1) + " | " + team1Score + ", " + teamsArray.get(team2) + " | " + team2Score);
                    teamsArray.remove(team2);
                    break;
                }
                else if (team1Score < team2Score){
                    System.out.println("The team: " + teamsArray.get(team2) + " won against team: " + teamsArray.get(team1));
                    System.out.println(teamsArray.get(team1) + " | " + team1Score + ", " + teamsArray.get(team2) + " | " + team2Score);                    teamsArray.remove(team1);
                    break;
                }
            }
            while (true);
        }

    }
}
