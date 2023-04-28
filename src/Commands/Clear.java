package Commands;

import Organization.Organization;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class Clear extends Command{
    private static final String name = "clear";
    private final static String description = ": Clear collection;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}
    public static void clear(){
        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        try {
            org.clear();
            System.out.println("Now the collection is empty.\n");
        } catch (Exception e) {
            System.out.println("Error cleaning..");
        }

    }
}
