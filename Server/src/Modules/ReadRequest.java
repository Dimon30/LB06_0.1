package Modules;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.spec.ECField;

public class ReadRequest {
    public static String readRequest(Socket socket){
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            String message = reader.readLine();
            return message;
        } catch (Exception e){
            System.out.println("Error");
        }
        return "";
    }

    public static Object readCommand(Socket socket){
        try{
            byte[] data = new byte[1024];
            DatagramPacket dt = new DatagramPacket(data, data.length);
            File file = new File("command");
            FileOutputStream outputStream = new FileOutputStream(file);
            DatagramSocket datagramSocket = new DatagramSocket(30);
            datagramSocket.setSoTimeout(60_000);

            while (true){
                datagramSocket.receive(dt);
                outputStream.write(data);
                outputStream.flush();
            }
        }catch (SocketTimeoutException e){
            System.out.println("Time out");
        }catch (Exception e){
            SendResponse.sendResponse(socket, "I can't read packet");
        }
        System.out.println("Packet accepted");
        Object obj = null;
        System.out.println("Her");
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("command"));
            obj = inputStream.readObject();
            System.out.println("Im here");
        } catch (Exception e){
            SendResponse.sendResponse(socket, "Error deserializing object");
        }
        return obj;
    }
}
