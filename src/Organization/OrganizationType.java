/* FILE NAME   : OrganizationType.java
 * PROGRAMMER  : DS6
 * @author     : Sokolov Dmitry
 * LAST UPDATE : 13.03.2023
 * PURPOSE     : Type of Organization
 */

package Organization;

public enum OrganizationType {
    COMMERCIAL("commercial"),
    PUBLIC("public"),
    GOVERNMENT("government"),
    TRUST("trust"),
    PRIVATE_LIMITED_COMPANY("private_limited_company");

    private final String name;

    OrganizationType(String name){
        this.name = name;
    }
    public static OrganizationType findTypebyName(String s) {
        switch (s) {
            case ("commercial"), ("Commercial"), ("COMMERCIAL") -> {return COMMERCIAL;}
            case ("public"), ("Public"), ("PUBLIC") -> {return PUBLIC;}
            case ("government"), ("Government"), ("GOVERNMENT") -> {return GOVERNMENT;}
            case ("trust"), ("Trust"), ("TRUST") -> {return TRUST;}
            case ("private_limited_company"), ("Private limited company"), ("PRIVATE_LIMITED_COMPANY"), ("PrivateLimitedCompany"), ("Private_Limited_Company") -> {return PRIVATE_LIMITED_COMPANY;}
            default -> {return null;}
        }
    }
    public static String findNamebyType(OrganizationType t) {
        return t.name;
    }

}
