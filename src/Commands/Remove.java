package Commands;

import Organization.Organization;

import java.util.Vector;

import static java.lang.Integer.parseInt;

/**
 * Class to working with command: remove_by_id
 */
public class Remove extends Command{
    private static final String name = "remove_by_id";
    private final static String description = ": Remove organization by id;";

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
     * Function to delete organization by id
     */
    public static void remove_by_id(){
        if (arg.length == 0) {
            System.out.println("Please input command in format: remove_by_id 'id'");
            return;
        }
        try {
            Integer id = arg.length > 0 ? parseInt(arg[0]) : -1;
            org = org.stream().filter(o  -> o.getId() != id).collect(Vector<Organization>::new, Vector<Organization>::add,Vector<Organization>::addAll);
            System.out.println("Organization by id '" + arg[0] + "' was successfully deleted");
        } catch (Exception e) {
            System.out.println("Sorry...\nDon't find organization by this id(");
        }
    }
}
