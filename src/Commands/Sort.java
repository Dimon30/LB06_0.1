package Commands;

import Auxiliary.SortOrganizaton;
import Organization.Organization;

import java.util.Vector;

public class Sort extends Command{
    private static final String name = "sort";
    private final static String description = ": Sort collection;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}
    public static void sort(){
        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        SortOrganizaton.sort(org);}
}