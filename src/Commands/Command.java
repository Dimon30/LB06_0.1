package Commands;

import Organization.Organization;
import Client.Client;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Class for describe commands in app
 */
public class Command implements Serializable {
    protected static Vector<Organization> org = Client.getOrganizations();
    protected static Scanner scan = new Scanner(System.in);
    protected static String[] arg = new String[0];
    protected static Iterable<String> history = Client.getHistory();
    private static Map<String, Object> commandMap = new HashMap<String, Object>();

    private Command(String command, String[] arg){

    }
    static {
        try {
            commandMap.put(Info.getName(), Info.class.getMethod(Info.getName()));
            commandMap.put(Show.getName(), Show.class.getMethod(Show.getName()));
            commandMap.put(Add.getName(), Add.class.getMethod(Add.getName()));
            commandMap.put(Update.getName(), Update.class.getMethod(Update.getName()));
            commandMap.put(Remove.getName(), Remove.class.getMethod(Remove.getName()));
            commandMap.put(Clear.getName(), Clear.class.getMethod(Clear.getName()));
            commandMap.put(Save.getName(), Save.class.getMethod(Save.getName()));
            commandMap.put(Execute_script.getName(), Execute_script.class.getMethod(Execute_script.getName()));
            commandMap.put(Exit.getName(), Exit.class.getMethod(Exit.getName()));
            commandMap.put(Reorder.getName(), Reorder.class.getMethod(Reorder.getName()));
            commandMap.put(Sort.getName(), Sort.class.getMethod(Sort.getName()));
            commandMap.put(History.getName(), History.class.getMethod(History.getName()));
            commandMap.put(FilterByTypeAsc.getName(), FilterByTypeAsc.class.getMethod(FilterByTypeAsc.getName()));
            commandMap.put(PrintByAddressAscending.getName(), PrintByAddressAscending.class.getMethod(PrintByAddressAscending.getName()));
            commandMap.put(PrintByAddressDescending.getName(), PrintByAddressDescending.class.getMethod(PrintByAddressDescending.getName()));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object make_command(String command_arg){
        String[] split = command_arg.split("\s*");
        String command = split.length > 1 ? split[0] : command_arg;
        String[] arg = split.length > 1 ? Arrays.copyOfRange(split, 1, split.length) : new String[0];

        commandMap.put(Help.getName(), new Help(command_arg));
        if (!commandMap.containsKey(command)) {
            System.out.println("-" + command + "-" + ": this command doesn't exist.");
            return null;
        }
        // Возвращает команду (потчи в сериализованном виде)
        Command com = new Command(command, arg);
        return com;
    }

    /**
     * Function to process commands
     * @param command_arg command and argument in form string
     * @return boolean command's processed or not
     */
    public static boolean command(String command_arg) {
        try {
            String command = command_arg.split(" ").length > 1 ? command_arg.split(" ")[0] : command_arg;
            String[] ar = command_arg.split(" ").length > 1 ? Arrays.copyOfRange(command_arg.split(" "), 1, command_arg.split(" ").length) : new String[0];
            arg = ar;
            if (!commandMap.containsKey(command)) {
                System.out.println("-" + command + "-" + ": this command doesn't exist.");
                return false;
            }
            //commandMap.get(command).invoke(null);
            return true;
        } catch (Exception e){
            System.out.println("Command's not accepted(class: Command)");
        }
        return false;
    }

    /**
     * Function to show collection with other order
     * @param temp temporary collection
     */
    public static void showOtherList(Vector<Organization> temp){
        org = temp;
        Show.show();
        org = Client.getOrganizations();
    }

}