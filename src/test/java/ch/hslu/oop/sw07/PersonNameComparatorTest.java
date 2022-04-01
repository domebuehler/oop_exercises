package ch.hslu.oop.sw07;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class PersonNameComparatorTest {

    PersonNameComparator comparator = new PersonNameComparator();
    Person one = new Person("Adolf", "Amrein", 1);
    Person two = new Person("Adolf", "Birrer", 2);
    Person three = new Person("Beat", "Amrein", 3);
    Person four = new Person("Beat", "Birrer", 4);

    ArrayList<Person> list = new ArrayList<>();

    @Test
    void testCompareEqual() {
        assertThat(comparator.compare(one, one)).isEqualTo(0);
    }

    @Test
    void testCompareNachnameBigger() {
        assertThat(comparator.compare(one, two)).isEqualTo(-1);
    }

    @Test
    void testCompareNachnameSmaller() {
        assertThat(comparator.compare(two, one)).isEqualTo(1);
    }

    @Test
    void testCompareVornameBigger() {
        assertThat(comparator.compare(three, four)).isEqualTo(-1);
    }

    @Test
    void testCompareVornameSmaller() {
        assertThat(comparator.compare(four, three)).isEqualTo(1);
    }

    @Test
    void testCompareNachnameEqualVornameBigger() {
        assertThat(comparator.compare(one, three)).isEqualTo(-1);
    }

    @Test
    void testCompareNachnameEqualVornameSmaller() {
        assertThat(comparator.compare(three, one)).isEqualTo(1);
    }

    @Test
    void testCompare2to4() {
        assertThat(comparator.compare(two, four)).isEqualTo(-1);
    }

    @Test
    void testCompare4to2() {
        assertThat(comparator.compare(four, two)).isEqualTo(1);
    }

    @Test
    void testSorting() {
        list.add(four);
        list.add(three);
        list.add(two);
        list.add(one);
        System.out.println("before sorting");
        for (Person person : list) {
            System.out.println(person);
        }

        Collections.sort(list, comparator);
        System.out.println("after sorting");
        for (Person person : list) {
            System.out.println(person);
        }

        assertThat(list.get(0).getPersonID()).isEqualTo(1);
    }
}