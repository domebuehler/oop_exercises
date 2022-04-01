package ch.hslu.oop.sw07;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String vorname;
    private String nachname;
    private final long personID;

    public Person(final String vorname, final String nachname, final long personID) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.personID = personID;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "nachname='" + nachname + '\'' +
                ", vorname='" + vorname + '\'' +
                ", personID=" + personID +
                '}';
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        final Person person = (Person) obj;
        //Objects.equals() is null-safe
        return Objects.equals(this.vorname, person.vorname)
                && Objects.equals(this.nachname, person.nachname)
                && this.personID == person.personID;
        /*
        --- manual Null-Check ---
        boolean checkNullVorname = (this.vorname == null);
        boolean checkNullNachname = (this.nachname == null);

        if (checkNullNachname && checkNullVorname) {
            return person.vorname == null && person.nachname == null && this.personID == person.personID;
        } else if (checkNullVorname) {
            return person.vorname == null && this.nachname.equals(person.nachname)
                    && this.personID == person.personID;
        } else if (checkNullNachname) {
            return this.vorname.equals(person.vorname) && person.nachname == null
                    && this.personID == person.personID;
        } else {
            return this.vorname.equals(person.vorname) && this.nachname.equals(person.nachname)
                    && (this.personID == person.personID);
        }*/

    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.vorname, this.nachname, this.personID);
    }

    /*---wichtig---
    Die CompareTo-Methode von String vergleicht die String lexikographisch und nicht alphabetisch
    D.h. die String werden anhand ihrer Unicodewerts verglichen!
    D.h. aber auch, dass z.B. b > a
    */
    @Override
    public int compareTo(Person other) {
        if (this == other) {
            return 0;
        }
        if (this.vorname.compareTo(other.vorname) != 0) {
            return this.vorname.compareTo(other.vorname);
        } else if (this.nachname.compareTo(other.nachname) != 0) {
            return this.nachname.compareTo(other.nachname);
        } else {
            return Long.compare(this.personID, other.personID);
        }
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public long getPersonID() {
        return personID;
    }
}
