package Commands;

public class Exit extends Command{
    private static final String name = "exit";
    private static final String description = ": exit;";

    public static void exit(){

        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        System.exit(30);
    }

    public static String getDescription() {return description;}

    public static String getName() {return name;}
}
