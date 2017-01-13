import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Khalin on 11/18/2016.
 */
public class Nokia extends CellularPhone {
private float memoryCapacity;
    private String displayType;

    public Nokia(){
        super();
        setMemoryCapacity(0);
        setDisplayType("LCD");
    }
    public Nokia(int inImei, String inModel,String inNetwork, float inMemoryCapacity, String inDisplayType){
        super(inImei,inModel,inNetwork);
        setMemoryCapacity(inMemoryCapacity);
        setDisplayType(inDisplayType);
    }
    public Nokia(Nokia nokia){
        super(nokia.getImei(),nokia.getModel(),nokia.getNetwork());
        setMemoryCapacity(nokia.getMemoryCapacity());
        setDisplayType(nokia.getDisplayType());
    }

    @Override
    public String toString(){
        String phone="";
        phone+=super.toString();
        phone+="Memory Capacity: "+getMemoryCapacity()+"\n";
        phone+="Display Type: "+getDisplayType()+"\n";
    return phone;
    }

    public float getMemoryCapacity() {
        return memoryCapacity;
    }

    public void setMemoryCapacity(float memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    /**implements the  initializes method from parent class CellularPhone**/
    /**This initializes the file in order to write to it otherwise reading or writing records will never work**/
            public void initializeToFile() {
                RandomAccessFile nokiaFile=null;
                try {
                    nokiaFile= new RandomAccessFile(new File("nokia.txt"),"rw");
                    for(int count=1000; count<1020;count++){
                        try {
                            nokiaFile.seek((count-1)*recordSize());
                            nokiaFile.writeInt(getImei());
                            nokiaFile.writeUTF(getModel());
                            nokiaFile.writeUTF(getNetwork());
                            nokiaFile.writeFloat(getMemoryCapacity());
                            nokiaFile.writeUTF(getDisplayType());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        nokiaFile.close();
                    }catch (IOException exc){
                        //
                    }
                }

            }
/**implements the writetofile method from parent class CellularPhone**/

    public void writeToFile() {
        RandomAccessFile nokiaFile=null;
        try {
            nokiaFile= new RandomAccessFile(new File("nokia.txt"),"rw");
                try {
                    /**nokiaFile.seek((imei-1)*recordSize()); this seeks to starting byte for the imei that was passed to the method using formula (id-offset)*sizeOfObject**/
                    /** writeInt()writes integer, writeUTF()writes String to file,writeFloat()writes Float**/
                    nokiaFile.seek((getImei()-1)*recordSize());
                    nokiaFile.writeInt(getImei());
                    nokiaFile.writeUTF(getModel());
                    nokiaFile.writeUTF(getNetwork());
                    nokiaFile.writeFloat(getMemoryCapacity());
                    nokiaFile.writeUTF(getDisplayType());
                } catch (IOException e) {
                    e.printStackTrace();
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                nokiaFile.close();
            }catch (IOException exc){
                //
            }
        }

    }
    //implements the abstract method readfromfile from parent class CellularPhone

            public CellularPhone readFromFile(int imei) {
                Nokia nokia=new Nokia();
                RandomAccessFile nokiaFile= null;

                try {
                    nokiaFile= new RandomAccessFile(new File("nokia.txt"),"r");
                    try {
                      /**nokiaFile.seek((imei-1)*recordSize()); this seeks to starting byte for the imei that was passed to the method using formula (id-offset)*sizeOfObject**/
                        /**readInt()reads integer, readUTF()reads String from file,readFloat()reads Float**/
                        nokiaFile.seek((imei-1)*recordSize());
                        nokia.setImei(nokiaFile.readInt());
                        nokia.setModel(nokiaFile.readUTF());
                        nokia.setNetwork(nokiaFile.readUTF());
                        nokia.setMemoryCapacity(nokiaFile.readFloat());
                        nokia.setDisplayType(nokiaFile.readUTF());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        nokiaFile.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                return nokia;
            }
            /**gets the size of one object. Int=4 bytes,Float=4 bytes, character=2 bytes*/
            private long recordSize(){
                return (long)(4+4+((25+ 10+15)*2));
            }
    }
