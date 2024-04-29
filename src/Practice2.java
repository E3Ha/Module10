import java.util.ArrayList;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {

        ArrayList<Double> doubles = new ArrayList<Double>();
        Scanner scan = new Scanner(System.in);
        double addDub = 0;
        boolean continueYN = false;
        double average = 0;
        double sum = 0;

        //Create a loop to populate array list
        do{
            addDub = SafeInput.getDouble(scan, "Double: ");
            doubles.add(addDub);
            continueYN = SafeInput.getYNConfirm(scan, "Exit? ");
        }
        while(!continueYN);

        //Print list
        for(int i = 0; i < doubles.size();i++) {
            System.out.print(i+1+".");
            System.out.println(doubles.get(i));
        }
        //Calculate Average
        for(int i = 0; i < doubles.size();i++) {
            sum = sum + doubles.get(i);
        }
        average = sum / doubles.size();

        System.out.println(average + " (Average) = " + sum + " (Sum) / " + doubles.size() + " (Length)");





    }
}
