package ch.hslu.oop.rep.person;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    public void testPerson() {
        Person person = new Person("Alfred", "Meyer", 123456);
        assertThat(person.getFirstName()).isEqualTo("Alfred");
        assertThat(person.getLastName()).isEqualTo("Meyer");
        assertThat(person.getId()).isEqualTo(123456);
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Person.class).verify();
    }

    @Test
    public void testEqualsTrue() {
        Person p1 = new Person("Sepp", "Müller", 1234);
        Person p2 = new Person("Sepp", "Müller", 1234);
        assertThat(p1.equals(p2)).isTrue();
    }

    @Test
    public void testEqualsFalse() {
        Person p1 = new Person("Sepp", "Müller", 1234);
        Person p2 = new Person("Toni", "Meyer", 4321);
        assertThat(p1.equals(p2)).isFalse();
    }

    @Test
    public void testHashCodeWhenEqualsTrue() {
        Person p1 = new Person("Sepp", "Müller", 1234);
        Person p2 = new Person("Sepp", "Müller", 1234);
        assertThat(p1.hashCode()).isEqualTo(p2.hashCode());
    }

    @Test
    public void testHashCodeWhenEqualsFalse() {
        Person p1 = new Person("Toni", "Müller", 1234);
        System.out.println(p1.hashCode());
        Person p2 = new Person("Sepp", "Müller", 1234);
        System.out.println(p2.hashCode());
        assertThat(p1.hashCode()).isNotEqualTo(p2.hashCode());
    }

    @Test
    public void testCompareToBigger() {
        Person p1 = new Person("B", "B", 5678);
        Person p2 = new Person("A", "B", 1234);

        assertThat(p1.compareTo(p2)).isPositive();
    }

    @Test
    public void testCompareToSmaller() {
        Person p1 = new Person("A", "B", 5678);
        Person p2 = new Person("B", "B", 1234);

        assertThat(p1.compareTo(p2)).isNegative();
    }

    @Test
    public void testCompareToEqual() {
        Person p1 = new Person("A", "B", 5678);
        Person p2 = new Person("A", "B", 5678);

        assertThat(p1.compareTo(p2)).isEqualTo(0);
    }
}