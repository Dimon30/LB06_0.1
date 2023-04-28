package Auxiliary;

import Organization.Organization;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class SortOrganizaton {
    public static void sort(Vector<Organization> org){
        sortByName(org);
    }
    public static void sortByName(Vector<Organization> org){
        Collections.sort(org, Comparator.comparing(Organization::getName));
    }
    public static void revSortByName(Vector<Organization> org){
        Collections.sort(org, Comparator.comparing(Organization::getName).reversed());
    }
    public static Vector<Organization> sortByAddress(Vector<Organization> org){
        Vector<Organization> result = org;
        Collections.sort(result, Comparator.comparing(Organization::getAddress));
        return result;
    }
    public static Vector<Organization> revSortByAddress(Vector<Organization> org){
        Vector<Organization> result = org;
        Collections.sort(result, Comparator.comparing(Organization::getAddress));
        return result;
    }
}
