package ch.hslu.oop.sw07;

public class Student {

    private int semester;
    private final long studentID;
    private String vorname;
    private String nachname;

    public Student(String vorname, String nachname, long studentID, int semester) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.studentID = studentID;
        this.semester = semester;
    }
}
