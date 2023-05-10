package Commands;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Command implements Serializable {
    private String name = "239";
    private String[] arg;
    private Object command;
    private static Map<String, Object> commandMap = new HashMap<String, Object>();
    static {commandMap.put("testCommand", new TestCommand());}


    public static boolean sendCommand(String command_arg){
        String[] split = command_arg.split("\s");
        String command = split.length > 1 ? split[0] : command_arg;
        String[] arg = split.length > 1 ? Arrays.copyOfRange(split, 1, split.length) : new String[0];
        String filename = "command";
        DatagramPacket dt;

        if(!commandMap.containsKey(command))
            return false;

        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
            output.writeObject(commandMap.get(command));
            File file = new File(filename);
            FileInputStream inputStream = new FileInputStream(file);
            byte[] data = new byte[1024];
            DatagramSocket datagramSocket = new DatagramSocket();
            while (inputStream.read(data) != -1){
                dt = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 30);
                datagramSocket.send(dt);
            }
            System.out.println("Command successfully send");
        }catch (IOException e){
            System.out.println(e);
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error sending command");
        }
        return true;
    }

    public Object getCommand(String command){
        return commandMap.get(command);
    }

    public String getName() {
        return this.name;
    }
}
