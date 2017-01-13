import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Khalin on 11/18/2016.
 */
public class Samsung extends CellularPhone{
    private float wapVersion;
    private String dataProtocol;

    public Samsung(){
        super();/**this calls the default constructor of the CellularPhone class**/
        setWapVersion(0);
        setDataProtocol("LTE");
    }
    public Samsung(int inImei, String inModel,String inNetwork,float inWapVersion,String inDataProtocol){
        super(inImei,inModel,inNetwork);/**this passes imei,model and network to the primary constructor of the Super class CellularPhone **/
        setWapVersion(inWapVersion);
        setDataProtocol(inDataProtocol);
    }
    public Samsung(Samsung samsung){
        super(samsung);/**this passes the object samsung to the copy constructor of the Super class CellularPhone **/
        setWapVersion(samsung.getWapVersion());
        setDataProtocol(samsung.getDataProtocol());
    }

/** @Override enables the programmer to take the toString Method from the
 * superclass CellularPhone and adds to it the attributes that are unique to the Samsung class**/


@Override
    public String toString(){
        String phone="";
        phone+=super.toString();/**calls the toString Method from CellularPhone class**/

        phone+="Wap Version: "+getWapVersion()+"\n";
        phone+="Data Protocol: "+getDataProtocol()+"\n";
        return phone;
    }

    public float getWapVersion() {
        return wapVersion;
    }

    public void setWapVersion(float wapVersion) {
        this.wapVersion = wapVersion;
    }

    public String getDataProtocol() {
        return dataProtocol;
    }

    public void setDataProtocol(String dataProtocol) {
        this.dataProtocol = dataProtocol;
    }


    /**Implements the method writeToFile from Parent class CellularPhone**/
    public void writeToFile(){
        RandomAccessFile samsungFile=null;
        try {
            samsungFile= new RandomAccessFile(new File("samsung.txt"),"rw");
                try {
                    samsungFile.seek((getImei()-1)*recordSize());
                    samsungFile.writeInt(getImei());
                    samsungFile.writeUTF(getModel());
                    samsungFile.writeUTF(getNetwork());
                    samsungFile.writeFloat(getWapVersion());
                    samsungFile.writeUTF(getDataProtocol());
                } catch (IOException e) {
                    e.printStackTrace();
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                samsungFile.close();
            }catch (IOException exc){
                //
            }
        }

    }
    /**overrides initializes method from parent class CellularPhone**/

    public void initializeToFile() {
        RandomAccessFile samsungFile=null;
        try {
            samsungFile= new RandomAccessFile(new File("samsung.txt"),"rw");
            for(int count=1000; count<1020;count++){
                try {
                    samsungFile.seek((count-1)*recordSize());
                    samsungFile.writeInt(getImei());
                    samsungFile.writeUTF(getModel());
                    samsungFile.writeUTF(getNetwork());
                    samsungFile.writeFloat(getWapVersion());
                    samsungFile.writeUTF(getDataProtocol());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                samsungFile.close();
            }catch (IOException exc){
                //
            }
        }

    }
    /**implements readfromFile method from parent class CellularPhone**/

    public CellularPhone readFromFile(int imei) {
        Samsung samsung=new Samsung();
        RandomAccessFile samsungFile= null;

        try {
            samsungFile= new RandomAccessFile(new File("samsung.txt"),"r");
            try {
                /**samsungFile.seek((imei-1)*recordSize()); this seeks to starting byte for the imei that was passed to the method using formula (id-offset)*sizeOfObject**/
                /**readInt()reads integer, readUTF()reads String from file,readFloat()reads Float**/
                samsungFile.seek((imei-1)*recordSize());
                samsung.setImei(samsungFile.readInt());
                samsung.setModel(samsungFile.readUTF());
                samsung.setNetwork(samsungFile.readUTF());
                samsung.setWapVersion(samsungFile.readFloat());
                samsung.setDataProtocol(samsungFile.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return samsung;
    }
    /**gets the size of one object. Int=4 bytes,Float=4 bytes, character=2 bytes*/
    private long recordSize(){
        return (long)(4+4+((25+ 10+10)*2));
    }
}
