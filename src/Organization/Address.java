/* FILE NAME   : Address.java
 * PROGRAMMER  : DS6
 * @author     : Sokolov Dmitry
 * LAST UPDATE : 13.03.2023
 * PURPOSE     : Address Organization
 */

package Organization;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Address
{
    private String street; //Строка не может быть пустой, Поле может быть null
    private String zipCode; //Поле не может быть null
    private Location town; //Поле может быть null

    public Address(String zipCode, String street, Location town){
        this.zipCode = zipCode;
        this.street = street;
        this.town = town;
    }

    public Address(String postalAddress, Address old) {
        if (postalAddress.contains(", "))
        {
            try {
                //String[] split = Arrays.stream(postalAddress.split(Pattern.quote("[,\s]\s*"))).map(String::trim).toArray(String[]::new);
                String[] split = postalAddress.split(", ");
                if (split[0].equals("-"))
                    this.zipCode = old.getZipCode();
                if (split[1].equals("-"))
                    this.street = old.getStreet();
                else
                    this.street = split[1];
                if (split[2].equals("-"))
                    this.town = old.getTown();
                else
                    this.town = new Location(postalAddress);
            } catch (IndexOutOfBoundsException e){
                System.out.println("Incorrect data");
            }
        }
    }

    private Location getTown() {
        return this.town;
    }

    private String getStreet() {
        return this.street;
    }

    private String getZipCode() {
        return this.zipCode;
    }

    public void print(){
        System.out.println(" - ZipCode = " + this.zipCode);
        System.out.println(" - Street = " + this.street);
        town.print();
    }
    public String getAddressinXML(){
        String start = "\t\t<postalAddress>\n";
        String zipCode = "\t\t\t<zipCode>" + this.zipCode + "</zipCode>\n";
        String street = "\t\t\t<street>" + this.street + "</street>\n";
        String location = town.getLocationinXML();
        String end = "\t\t</postalAddress>\n";
        return start + zipCode + street + location + end;
    }

    public String getAddress() {
        return getZipCode() + ", " + getStreet() + ", " + this.town.getTown();
    }
}