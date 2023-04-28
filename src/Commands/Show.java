package Commands;

import Organization.Organization;

import java.util.Vector;

public class Show extends Command{
    private static final String name = "show";
    private final static String description = ": Show all organizations in collection;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void show(){
        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        if (org.size() == 0) {
            System.out.println("Collection is empty");
            return;
        }
        System.out.println();
        for (Organization t : org){
            System.out.println("Organization #" + (int)(org.indexOf(t) + 1) + ":");
            t.print();
            System.out.println("-----------------------");
        }
    }
}
