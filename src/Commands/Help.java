package Commands;

public class Help extends Command{

    private static final String name = "help";
    private static final String description = ": Output all commands;";

    public static void help(){
        if (arg.length > 0){
            System.out.println("I don't understand u\n What does it mean: " + getName() + " " + arg[0]);
            return;
        }
        System.out.println("-" + getName() + getDescription());
        System.out.println("-" + Info.getName() + Info.getDescription());
        System.out.println("-" + Show.getName() + Show.getDescription());
        System.out.println("-" + Add.getName() + Add.getDescription());
        System.out.println("-" + Update.getName() + Update.getDescription());
        System.out.println("-" + Remove.getName() + Remove.getDescription());
        System.out.println("-" + Clear.getName() + Clear.getDescription());
        System.out.println("-" + Save.getName() + Save.getDescription());
        System.out.println("-" + Execute_script.getName() + Execute_script.getDescription());
        System.out.println("-" + Exit.getName() + Exit.getDescription());
        System.out.println("-" + Reorder.getName() + Reorder.getDescription());
        System.out.println("-" + Sort.getName() + Sort.getDescription());
        System.out.println("-" + History.getName() + History.getDescription());
        System.out.println("-" + FilterByTypeAsc.getName() + FilterByTypeAsc.getDescription());
        System.out.println("-" + PrintByAddressAscending.getName() + PrintByAddressAscending.getDescription());
        System.out.println("-" + PrintByAddressDescending.getName() + PrintByAddressDescending.getDescription());
    }


    public static String getName(){return name;}
    public static String getDescription(){return description;}

    //public static void help(Object o) {}
}
