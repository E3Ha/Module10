import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Practice3 {
    public static void main(String[] args) {

        ArrayList<String> NFLTeams = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean continueYN = false;
        String team = "";

        //Create a loop to populate array list
        do{
            team = SafeInput.getNonZeroLenString(scan, "Last Name ");
            NFLTeams.add(team);
            continueYN = SafeInput.getYNConfirm(scan, "Exit? ");
        }
        while(!continueYN);

        //Print list
        System.out.println();
        for(int i = 0; i < NFLTeams.size();i++) {
            System.out.print(i+1+".");
            System.out.println(NFLTeams.get(i));
        }







    }
    public static void shuffle(Scanner scan) {


        //while (myArray[i] <= 28){
        //myArray[i] = rand.nextInt(7)+1;
        //}
    }
}
