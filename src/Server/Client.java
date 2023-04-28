package Server;

import Commands.*;
import Organization.Organization;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Client {
    private Vector<Organization> org;
    private static Client client;
    private final Deque<String> history = new ArrayDeque<>(8);
    public Client(Vector<Organization> org){this.org = org;}
    public void run(Client client) {
        this.client = client;
        Scanner scanner = new Scanner(System.in);
        //Show.show();
        try{
            Help.help();
        }catch (Exception e){
            System.out.println("Problem with command help");
        }
        //System.out.print("Input command: ");
        loop(scanner);
    }

    private void memorize(final String command) {
        history.offer(command);

        if (history.size() > 8) {
            history.pop();
        }
    }

    /**
     * Loop of client commands.
     */
    public void loop(Scanner scan) {
        while (true) {
            System.out.print("Input command: ");

            if (!scan.hasNext()) {
                break;
            }

            String command_arg = scan.nextLine();
/*
            switch (command) {
                case "help" -> Help.help();
                case "info" -> Info.info(this.org);
                case "show" -> Show.show(this.org);
                case "add" -> Add.add(scan, this.org);
                case "update" -> Update.update(scan, this.org);
                case "remove" -> Remove.remove(scan, this.org);
                case "clear" -> {
                    Clear.clear(org);
                    System.out.println("Now the collection is empty.\n");
                }
                case "save" -> {
                    System.out.print("Input filename: ");
                    String outfile = scan.nextLine();
                    Save.save(outfile, org);
                }
                case "execute_script" -> Execute_script.execute_script(arg[0], org);
                case "exit" -> Exit.exit();
                case "reorder" -> Reorder.reorder(org);
                case "sort" -> Sort.sort(org);
                case "history" -> History.history(history);
                case "filter_greater_than_type" -> {System.out.print("Input type: ");FilterByTypeAsc.filter_greater_than_type(org, scan.nextLine());}
                case "print_field_ascending_postal_address" -> PrintByAddressAscending.printByAddressAscending(org);
                case "print_field_descending_postal_address" -> PrintByAddressDescending.printByAddressDescending(org);
                default -> {
                    System.out.println(command + ": this command doesn't exist.");
                    continue;
                }
            }*/
            try {
                if (Command.command(command_arg))
                    memorize(command_arg);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        scan.close();
    }

    private final Vector<Organization> cyganskie_fokusy() {return this.client.org;}
    public static Vector<Organization> getOrganizations(){return client.cyganskie_fokusy();}
    private Deque<String> fokus(){return this.client.history;}
    public static Deque<String> getHistory(){return client.fokus();}
}
