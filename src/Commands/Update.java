package Commands;

import Organization.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Update extends Command{
    private static final String name = "update";
    private final static String description = ": Update value of field for organization from collection;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}
    public static void update(){
        if (arg.length == 0)
        {
            System.out.println("Please input command in format: update 'id'");
            return;
        }
        try {
            Integer id = arg.length > 0 ? parseInt(arg[0]) : -1;
            final Organization t = org.stream().filter(o -> o.getId() == id).findFirst().orElseThrow();
            System.out.println("What do u wanna change: ");
            System.out.println("0 - nothing\n1 - name\n2 - coordinates\n3 - creation date\n4 - annual turnover\n5 - type\n6 - postal address");
            System.out.print("Input value: ");
            switch (scan.next()) {
                case "0": case "nothing": case "-": break;
                case "1": case "name": case "Name": {System.out.print("Input <string> name: "); String data = scan.next(); t.setName(data); break;}
                case "2": case "coordinates": case "Coordinates": case "coordinate": case "Coordinate": {scan.nextLine(); System.out.print("Input coordinates 'x <long>, y <double>': ");
                   String data = scan.nextLine(); t.setCoordinates(data); break;}
                case "3": case "date": case "Date": case "creation date": case "creationDate": case "creation_date": {scan.nextLine(); System.out.print("Input date 'yyyy-mm-dd': ");
                    t.setCreationDate(LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay()
                    ); break;}
                case "4": case "annual turnover": case "annualTurnover": case "annualTurnOver": case "annual_turnover": case "annual_Turnover": case "annual_TurnOver": {System.out.print("Input <float> annual turnover: ");
                    scan.nextLine(); t.setAnnualTurnover(scan.nextLine()); break;}
                case "5": case "type": case "Type": {scan.nextLine(); System.out.print("Input type of organizations (commercial, public, government, trust, private_limited_company) '<string> type': ");
                    String type = scan.nextLine();
                    for(;;){
                        if (OrganizationType.findTypebyName(type) == null)
                        {
                            System.out.print("Input type of organizations (commercial, public, government, trust, private_limited_company) '<string> type': ");
                            type = scan.next();
                            continue;
                        }
                        break;
                    }
                    t.setType(type); break;}
                case "6": case "postalAddress": case "postal address": case "postal_address": case "postal addres": case "postal_addres": case "postal adress": case "postal_adress": case "postal adres": case "postal_adres": {System.out.print("Input postal address '<string> zipcode, <string> street, <int> x, <long> y, <string> town': ");
                    scan.nextLine(); t.setPostalAddress(scan.nextLine()); break;}


                default:
                    System.out.println("Unexpected value");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Sorry...\nDon't find organization by this id(");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Something going wrong...");
        }

    }
}
