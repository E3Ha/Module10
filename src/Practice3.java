import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;

public class Practice3 {
    public static void main(String[] args) {

        ArrayList<String> NFLTeams = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int count = 0;
        String team = "";

        //Create a loop to populate array list
        do{
            team = SafeInput.getNonZeroLenString(scan, "Team Name ");
            NFLTeams.add(team);
            count++;
        }
        while(count != 8);

        //Print list
        System.out.println();
        for(int i = 0; i < NFLTeams.size();i++) {
            System.out.print(i+1+".");
            System.out.println(NFLTeams.get(i));
        }

        //Shuffle Array List
        Collections.shuffle(NFLTeams);

        //Round 1
        SafeInput.prettyHeader("Round 1:");
        //1 plays 8
        playGame(rand, 0, 7, NFLTeams);
        //2 plays 7
        playGame(rand, 1, 6, NFLTeams);
        //3 plays 6
        playGame(rand, 2, 5, NFLTeams);
        //4 plays 5
        playGame(rand, 3, 4, NFLTeams);

        //Round 2
        SafeInput.prettyHeader("Round 2:");
        //1 plays 4
        playGame(rand, 0, 3, NFLTeams);
        //2 plays 3
        playGame(rand, 1, 2, NFLTeams);

        //Round 3
        SafeInput.prettyHeader("Championship");
        //1 plays 2
        playGame(rand, 0, 1, NFLTeams);

        System.out.println("The " + NFLTeams.get(0) + " are the winners!");

    }
    public static void playGame(Random rand, int team1, int team2, ArrayList<String> teamsArray){
        System.out.println();
        System.out.println(teamsArray.get(team1) + " vs " + teamsArray.get(team2));

        int team1Score = rand.nextInt(60) + 60;
        int team2Score = rand.nextInt(60) + 60;

        if (team1Score > team2Score){
            teamsArray.remove(team2);
            System.out.println("The team: " + teamsArray.get(team1) + " won against team: " + teamsArray.get(team2));
        }
        else if (team1Score < team2Score){
            teamsArray.remove(team1);
            System.out.println("The team: " + teamsArray.get(team2) + " won against team: " + teamsArray.get(team1));
        }
        else {
            System.out.println("Tie, going into OverTime...");
            do {
                int OTscore1 = rand.nextInt(10);
                int OTscore2 = rand.nextInt(10);

                team1Score = team1Score + OTscore1;
                team1Score = team1Score + OTscore2;

                if (team1Score > team2Score){
                    teamsArray.remove(team2);
                    break;
                }
                else if (team1Score < team2Score){
                    teamsArray.remove(team1);
                    break;
                }
            }
            while (true);
        }

    }
}
