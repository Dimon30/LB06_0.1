package Server;

import Auxiliary.Read_XML;
import Commands.*;
import Modules.*;
import Organization.Organization;

import javax.xml.stream.events.Comment;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * Class for work with server app
 */
public class Server {

    public static void main(String[] args){
        // Message about start work server
        System.out.println("Server is working...");

        try (ServerSocket server = new ServerSocket(30)) {
            while(true){
                Socket socket = server.accept();
                String filename = ReadRequest.readRequest(socket);
                Vector<Organization> Organizations = Read_XML.CreateVector(socket, filename);
                TestCommand o = (TestCommand) ReadRequest.readCommand(socket);
                System.out.println(o);
                if (o == null)
                    System.out.println("Object is null");
                else
                    System.out.println(o.getName());

                //SendResponse.sendResponse(socket, "CGSG forever!!!");
            }
        } catch (Exception e){
            System.out.println("Error...");
        }
        System.out.println("Server is closed");

    }
    public static void run(Object obj){}
}
