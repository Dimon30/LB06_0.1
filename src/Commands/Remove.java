package Commands;

import Organization.Organization;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.Integer.parseInt;

public class Remove extends Command{
    private static final String name = "remove_by_id";
    private final static String description = ": Remove organization by id;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}
    public static void remove_by_id(){
        if (arg.length == 0)
        {
            System.out.println("Please input command in format: remove_by_id 'id'");
            return;
        }
        try {
            Integer id = arg.length > 0 ? parseInt(arg[0]) : -1;
            final Organization t = org.stream().filter(o -> o.getId() == id).findFirst().orElseThrow();
            org.remove(t);
            System.out.println("Organization by id '" + arg[0] + "' was successfully deleted");
        } catch (Exception e) {
            System.out.println("Sorry...\nDon't find organization by this id(");
        }
    }
}
