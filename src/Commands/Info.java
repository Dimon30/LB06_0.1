package Commands;

import Organization.Organization;

/**
 * Class for work with command: info
 */
public class Info extends Command{
    private static final String name = "info";
    private static final String description = ": About collection";

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
     * Function print information about collection
     */
    public static void info() {

        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        Organization date = (Organization)(org.stream().findFirst().orElseThrow());
        int size = (int)org.stream().count();
        System.out.println("Date of initialization collection: " + date.getLastUpdate());
        System.out.println("Size of collection: " + Integer.valueOf(size));
    }
}
