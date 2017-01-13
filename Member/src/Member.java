/**
 * Created by Khalin on 9/16/2016.
 */
public class Member {
    private String firstName;
    private String lastName;
    private int id;
    private PhoneNumber contactNumber;
    private Address address;

    public Member() throws Exception{
    id=0;
    firstName="Jack" ;
        lastName="Brown";
        contactNumber= new PhoneNumber();
        address= new Address();
    }

    public Member(int id, String firstName, String lastName, PhoneNumber contactNumber, Address address){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.contactNumber=contactNumber;
        this.address= address;
    }
    public Member(Member mem){
        id=mem.id;
        firstName=mem.firstName;
        lastName=mem.lastName;
        contactNumber=mem.contactNumber;
        address=mem.address;
    }

    public String toString() {
        String out;
    out ="Member ID: "+id+ "\n";
        out+="Name: "+firstName+" "+lastName+"\n";
        out+="Contact Number: "+ contactNumber+"\n";
        out+="Address: "+address+"\n";
    return out;
    }

    public String getFname() {
        return firstName;
    }

    public String getLname() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public PhoneNumber getContactNumber() {
        return contactNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setFname(String firstName) {
        this.firstName = firstName;
    }

    public void setLname(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContactNumber(PhoneNumber contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
