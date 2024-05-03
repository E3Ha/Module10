import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;

public class QuidditchTournament {

    public static void main(String[] args) {
        //Initialize Variables
        ArrayList<String> teams = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        //Add teams
        teams.add("Wyverns");
        teams.add("Drakes");
        teams.add("Occamys");
        teams.add("Nifflers");
        teams.add("Demiguises");
        teams.add("Fwoopers");
        teams.add("Erumpents");
        teams.add("Bowtruckles");

        //Shuffle Array List
        Collections.shuffle(teams);
        //Print list
        printArrayList(teams);

        //Round 1
        SafeInput.prettyHeader("Round 1:");
        //1 plays 8
        playGame(rand, 0, 7, teams);
        //2 plays 7
        playGame(rand, 1, 6, teams);
        //3 plays 6
        playGame(rand, 2, 5, teams);
        //4 plays 5
        playGame(rand, 3, 4, teams);

        //Print list
        printArrayList(teams);

        //Round 2
        SafeInput.prettyHeader("Round 2:");
        //1 plays 4
        playGame(rand, 0, 3, teams);
        //2 plays 3
        playGame(rand, 1, 2, teams);

        //Print list
        printArrayList(teams);

        //Round 3
        SafeInput.prettyHeader("Championship");
        //1 plays 2
        playGame(rand, 0, 1, teams);

        System.out.println("The " + teams.get(0) + " are the winners!");



    }
    public static void playGame(Random rand, int team1, int team2, ArrayList<String> teamsArray){
        //Output teams in match
        System.out.println();
        System.out.println(teamsArray.get(team1) + " vs " + teamsArray.get(team2));
        //Initialize scores
        int team1Score = 0;
        int team2Score = 0;
        int team1QTRScore = 0;
        int team2QTRScore = 0;

        //Determine if a team got the golden snitch - if they did they win
        int snitchChance = rand.nextInt(100) + 1;

        if (snitchChance <= 15){
            System.out.println(teamsArray.get(team1) + " has caught the Snitch! They Win!");
            teamsArray.remove(team2);
        }
        else if (snitchChance >= 75 ){
            System.out.println(teamsArray.get(team2) + " has caught the Snitch! They Win!");
            teamsArray.remove(team1);
        }
        //Otherwise, they play 4 quarters
        else {
            System.out.println("The Snitch was not caught.");
            System.out.println();
            System.out.println(teamsArray.get(team1) + " | " + teamsArray.get(team2));
            System.out.println("----------------");
            //Each team randomly scores 0-4 goals per quarter worth 10 points - Add to previous score
            for (int i = 0; i <= 4; i++){
                team1QTRScore = rand.nextInt(5) * 10;
                team2QTRScore = rand.nextInt(5) * 10;
                team1Score = team1Score + team1QTRScore;
                team2Score = team2Score + team2QTRScore;
                System.out.println("Qtr " + i + ": " + team1QTRScore + "  " + team2QTRScore);
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
                System.out.println("Tie, going into Sudden Death...");
                do {
                    int OTscore1 = rand.nextInt(5) * 10;
                    int OTscore2 = rand.nextInt(5) * 10;

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
    public static void printArrayList(ArrayList<String> array){
        System.out.println();
        System.out.println("Teams: ");
        for(int i = 0; i < array.size();i++) {
            System.out.print(i+1+".");
            System.out.println(array.get(i));
        }
    }
}
