package Commands;

import Auxiliary.Write_XML;

/**
 * Class for working with command: save
 */
public class Save extends Command{
    private static final String name = "save";
    private final static String description = ": Save collection in file;";

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
     * Function to save collection in file xml
     */
    public static void save(){
        if (arg.length == 0) {
            System.out.println("Please input filename in format: 'save filename'\n");
            return;
        }
        try {
            String[] a = arg[0].split("\\.");
            String filename = arg[0].contains(".") ? a[0] : arg[0];
            Write_XML.Write(org.stream(), filename + ".xml");
            System.out.println("File was successfully written");
        } catch (Exception e){
            System.out.println("File's not written");
        }
    }
}
