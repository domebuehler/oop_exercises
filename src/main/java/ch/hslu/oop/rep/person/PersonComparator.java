package ch.hslu.oop.rep.person;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1 == o2) {
            return 0;
        } else if (!o1.getLastName().equals(o2.getLastName())) {
            return o2.getLastName().compareTo(o1.getLastName());
        } else {
            return o2.getFirstName().compareTo(o1.getFirstName());
        }
    }
}
