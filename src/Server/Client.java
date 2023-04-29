package Server;

import Commands.*;
import Organization.Organization;

import java.util.*;
import java.util.stream.Stream;

/**
 * Class for work with client
 */
public class Client {
    private Vector<Organization> org;
    private static Client client;
    private final Deque<String> history = new ArrayDeque<>(8);

    /**
     * Constructor class Client
     */
    public Client(Vector<Organization> org){this.org = org;}

    /**
     * Function starts work app
     */
    public void run(Client client) {
        Client.client = client;
        Scanner scanner = new Scanner(System.in);
        try{
            Help.help();
        }catch (Exception e){
            System.out.println("Problem with command help");
        }
        loop(scanner);
    }

    /**
     * Function memorise commands which inputted by user
     */
    private void memorize(final String command) {
        history.offer(command);
        if (history.size() > 8) {history.pop();}
    }

    /**
     * Loop of client commands.
     */
    public void loop(Scanner scan) {
        while (true) {
            System.out.print("Input command: ");
            if (!scan.hasNext()) {break;}

            String command_arg = scan.nextLine();
            try {
                if (Command.command(command_arg))
                    memorize(command_arg);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Something wrong with command(class: Client)");
            }
        }
        scan.close();
    }

    private final Vector<Organization> cyganskie_fokusy() {return client.org;}
    /**
     * Function give organizations
     * @return stream organizations
     */
    public static Vector<Organization> getOrganizations(){return client.cyganskie_fokusy();}
    private Deque<String> fokus(){return client.history;}

    /**
     * Function give history of command(last 8)
     * @return history
     */
    public static Deque<String> getHistory(){return client.fokus();}
}
