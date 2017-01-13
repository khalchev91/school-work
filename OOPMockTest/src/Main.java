/**
 * Created by Khalin on 10/14/2016.
 */
public class Main {
    public static void main(String[] args){

            Date date=new Date(12,3,2016);
        Date michaelDate= new Date(25,8,2017);
        Student student=new Student(21,"Jordan","Kleper",date);
        Student michael= new Student(1347,"Michael","Brown",michaelDate);
        student.WriteRecord(student);
        //michael.WriteRecord(michael);
        System.out.println("Student's Record: "+michael.ReadRecord(1347));
        //System.out.println(student.ReadRecord(21));
        System.out.println(michael);
        //student.Display();
    }
}
