package Commands;

/**
 * Class for actions with command: exit
 */
public class Exit extends Command{
    private static final String name = "exit";
    private static final String description = ": exit;";

    /**
     * Function to abort program
     */
    public static void exit(){

        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        System.exit(30);
    }

    /**
     * @return name of command
     */
    public static String getName(){return name;}
    /**
     * @return description of command
     */
    public static String getDescription(){return description;}
}
