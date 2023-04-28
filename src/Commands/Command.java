package Commands;

import Organization.Organization;
import Server.Client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Consumer;

public abstract class Command {
    protected static Vector<Organization> org = Client.getOrganizations();
    protected static Scanner scan = new Scanner(System.in);
    protected static String[] arg = new String[0];
    protected static Iterable<String> history = Client.getHistory();
    private static Map<String, Method> commandMap = new HashMap<String, Method>();
    static {
        try {
            commandMap.put(Help.getName(), Help.class.getMethod(Help.getName()));
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
    public static boolean command(String command_arg) throws InvocationTargetException, IllegalAccessException {
        String command = command_arg.split(" ").length > 1 ? command_arg.split(" ")[0] : command_arg;
        String[] ar = command_arg.split(" ").length > 1 ? Arrays.copyOfRange(command_arg.split(" "), 1, command_arg.split(" ").length) : new String[0];
        arg = ar;
        if (!commandMap.containsKey(command)) {
            System.out.println("-" + command + "-" + ": this command doesn't exist.");
            return false;
        }
        commandMap.get(command).invoke(null);
        return true;
    }
    public static void showOtherList(Vector<Organization> temp){
        org = temp;
        Show.show();
        org = Client.getOrganizations();
    }
}