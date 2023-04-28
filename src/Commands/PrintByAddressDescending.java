package Commands;

import Auxiliary.SortOrganizaton;
import Organization.Organization;

import java.util.Vector;

public class PrintByAddressDescending extends Command{
    private static final String name = "print_field_descending_postal_address";
    private final static String description = ": Print field descending postal address;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void print_field_descending_postal_address(){
        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        Vector<Organization> result = SortOrganizaton.revSortByAddress(org);
        Command.showOtherList(result);
    }
}
