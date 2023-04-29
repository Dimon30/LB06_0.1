package Commands;

/**
 * Class for work with command: history
 */
public class History extends Command{
    private static final String name = "history";
    private final static String description = ": Show 8 last commands;";

    /**
     * @return name of command
     */
    public static String getName(){return name;}
    /**
     * @return description of command
     */
    public static String getDescription(){return description;}

    /**
     * Function print last 8 commands which user inputted
     */
    public static void history() {

        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        history.forEach(System.out::println);
    }
}
