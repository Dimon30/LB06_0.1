package Commands;

import Organization.Organization;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class for actions with command: clear
 */
public class Clear extends Command{
    private static final String name = "clear";
    private final static String description = ": Clear collection;";

    /**
     * @return name of command
     */
    public static String getName(){return name;}
    /**
     * @return description of command
     */
    public static String getDescription(){return description;}

    /**
     * Function clear collection
     */
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
