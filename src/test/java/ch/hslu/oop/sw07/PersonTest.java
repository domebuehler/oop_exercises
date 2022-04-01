package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    public void testPersonVorname() {
        Person person = new Person("Dominik", "Bühler", 9876);
        assertThat(person.getVorname()).isEqualTo("Dominik");
        System.out.println(person);
    }

    @Test
    public void testPersonNachname() {
        Person person = new Person("Dominik", "Bühler", 9876);
        assertThat(person.getNachname()).isEqualTo("Bühler");
    }

    @Test
    public void testPersonPersonID() {
        Person person = new Person("Dominik", "Bühler", 9876);
        assertThat(person.getPersonID()).isEqualTo(9876);
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void testEqualsIdentity() {
        Person person1 = new Person("Hans", "Büchler", 1234);
        Person person2 = person1;
        assertEquals(person1, person2);
    }

    @Test
    public void testEqualsOtherClass() {
        Person person1 = new Person("Hans", "Büchler", 1234);
        Student student = new Student("Hans", "Büchler", 1234, 2);
        Object obj = new Object();
        assertThat(obj.equals(person1)).isFalse();
    }

    @Test
    public void testEqualsNull() {
        Person person1 = new Person("Hans", "Büchler", 1234);
        assertThat(person1.equals(null)).isFalse();
    }

    @Test
    public void testEqualsNullAttributs() {
        Person person1 = new Person(null, null, 1234);
        Person person2 = new Person(null, null, 1234);
        assertThat(person1.equals(person2)).isTrue();
    }

    @Test
    public void testEqualsTrue() {
        Person person1 = new Person("Hans", "Büchler", 1234);
        Person person2 = new Person("Hans", "Büchler", 1234);
        assertThat(person1.equals(person2)).isTrue();
    }

    @Test
    public void testEqualsAllDiffrent() {
        Person person1 = new Person("Hans", "Büchler", 1234);
        Person person2 = new Person("Sepp", "Müller", 5678);
        assertThat(person1.equals(person2)).isFalse();
    }

    @Test
    public void testEqualsVornameDiffrent() {
        Person person1 = new Person("Hans", "Büchler", 1234);
        Person person2 = new Person("Sepp", "Büchler", 1234);
        assertThat(person1.equals(person2)).isFalse();
    }

    @Test
    public void testEqualsNachnameDiffrent() {
        Person person1 = new Person("Hans", "Büchler", 1234);
        Person person2 = new Person("Hans", "Müller", 1234);
        assertThat(person1.equals(person2)).isFalse();
    }

    @Test
    public void testEqualsPersonIDDiffrent() {
        Person person1 = new Person("Hans", "Büchler", 1234);
        Person person2 = new Person("Hans", "Büchler", 5678);
        assertThat(person1.equals(person2)).isFalse();
    }

    @Test
    public void testHashCodeIfEqualsTrue() {
        Person person1 = new Person("Hans", "Büchler", 1234);
        Person person2 = new Person("Hans", "Büchler", 1234);
        assertThat(person2.hashCode()).isEqualTo(person1.hashCode());
    }

    @Test
    public void testHashCodeIfEqualsFalse() {
        Person person1 = new Person("Hans", "Büchler", 1234);
        Person person2 = new Person("Sepp", "Büchler", 1234);
        assertThat(person2.hashCode()).isNotEqualTo(person1.hashCode());
    }

    @Test
    public void testCompareToIfEqual() {
        Person person1 = new Person("Hans", "Fuchs", 1234);
        Person person2 = new Person("Hans", "Fuchs", 1234);
        assertThat(person1.compareTo(person2)).isEqualTo(0);
    }

    @Test
    public void testCompareToVornameBigger() {
        Person person1 = new Person("Beat", "Fuchs", 1234);
        Person person2 = new Person("Arno", "Fuchs", 1234);
        assertThat(person1.compareTo(person2)).isEqualTo(1);
    }

    @Test
    public void testCompareToVornameSmaller() {
        Person person1 = new Person("Arno", "Fuchs", 1234);
        Person person2 = new Person("Beat", "Fuchs", 1234);
        assertThat(person1.compareTo(person2)).isEqualTo(-1);
    }

    @Test
    public void testCompareToVornameEqualNachnameBigger() {
        Person person1 = new Person("Hans", "Birrer", 1234);
        Person person2 = new Person("Hans", "Amrein", 1234);
        assertThat(person1.compareTo(person2)).isEqualTo(1);
    }

    @Test
    public void testCompareToVornameEqualNachnameSmaller() {
        Person person1 = new Person("Hans", "Amrein", 1234);
        Person person2 = new Person("Hans", "Birrer", 1234);
        assertThat(person1.compareTo(person2)).isEqualTo(-1);
    }

    @Test
    public void testCompareToVornameAndNachnameEqualIDBigger() {
        Person person1 = new Person("Hans", "Fuchs", 5678);
        Person person2 = new Person("Hans", "Fuchs", 1234);
        assertThat(person1.compareTo(person2)).isEqualTo(1);
    }

    @Test
    public void testCompareToVornameAndNachnameEqualIDSmaller() {
        Person person1 = new Person("Hans", "Fuchs", 1234);
        Person person2 = new Person("Hans", "Fuchs", 5678);
        assertThat(person1.compareTo(person2)).isEqualTo(-1);
    }
}