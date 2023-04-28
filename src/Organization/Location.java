/* FILE NAME   : Location.java
 * PROGRAMMER  : DS6
 * @author     : Sokolov Dmitry
 * LAST UPDATE : 13.03.2023
 * PURPOSE     : Location Organization
 */

package Organization;

public class Location {
    private int x;
    private long y;
    private String town; //Поле не может быть null
    public Location(int x, long y, String town){
        this.x = x;
        this.y = y;
        this.town = town;
    }

    public Location(String postalAddress) {
        if (postalAddress.contains(", "))
        {
            try {
                if (!postalAddress.split(", ")[2].equals("-"))
                    this.x = Integer.parseInt(postalAddress.split(", ")[2]);
                if (!postalAddress.split(", ")[2].equals("- "))
                    this.x = Integer.parseInt(postalAddress.split(", ")[2]);
                if (!postalAddress.split(", ")[3].equals("-"))
                    this.y = Long.parseLong(postalAddress.split(", ")[3]);
                if (!postalAddress.split(", ")[3].equals("- "))
                    this.y = Long.parseLong(postalAddress.split(", ")[3]);
                if (!postalAddress.split(", ")[4].equals("-"))
                    this.town = postalAddress.split(", ")[4];
                if (!postalAddress.split(", ")[4].equals("- "))
                    this.town = postalAddress.split(", ")[4];
            } catch (IndexOutOfBoundsException e){
                System.out.println("Incorrect data");
            }
        }
    }

    public void print(){
        System.out.println(" - Location 'x' = " + this.x);
        System.out.println(" - Location 'y' = " + this.y);
        System.out.println(" - Town = " + this.town);
    }
    public String getLocationinXML(){
        String start = "\t\t\t<Location>\n";
        String x = "\t\t\t\t<x>" +  String.valueOf(this.x) + "</x>\n";
        String y = "\t\t\t\t<y>" +  String.valueOf(this.y) + "</y>\n";
        String town = "\t\t\t\t<town>" +  String.valueOf(this.town) + "</town>\n";
        String end = "\t\t\t</Location>\n";
        return start + x + y + town + end;
    }

    public String getTown() {
        return town;
    }
}