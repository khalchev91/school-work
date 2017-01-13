import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Khalin on 10/7/2016.
 */
public class Pet {
    private int id;
    private String type;
    private String gender;
    private float cost;

    public Pet(){
        setId(0);
        setType("type");
        setGender("gender");
        setCost(0.0f);
    }
    public Pet(int inID, String inType, String inGender, float inCost){
        setId(inID);
        setType(inType);
        setGender(inGender);
        setCost(inCost);
    }
public Pet(Pet dog){
    setId(dog.getId());
    setType(dog.getType());
    setGender(dog.getGender());
    setCost(dog.getCost());
}
public String toString(){
    String record;
    record="ID#: "+ getId()+ "\n";
    record+="Type: "+getType() + "\n";
    record+= "Gender: "+getGender()+"\n";
    record+="Cost: "+ getCost();
    return record;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    public  void SaveFile(Pet record){
        FileWriter petFile= null;
        try{
            petFile= new FileWriter("petdb.pt",true);
            petFile.write(record.getId() + "\t" + record.getType() + "\t" + record.getGender() + "\t" + record.getCost() + "\n");

        }catch(IOException exc){
            exc.printStackTrace();
            //System.err.println(exc.getMessage());
        }finally {
            try{
                petFile.close();
            }catch(IOException ex){
                //
            }
        }
    }
    public Pet ReadFile(int searchId){
        Pet rec=null;
        Scanner file=null;
        try {
            file = new Scanner(new File("petdb.pt"));
            int id;
            String type,gender;
            float cost;
            while (file.hasNext()){
                id=file.nextInt();
                type=file.next();
                gender=file.next();
                cost=file.nextFloat();
                if(id==searchId){
                    rec=new Pet(id,type,gender,cost);
                    break;
                }
            }
        }catch(IOException ex){
            ex.printStackTrace();
            //System.err.println(ex.getMessage());
        }
            finally {
                file.close();
        }

        return rec;
    }
}
