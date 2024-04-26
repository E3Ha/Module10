import java.util.ArrayList;
import java.util.Scanner;
public class NoteAssignment {
    public static void main(String[] args) {

        //Create ArrayList
        ArrayList<String> favThings = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        //Add 10 favorite animals
        favThings.add("Dragon");
        favThings.add("Cat");
        favThings.add("Axolotl");
        favThings.add("Panther");
        favThings.add("Seal");
        favThings.add("Dolphin");
        favThings.add("Bird of Paradise");
        favThings.add("Raven");
        favThings.add("Red Tailed Hawk");
        favThings.add("Hare");

        //Print List
        System.out.println(favThings);
        System.out.println();
        for(int i = 0; i < favThings.size();i++) {
            System.out.print(i+1+".");
            System.out.println(favThings.get(i));
        }

        //Remove chosen item
        int remove = 0;
        remove = SafeInput.getInt(scan, "Item to remove: ");
        favThings.remove(remove);

        //Print List
        for(int i = 0; i < favThings.size();i++) {
            System.out.print(i+1+".");
            System.out.println(favThings.get(i));
        }

        //Remove chosen item
        String add = "";
        System.out.println();
        add = SafeInput.getNonZeroLenString(scan,"Item to add");
        favThings.add(add);

        //Print List
        for(int i = 0; i < favThings.size();i++) {
            System.out.print(i+1+".");
            System.out.println(favThings.get(i));
        }

        //Replace chosen item
        String replace = "";
        replace = SafeInput.getNonZeroLenString(scan,"Item to replace #5");
        favThings.set(5, replace);

        //Print List
        for(int i = 0; i < favThings.size();i++) {
            System.out.print(i+1+".");
            System.out.println(favThings.get(i));
        }

    }
}