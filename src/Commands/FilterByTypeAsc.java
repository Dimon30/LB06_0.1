package Commands;

import Auxiliary.FilterOrganizations;
import Organization.Organization;

import java.util.Vector;

public class FilterByTypeAsc extends Command{
    private static final String name = "filter_greater_than_type";
    private final static String description = ": show organizations with type > than given value;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void filter_greater_than_type() {
        try {
            if (arg.length == 0) {
                System.out.println("Please input type in format: filter_greater_than_type 'type'\n");
                return;
            }
            String type = arg[0];
            Vector<Organization> result = FilterOrganizations.filterByType(org, type);
            Command.showOtherList(result);
        } catch (Exception e){
            System.out.println("You input incorrect datas");
        }
    }
}
