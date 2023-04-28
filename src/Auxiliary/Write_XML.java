package Auxiliary;

import Organization.Organization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class Write_XML {
    public static void Write(Vector<Organization> vec, String filename){
        try {
            FileOutputStream file = new FileOutputStream(filename);
            file.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<Organizations>\n".getBytes());
            for (Organization org : vec)
                file.write(org.getXML().getBytes());
            file.write("</Organizations>".getBytes());
            file.close();
        } catch (FileNotFoundException e) {
            //System.out.println("i dont find file");
            throw new RuntimeException(e);
        } catch (IOException e) {
            //System.out.println("kal");
            throw new RuntimeException(e);
        }
    }
}
