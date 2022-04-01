package ch.hslu.oop.sw12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {
    private static final Logger LOG = LogManager.getLogger(PersonTest.class);

    @Test
    void compareByID() {
        Person p1 = new Person("dominik", "bühler", 6789);
        Person p2 = new Person("elmar", "groma", 4587);
        Person p3 = new Person("adrian", "zuber", 7179);
        Person p4 = new Person("mike", "schwändler", 5789);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        LOG.info("before sorting");
        for (Person p : list) {
            LOG.info(p);
        }

        Collections.sort(list, Person.compareByID());

        LOG.info("after sorting");
        for (Person p : list) {
            LOG.info(p);
        }

        assertThat(list.get(3)).isEqualTo(p3);
    }

    @Test
    public void testCompareByVorname() {
        Person p1 = new Person("dominik", "bühler", 6789);
        Person p2 = new Person("elmar", "groma", 4587);
        Person p3 = new Person("adrian", "zuber", 7179);
        Person p4 = new Person("mike", "schwändler", 5789);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        LOG.info("before sorting");
        for (Person p : list) {
            LOG.info(p);
        }
        Collections.sort(list, Person.compareByVorname());

        LOG.info("after sorting");
        for (Person p : list) {
            LOG.info(p);
        }
        assertThat(list.get(3)).isEqualTo(p4);
    }

    @Test
    public void testCompareByNachname() {
        Person p1 = new Person("dominik", "bühler", 6789);
        Person p2 = new Person("elmar", "groma", 4587);
        Person p3 = new Person("adrian", "zuber", 7179);
        Person p4 = new Person("mike", "schwändler", 5789);

        List<Person> list = new ArrayList<>();
        list.add(p2);
        list.add(p1);
        list.add(p3);
        list.add(p4);

        LOG.info("before sorting");
        for (Person p : list) {
            LOG.info(p);
        }
        Collections.sort(list, Person.compareByNachname());

        LOG.info("after sorting");
        for (Person p : list) {
            LOG.info(p);
        }

        assertThat(list.get(3)).isEqualTo(p3);
    }

    @Test
    public void testAllComparators() {
        Person p1 = new Person("AA", "AA", 1234);
        Person p2 = new Person("AA", "BB", 1234);
        Person p3 = new Person("AA", "AA", 5678);
        Person p4 = new Person("AA", "CC", 123);
        Person p5 = new Person("BB", "AA", 1234);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p5);
        list.add(p4);

        LOG.info("before sorting");
        for (Person p : list) {
            LOG.info(p);
        }

        Collections.sort(list, Person.compareByVorname().
                thenComparing(Person.compareByNachname()).
                thenComparing(Person.compareByID()));

        LOG.info("before sorting");
        for (Person p : list) {
            LOG.info(p);
        }
        assertThat(list.get(4)).isEqualTo(p5);
    }
}