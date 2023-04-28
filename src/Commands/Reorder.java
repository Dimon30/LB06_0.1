package Commands;

import Organization.Organization;

import java.util.Vector;

import static Auxiliary.SortOrganizaton.revSortByName;

public class Reorder extends Command{
    private static final String name = "reorder";
    private final static String description = ": Reverse sort collection;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void reorder(){
        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        revSortByName(org);}
}
