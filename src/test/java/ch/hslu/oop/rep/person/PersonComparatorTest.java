package ch.hslu.oop.rep.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonComparatorTest {

    private static List<Person> list;

    @BeforeEach
    public void setUpList() {
        list = new ArrayList<>();
        Person p1 = new Person("A", "A", 1);
        Person p2 = new Person("A", "B", 1);
        Person p3 = new Person("B", "A", 1);
        Person p4 = new Person("B", "B", 1);
        Person p5 = new Person("A", "C", 1);
        Person p6 = new Person("B", "C", 1);
        Person p7 = new Person("C", "C", 1);

        Collections.addAll(list, p1, p2, p3, p4, p5, p6, p7);
        Collections.shuffle(list);
    }

    @AfterEach
    void tearDownList() {
        list.removeAll(list);
    }

    @Test
    public void testComparator() {
        System.out.println("before:");
        for (Person person : list) {
            System.out.println(list.indexOf(person) + "\t" + person.toString());
        }

        PersonComparator comparator = new PersonComparator();
        Collections.sort(list, comparator);

        System.out.println("after:");
        for (Person person : list) {
            System.out.println(list.indexOf(person) + "\t" + person.toString());
        }
    }

    @Test
    public void testComparatorIndex0() {
        PersonComparator comparator = new PersonComparator();
        Collections.sort(list, comparator);
        assertThat(list.get(0)).isEqualTo(new Person("C", "C", 1));
    }

    @Test
    public void testComparatorIndex1() {
        PersonComparator comparator = new PersonComparator();
        Collections.sort(list, comparator);
        assertThat(list.get(1)).isEqualTo(new Person("B", "C", 1));
    }

    @Test
    public void testComparatorIndex2() {
        PersonComparator comparator = new PersonComparator();
        Collections.sort(list, comparator);
        assertThat(list.get(2)).isEqualTo(new Person("A", "C", 1));
    }

    @Test
    public void testComparatorIndex3() {
        PersonComparator comparator = new PersonComparator();
        Collections.sort(list, comparator);
        assertThat(list.get(3)).isEqualTo(new Person("B", "B", 1));
    }

    @Test
    public void testComparatorIndex4() {
        PersonComparator comparator = new PersonComparator();
        Collections.sort(list, comparator);
        assertThat(list.get(4)).isEqualTo(new Person("A", "B", 1));
    }

    @Test
    public void testComparatorIndex5() {
        PersonComparator comparator = new PersonComparator();
        Collections.sort(list, comparator);
        assertThat(list.get(5)).isEqualTo(new Person("B", "A", 1));
    }

    @Test
    public void testComparatorIndex6() {
        PersonComparator comparator = new PersonComparator();
        Collections.sort(list, comparator);
        assertThat(list.get(6)).isEqualTo(new Person("A", "A", 1));
    }
}