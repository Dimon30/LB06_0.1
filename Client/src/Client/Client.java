package Client;

import Commands.Command;
import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try(Socket socket = new Socket(InetAddress.getLocalHost(), 30)) {

            String filename = "src/Organizations.xml";
            if (args.length != 0)
                filename = args[0];
            sendRequest(socket, filename);
            run(socket);

            String message = getResponse(socket);
            System.out.println("Message received: " + message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Function starts work app
     */
    public static void run(Socket socket) {
        Scanner scanner = new Scanner(System.in);
        try{
            //Help.help();
        }catch (Exception e){
            System.out.println("Problem with command help");
        }
        loop(socket, scanner);
    }

    /**
     * Loop of client commands.
     */
    private static void loop(Socket socket, Scanner scan) {
        while (true) {
            //System.out.println(getResponse(socket));

            /* Reading command from console */
            System.out.print("Input command: ");
            if (!scan.hasNext()) {break;}

            String command_arg = scan.nextLine();
            try {
                boolean command = Command.sendCommand(command_arg);
                if (!command)
                    System.out.println("-" + command_arg + "-" + ": this command doesn't exist.");
                System.out.println(getResponse(socket));
                //sendRequest(socket, command);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Something wrong with command(class: Client)");
            }
        }
        scan.close();
    }

    private static String getResponse(Socket socket){
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            return reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void sendRequest(Socket socket, String request){
        try{
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            printWriter.println(request);
            printWriter.flush();
        } catch (Exception e){
            System.out.println("Request hadn't sent");
        }
    }
    private static void sendRequest(Socket socket, Object request){
        try{
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(request);
            //printWriter.flush();
        } catch (Exception e){
        }
    }
}
