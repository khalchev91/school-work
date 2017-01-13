package util;

/**
 * Created by Khalin on 10/28/2016.
 */
public class Person {
    protected String firstName;
    protected String lastName;

    public Person(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }
    public Person(){
        this("first name","last name");
    }
    public Person(Person person){
        this(person.getFirstName(),person.getLastName());
    }

    @Override
    public String toString(){
        String person="";
        person+="First Name: "+getFirstName()+"\n";
        person+="Last Name: "+getLastName()+"\n";
        return person;
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


}
