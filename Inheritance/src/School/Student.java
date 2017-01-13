package School;

import util.Person;

/**
 * Created by Khalin on 10/28/2016.
 */
public class Student extends Person {
    private int id;
    private String faculty;
    private float gpa;

public Student(int id, String firstName, String lastName, String faculty, float gpa){
    super(firstName,lastName);
    setId(id);
    setFaculty(faculty);
    setGpa(gpa);
}
public Student(){
    this(0,"First Name", "Last Name", "faculty",4.0f);
}

public Student (Student student){
    this(student.getId(), student.getFirstName(),student.getLastName(),student.getFaculty(),student.getGpa());
}
@Override
public String toString(){
    String student="";
    student+="ID: "+getId()+"\n";
    student+=super.toString();
    student+="Faculty: "+getFaculty()+"\n";
    student+="GPA: "+getGpa()+"\n";
    return student;
}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

public long getRecordSize(){
    return (long)(4+4+((25+25+10)*2));
}
}
