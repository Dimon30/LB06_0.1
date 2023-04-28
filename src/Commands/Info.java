package Commands;

import Organization.Organization;
import Server.Client;

import java.util.Vector;

public class Info extends Command{
    private static final String name = "info";
    private static final String description = ": About collection";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void info() {
        /*
        * Date of initialization
        * Size
        * ...
        */

        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        String dateInitialization = org.get(0).getLastUpdate();
        int size = org.size();
        System.out.println("Date of initialization collection: " + dateInitialization);
        System.out.println("Size of collection: " + Integer.valueOf(size));
    }
}
