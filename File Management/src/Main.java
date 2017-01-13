/**
 * Created by Khalin on 10/7/2016.
 */
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    /*(public static void SaveRecord(Pet record) {
/*        FileWriter petFile=null;
        try {
            petFile= new FileWriter("petdb.pt", true);

        } catch (IOException exc) {
            exc.printStackTrace();
            //System.err.println(exc.getMessage());
        } finally {
            try {
                petFile.close();
            } catch (IOException ex) {
                //
            }
        }
    }*/



    public static void main(String[] args){
        Pet dog=new Pet();
        Pet cat= new Pet(132,"Cat","Male",30000.0f);
        Pet ran=new Pet(cat);
        //ran.SaveFile(ran);
        Pet bird= new Pet(12,"Bird","Female",2000.0f);
        //bird.SaveFile(bird);
        bird.ReadFile(12);
        System.out.println("Retrieved Record: \n"+bird.ReadFile(12));
        /*System.out.println(dog);
        System.out.println(cat);
        System.out.println(ran);*/




    }
}
