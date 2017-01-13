/**
 * Created by Khalin on 9/16/2016.
 */
import java.lang.Exception;
public class Main {
    public static void main(String[] args) {
        //Member mem1= new Member();
        try {
            PhoneNumber home = new PhoneNumber("876","652","9873");
            System.out.println(home);
            home.setAreaCode("898");
            home.setExchange("094");
            home.setLine("3948");
            System.out.println(home);
        } catch (Exception ex) {
            //System.err.println("Invalid Phone Number");
          //System.err.println(ex.getMessage());
          ex.printStackTrace();
        }

    }
}
