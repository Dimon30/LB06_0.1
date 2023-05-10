package Commands;

import Organization.Organization;
import java.util.Comparator;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * Class for working with command: print_field_ascending_postal_address
 */
public class PrintByAddressAscending extends Command{
    private static final String name = "print_field_ascending_postal_address";
    private final static String description = ": Print field ascending postal address;";

    /**
     * Function to get name of command
     * @return name of command
     */
    public static String getName(){return name;}
    /**
     * Function to get description of command
     * @return description of command
     */
    public static String getDescription(){return description;}

    /**
     * Function to print organizations by ascending postal address
     */
    public static void print_field_ascending_postal_address(){
        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        Vector<Organization> result = org.stream()
                .sorted(Comparator.comparing(Organization::getAddress))
                .collect(Vector<Organization>::new, Vector<Organization>::add,Vector<Organization>::addAll);
        Command.showOtherList(result);
    }
}
