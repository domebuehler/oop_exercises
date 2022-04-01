package ch.hslu.oop.sw07;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int compare = (p1.getNachname().compareTo(p2.getNachname()));
        if (compare == 0) {
            compare = (p1.getVorname().compareTo(p2.getVorname()));
        }
        return compare;
    }
}
