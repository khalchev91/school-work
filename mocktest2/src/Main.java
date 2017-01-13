/**
 * Created by Khalin on 11/18/2016.
 */
public class Main {

/*5iii) 1.*/
public static void showPhoneDetails(CellularPhone[] cellularPhone){
/**Method accepts as argument an array for CellularPhone and then loops through and prints what is inside of each of elements of the array**/
for(int count=0;count<cellularPhone.length;count++){
    System.out.println(cellularPhone[count]);
}

}
    public static void main(String [] args) {
        /**Samsung and Nokia are both concrete classes because they implemented the methods that weren't implemented in the CellularPhone class**/
        /**5i)**/
        Samsung samsung = new Samsung(1000, "Galaxy S7", "AT&T", 2, "LTE-A");
        Nokia nokia = new Nokia(1000, "Lumia 720", "T-Mobile", 14, "4G");
        CellularPhone cellularPhone = new Samsung(1002, "Galaxy A7", "Digicel", 2, "3G");

        //5ii)
        System.out.println(nokia);
        System.out.println(samsung);
        System.out.println(cellularPhone);
        //5iii)2
        CellularPhone[] phone = new CellularPhone[3];/**This creates an array of objects of the CellularPhone class**/


        /**5iii)4**/
        /**Because of Polymorphism it is possible for the CellularPhone class to handle objects of the child classes or concrete classes**/
        /**Samsung can't handle any other object but Samsung Objects and the same goes for Nokia**/
        /**Basically the Parent can make decisions for the child**/

        phone[0] = samsung;
        phone[1] = nokia;
        phone[2] = cellularPhone;

        /**5iii)4**/
        /**this calls the showPhoneDetails method and passes the phone array**/
        showPhoneDetails(phone);

        /**
         * initializes the files for both Samsung and Nokia for read and write. The Imei's HAVE to be in the range
         in which they were initialized otherwise an EndOfFile exception will be thrown which in this case is between 1000 and 1020 so anything below 1000 or above 1020 will result in an exception being thrown
         which is a runtime exception
         * samsung.initializeToFile();
         nokia.initializeToFile();
         **/


        /**Due to polymorphism it is possible to use the object of the CellularPhone object to read and write to the file based on which Child class it was instantiated with**/
        for (int count = 0; count < phone.length; count++) {
            phone[count].writeToFile();
        }
        System.out.println(phone[0].readFromFile(1000));
        System.out.println(phone[1].readFromFile(1000));
        System.out.println(phone[2].readFromFile(1002));
    }

}
