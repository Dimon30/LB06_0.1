package Commands;

import Organization.Organization;

import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterByTypeAsc extends Command{
    private static final String name = "filter_greater_than_type";
    private final static String description = ": show organizations with type > than given value;";

    /**
     * @return name of command
     */
    public static String getName(){return name;}
    /**
     * @return description of command
     */
    public static String getDescription(){return description;}

    /**
     * Function print organizations which have type greater than given
     */
    public static void filter_greater_than_type() {
        try {
            if (arg.length == 0) {
                System.out.println("Please input type in format: filter_greater_than_type 'type'\n");
                return;
            }
            String type = arg[0];
            Vector<Organization> result = org.stream().filter(o -> o.equals(type)).collect(Vector<Organization>::new, Vector<Organization>::add,Vector<Organization>::addAll);
            Command.showOtherList(result);
        } catch (Exception e){
            System.out.println("You input incorrect datas");
        }
    }
}
