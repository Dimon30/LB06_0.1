/* FILE NAME   : Coordinates.java
 * PROGRAMMER  : DS6
 * @author     : Sokolov Dmitry
 * LAST UPDATE : 10.03.2023
 * PURPOSE     : Coordinates Organization
 */

package Organization;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Coordinates {
    private long x; //Максимальное значение поля: 890
    private double y;

    public Coordinates(long x, double y){
        if (x >= 890)
            this.x = 890;
        this.x = x;
        this.y = y;
    }
    public Coordinates(String coord){
        //String[] split = Arrays.stream(coord.split(Pattern.quote("[,\s]\s*"))).map(String::trim).toArray(String[]::new);
        String[] split = coord.split(", ");
        try {
            this.x = Long.parseLong(split[0]);
            this.y = Double.parseDouble(split[1]);
        }catch (Exception e){
            System.out.println(coord);
            for (String s : split)
                System.out.println(s);
            System.out.println("Sorry. You input incorrect datas");
        }
    }
    public void print(){
        System.out.println(" - Coordinates 'x' = " + this.x);
        System.out.println(" - Coordinates 'y' = " + this.y);
    }

    public String getCoordinatesinXML(){
        String start = "\t\t<Coordinates>\n";
        String x = "\t\t\t<x>" + String.valueOf(this.x) + "</x>\n";
        String y = "\t\t\t<y>" + String.valueOf(this.y) + "</y>\n";
        String end = "\t\t</Coordinates>\n";
        return start + x + y + end;
    }
}