package work;


import util.Person;

/**
 * Created by Khalin on 10/28/2016.
 */
public class Employee extends Person {
private int id;
    private String department;
    private float salary;



    public Employee(int id,String firstName, String lastName,String department, float salary){
        super(firstName, lastName);
        setId(id);
        setDepartment(department);
        setSalary(salary);
    }

    public Employee(){
            this(0,"first name","last name", "department", 0.0f);
    }

    public Employee(Employee employee){
        this(employee.getId(), employee.getFirstName(), employee.getLastName(),employee.getDepartment(),employee.getSalary());
    }
@Override
public String toString(){
    String employee="";
    employee+="Employee: "+getId()+"\n";
    employee+=super.toString();
    employee+="Department: "+getDepartment()+"\n";
    employee+="Salary: $"+getSalary()+"\n";
    return employee;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public long getRecordSize(){
        return (long)(4+4+((25+25+25)*2));
    }
}
