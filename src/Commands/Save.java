package Commands;

import Auxiliary.Write_XML;
import Organization.Organization;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Vector;

public class Save extends Command{
    private static final String name = "save";
    private final static String description = ": Save collection in file;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}
    public static void save(){
        if (arg.length == 0) {
            System.out.println("Please input filename in format: 'save filename'\n");
            return;
        }
        try {
            String[] a = arg[0].split("\\.");
            String filename = arg[0].contains(".") ? a[0] : arg[0];
            Write_XML.Write(org, filename + ".xml");
            System.out.println("File was successfully written");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
