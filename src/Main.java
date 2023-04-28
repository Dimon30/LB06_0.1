/* FILE NAME   : Main.java
 * PROGRAMMER  : DS6
 * @author     : Sokolov Dmitry
 * LAST UPDATE : 14.03.2023
 * PURPOSE     : Main file
 */

import java.io.*;
import java.util.*;

import Auxiliary.Read_XML;
import Auxiliary.Write_XML;
import Organization.*;
import Server.Client;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		String filename = "src/Organizations.xml";
		if (args.length != 0)
			filename = args[0];
		String fileOut = "OutOrganizations.xml";
		Vector<Organization> Organizations = Read_XML.CreateVector(filename);
		Client client = new Client(Organizations);

		client.run(client);
		Write_XML.Write(Organizations, fileOut);
    }
}
