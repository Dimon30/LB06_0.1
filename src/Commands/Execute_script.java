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

public class Execute_script extends Command{
    private static final String name = "execute_script";
    private final static String description = ": Load commands from file;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

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
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
