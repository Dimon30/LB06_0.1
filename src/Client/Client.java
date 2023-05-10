package Client;

import Commands.*;
import Organization.Organization;
import Server.Server;

import java.util.*;

/**
 * Class for work with client app
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
    private void loop(Scanner scan) {
        while (true) {

            /* Reading command from console */
            System.out.print("Input command: ");
            if (!scan.hasNext()) {break;}

            String command_arg = scan.nextLine();
            try {
                if(!isCommand(command_arg)) {
                    System.out.println("I don't understand you\nWhat does it mean" + command_arg);
                    continue;
                }

                Object command = Command.make_command(command_arg);
                /** TODO
                 * Только команда должна быть сериализованна и передаваться через протокол TCP
                 */
                Server server = new Server();
                memorize(command_arg);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Something wrong with command(class: Client)");
            }
        }
        scan.close();
    }

    /**
     * Function to check validation of command which input user
     * @param command_arg command + argument which user input in console
     * @return command is in stack of commands
     */
    private boolean isCommand(String command_arg) {

        return false;
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
