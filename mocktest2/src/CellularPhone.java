/**
 * Created by Khalin on 11/18/2016.
 */
public abstract class CellularPhone {
    private int imei;
    private String model;
    private String network;

    public CellularPhone(){
        setImei(1000);
        setModel("Some model");
        setNetwork("Digicel");
    }
    public CellularPhone(int inImei,String inModel, String inNetwork){
        setImei(inImei);
        setModel(inModel);
        setNetwork(inNetwork);
    }
public CellularPhone(CellularPhone cellularPhone){
    setImei(cellularPhone.getImei());
    setModel(cellularPhone.getModel());
    setNetwork(cellularPhone.getNetwork());
}
public String toString(){
    String phone= "";
    phone+="IMEI: "+getImei()+"\n";
    phone+="Model: "+getModel()+"\n";
    phone+="Network: "+getNetwork()+"\n";
    return phone;
}
public int getImei() {
        return imei;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public abstract void writeToFile();
    public abstract void initializeToFile();
    public abstract CellularPhone readFromFile(int imei);
}
