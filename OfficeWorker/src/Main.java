/**
 * Created by Khalin on 9/11/2016.
 */
public class Main {
    public static void main(String[] args){
        Officeworker objl= new Officeworker(10000,"Fred", "Wilson","Accounts");
        objl.Display();
        System.out.println("now change the employee number using the mutator");
        objl.setEmployeeNumber(20501);
        objl.Display();
        System.out.println("This is an example of how to use the accessor");''

        int en;
        en=objl.getEmployeeNumber();
        System.out.println("\nEmployee's name: "+ objl.getFirstName() +" "+ objl.getLastName());
        System.out.println("Department: " + objl.getDepartment());
        System.out.println("This employee's number is: " + en);
    }

}
