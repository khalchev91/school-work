/**
 * Created by Khalin on 9/16/2016.
 */
public class Address {
    private String  streetNumber;
    private String  streetName;
    private String  city;
    private String  parish;

    public Address(){
        streetNumber="237";
        streetName="Old Hope Road";
        city="Kingston";
        parish="St.Andrew";
    }

    public Address(String streetNumber, String streetName, String city, String parish){
        this.streetNumber=streetNumber;
        this.streetName=streetName;
        this.city=city;
        this.parish=parish;
    }
    public Address(Address add){
        streetNumber=add.streetNumber;
        streetName=add.streetName;
        city=add.city;
        parish=add.parish;
    }

    public String toString(){
        String out;
        out= streetNumber+" "+streetName+", "+ city+", "+parish;
        return out;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getParish() {
        return parish;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }
}
