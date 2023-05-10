package Modules;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SendResponse {
    public static void sendResponse(Socket socket, String response){
        try{
            PrintWriter printWriter = new PrintWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()
                    )
            );
            printWriter.println(response);
            printWriter.flush();
            //System.out.println("Message successful send");
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
