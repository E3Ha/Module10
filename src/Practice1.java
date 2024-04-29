import java.util.ArrayList;
import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {

        ArrayList<String> lastNames = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        boolean continueYN = false;
        String name = "";

        //Create a loop to populate array list
        do{
            name = SafeInput.getNonZeroLenString(scan, "Last Name ");
            lastNames.add(name);
            continueYN = SafeInput.getYNConfirm(scan, "Exit? ");
        }
        while(!continueYN);

        //Print list
        System.out.println();
        for(int i = 0; i < lastNames.size();i++) {
            System.out.print(i+1+".");
            System.out.println(lastNames.get(i));
        }
        //Remove List Items
        for(int i = 0; i < lastNames.size();i++) {
            name = lastNames.get(i);
            if (name.length() > 6 ) {
                lastNames.remove(i);
            }
        }
        //Print list
        System.out.println();
        System.out.println("Removing all names greater than 6 characters...");
        System.out.println();
        for(int i = 0; i < lastNames.size();i++) {
            System.out.print(i+1+".");
            System.out.println(lastNames.get(i));
        }

    }

}
