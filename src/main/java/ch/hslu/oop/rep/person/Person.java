package ch.hslu.oop.rep.person;

import java.util.Objects;


@SuppressWarnings("ClassCanBeRecord")
public final class Person implements Comparable<Person> {

    private final String firstName;
    private final String lastName;
    private final long id;

    public Person(String firstName, String lastName, long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        final Person other = (Person) o;
        return Objects.equals(other.firstName, this.firstName) &&
                Objects.equals(other.lastName, this.lastName) &&
                other.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName, this.id);
    }

    @Override
    public int compareTo(Person o) {
        if (o == null) {
            throw new NullPointerException();
        } else if (this == o) {
            return 0;
        } else if (this.firstName.compareTo(o.firstName) != 0) {
            return this.firstName.compareTo(o.firstName);
        } else if (this.lastName.compareTo(o.lastName) != 0) {
            return this.lastName.compareTo(o.lastName);
        } else {
            return Long.compare(this.id, o.id);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getId() {
        return id;
    }
}
