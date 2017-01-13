package Main;

import School.Student;
import util.Person;
import work.Employee;

import java.io.*;
import java.util.Scanner;

/**
 *
 * Created by Khalin on 10/28/2016.
 */
public class Main {
    public static void main(String[] args){
/*        Person p1= new Person();
        System.out.println(p1);

        Employee employee= new Employee();
        System.out.println(employee);
*/
        //Student student = new Student();
        //System.out.println(student);


//Employee employee= new Employee(123, "Jack","Brown","Accounts",1000000.0f);
Student student= new Student(2, "Michael", "Jackson","SHTM",3.0f);
        //initialize(student,"student.in",10);
        //Employee e1= new Employee(12,"Janet","Brown","Secretary",450000.0f);
        //saveFile(employee);
        saveFile(student,"student.in");
        //saveFile(e1);
        //System.out.println(readEmployeeFile(12));
//        System.out.println(readEmployeeFile(123));
         System.out.println(readStudentFile(2,"student.in"));

    }
    public static void initialize(Student data,String filename, int maxRecords){
        try {
            RandomAccessFile file= new RandomAccessFile(new File(filename),"rw");
            for(int count=1;count<=maxRecords;count++){
                file.seek((count-1)*data.getRecordSize());
                file.writeInt(data.getId());
                file.writeUTF(data.getFirstName());
                file.writeUTF(data.getLastName());
                file.writeUTF(data.getFaculty());
                file.writeFloat(data.getGpa());
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
public static void saveFile(Employee employee, String filename){
try{
    RandomAccessFile employeeFile= new RandomAccessFile(new File(filename),"rw");
    employeeFile.seek(employee.getId()-1*employee.getRecordSize());
    employeeFile.writeInt(employee.getId());
    employeeFile.writeUTF(employee.getFirstName());
    employeeFile.writeUTF(employee.getLastName());
    employeeFile.writeUTF(employee.getDepartment());
    employeeFile.writeFloat(employee.getSalary());
    employeeFile.close();
}catch(IOException exc){
    exc.printStackTrace();
}
}
public static void saveFile(Student student, String filename){
    try{
        RandomAccessFile studentFile= new RandomAccessFile(new File(filename),"rw");
        studentFile.seek((student.getId()-1)*student.getRecordSize());
        studentFile.writeInt(student.getId());
        studentFile.writeUTF(student.getFirstName());
        studentFile.writeUTF(student.getLastName());
        studentFile.writeUTF(student.getFaculty());
        studentFile.writeFloat(student.getGpa());
        studentFile.close();
    }catch(IOException exc){
        exc.printStackTrace();
    }
}
public static Employee readEmployeeFile(int id){
    Employee employee= null;
    Scanner employeeFile= null;

    int employeeId;
    String firstName, lastName, department;
    float salary;
            try{
                employeeFile= new Scanner(new File("employee.txt"));
                while (employeeFile.hasNext()){
                    employeeId= employeeFile.nextInt();
                    firstName=employeeFile.next();
                    lastName=employeeFile.next();
                    department= employeeFile.next();
                    salary= employeeFile.nextFloat();
                    if(employeeId==id){
                        employee= new Employee(employeeId, firstName,lastName,department,salary);
                        break;
                    }
                }
            }catch(IOException exc){
                exc.printStackTrace();
            }
    return employee;
}
public static Student readStudentFile(int id, String filename){
    Student student= new Student();

    int studentId;
    String firstName, lastName, faculty;
    float gpa;
    try{
        RandomAccessFile studentFile= new RandomAccessFile(new File(filename),"r");
        studentFile.seek((id-1)*student.getRecordSize());
            studentId=studentFile.readInt();
            firstName=studentFile.readUTF();
            lastName=studentFile.readUTF();
            faculty=studentFile.readUTF();
            gpa=studentFile.readFloat();

studentFile.close();
        student= new Student(studentId,firstName,lastName,faculty,gpa);
    }catch(IOException exc){
        exc.printStackTrace();
    }
    return student;
}
}
