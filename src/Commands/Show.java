package Commands;
public class Show extends Command{
    private static final String name = "show";
    private final static String description = ": Show all organizations in collection;";

    /**
     * @return name of command
     */
    public static String getName(){return name;}
    /**
     * @return description of command
     */
    public static String getDescription(){return description;}

    public static void show() {
        if (arg.length > 0) {
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        if (org.stream().count() == 0) {
            System.out.println("Collection is empty");
            return;
        }
        System.out.println();
        final Integer[] i = {1};
        try{
        org.forEach(o -> {
            System.out.println("Organization #" + i[0] + ":");
            i[0] += 1;
            o.print();
            System.out.println("-----------------------");
        });
        } catch(Exception e) {
            System.out.println("hui");
            e.printStackTrace();
        }

    }
}
