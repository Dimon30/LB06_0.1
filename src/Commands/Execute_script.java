package Commands;

import Auxiliary.Write_XML;
import Organization.Organization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Class for actions with command: execute_script
 */
public class Execute_script extends Command{
    private static final String name = "execute_script";
    private final static String description = ": Load commands from file;";

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
     * Function take file and execute commands
     */
    public static void execute_script(){
        if (arg.length == 0) {
            System.out.println("Please input filename in format: 'execute_script filename'\n");
            return;
        }
        String filename = arg[0];
        File file = new File(filename);
        String str = "";
        String[] lines;
        try (Scanner reader = new Scanner(new FileReader(file.getAbsolutePath()))) {
            while (reader.hasNext()) {
                str += reader.next() + "\n";
            }
            lines = str.split("\n");
            for (String command_arg : lines) {
                System.out.println("'" + command_arg + "'");
                Command.command(command_arg);
            }
        } catch (FileNotFoundException e){
            System.out.println("Sorry, I don't find this file: '" + filename + "'");
        } catch (Exception e) {
            System.out.println("Something is going wrong(class: Execute_script)");
        }
    }
}
