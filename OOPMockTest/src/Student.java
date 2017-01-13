import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Khalin on 10/14/2016.
 */
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    Date enrolDate;

    public Student(){
        setId(0);
        setFirstName("Jack");
        setLastName("Brown");
        enrolDate=new Date();
    }
    public Student(int id, String firstName, String lastName,Date enrolDate){
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEnrolDate(enrolDate);
    }
    public Student(Student student){
        setId(student.getId());
        setFirstName(student.getFirstName());
        setLastName(student.getLastName());
        setEnrolDate(student.getEnrolDate());
    }
public String toString(){
    String string="";
    string+="ID: "+getId()+"\n";
    string+="Name: "+getFirstName()+getLastName()+"\n";
    string+="Enrollment Date: "+getEnrolDate()+"\n";
    return string;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getEnrolDate() {
        return enrolDate;
    }

    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }
    public void Display(){
        System.out.println("Student ID: "+id);
        System.out.println("Student Name: "+firstName+" "+lastName);
        System.out.println("Date Enrolled: "+getEnrolDate());
    }
    public void WriteRecord(Student record) {
        FileWriter file = null;
        try {
            file = new FileWriter("students.txt", true);
            file.write(record.getId() + "\t" + record.getFirstName() + "\t" + record.getLastName() + "\t" + record.getEnrolDate().getDay() + "\t" + record.getEnrolDate().getMonth() + "\t" + record.getEnrolDate().getYear()+"\n");
            file.close();
        } catch (IOException exc) {
          exc.printStackTrace();
        }
    }

        public Student ReadRecord(int studentId){
        Scanner file=null;
        Student record=null;
        try{
            file= new Scanner(new File("students.txt"));
            int id;
            String firstName,lastName;
            int day,month,year;
            Date date=null;
            while (file.hasNext()) {
                id=file.nextInt();
                firstName=file.next();
                lastName=file.next();
                day=file.nextInt();
                month=file.nextInt();
                year=file.nextInt();
                if(id==studentId) {
                    date = new Date(day, month, year);
                    record = new Student(id, firstName, lastName, date);
                    break;
                }
            }
        }catch(IOException exc){
            exc.printStackTrace();
        }finally {
            file.close();
        }
        return record;
        }
    }

