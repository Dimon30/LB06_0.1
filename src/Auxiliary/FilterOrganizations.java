package Auxiliary;

import Organization.Organization;

import java.util.Vector;
import java.util.stream.Collectors;

public class FilterOrganizations {
    public static Vector<Organization> filterByType(Vector<Organization> org, String type){
        Vector<Organization> result = new Vector<Organization>();
        result = org.stream().filter(o -> o.equals(type)).collect(Vector<Organization>::new, Vector<Organization>::add, Vector<Organization>::addAll);
        return result;
    }
}
