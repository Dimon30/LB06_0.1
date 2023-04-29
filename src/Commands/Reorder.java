package Commands;

import Organization.Organization;
import java.util.Comparator;
import java.util.Vector;

/**
 * Class for working with command: reorder
 */
public class Reorder extends Command{
    private static final String name = "reorder";
    private final static String description = ": Reverse sort collection;";

    /**
     * @return name of command
     */
    public static String getName(){return name;}
    /**
     * @return description of command
     */
    public static String getDescription(){return description;}

    /**
     * Function to reorder collection
     */
    public static void reorder(){
        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        org = org
                .stream()
                .sorted(Comparator.comparing(Organization::getName).reversed())
                .collect(Vector<Organization>::new, Vector<Organization>::add,Vector<Organization>::addAll);
    }
}
