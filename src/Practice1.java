import java.util.ArrayList;
import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {

        ArrayList<String> lastNames = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);

        boolean continueYN = false;
        String name = "";
        //create a loop to populate array list
        do{
            name = SafeInput.getNonZeroLenString(scan, "Last Name ");
            lastNames.add(name);
            continueYN = SafeInput.getYNConfirm(scan, "Exit? ");
        }
        while(!continueYN);


        for(int i = 0; i < lastNames.size();i++) {
            System.out.print(i+1+".");
            System.out.println(lastNames.get(i));
        }

        for(int i = 0; i < lastNames.size();i++) {
            if (lastNames.size() > 6 ) {
                lastNames.remove(i);
            }
        }
      System.out.println();
        for(int i = 0; i < lastNames.size();i++) {
            System.out.print(i+1+".");
            System.out.println(lastNames.get(i));
        }

    }

}
