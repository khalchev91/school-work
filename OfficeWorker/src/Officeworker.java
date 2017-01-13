/**
 * Created by Khalin on 9/9/2016.
 */
public class Officeworker {
private int employeeNumber;
    private String firstName;
    private String lastName;
    private String department;

    //constructor
    public Officeworker(int en, String fn, String ln, String dep){

        employeeNumber=en;
        firstName=fn;
        lastName=ln;
        department=dep;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public  void Display(){
        System.out.println("Employee Number:" +employeeNumber);
        System.out.println("First Name:" + firstName);
        System.out.println("Last Name:" + lastName);
        System.out.println("Department:" + department);
    }

}
