/**
 * Created by Khalin on 11/25/2016.
 */
public class Product {
    private int code;
    private String name;
    private float unitCost;

    public Product(){
        setCode(1);
        setName("Product");
        setUnitCost(0);
    }

public Product(int inCode, String inName, float inUnitCost){
        setCode(inCode);
        setName(inName);
        setUnitCost(inUnitCost);
}
public Product(Product product){
    setCode(product.getCode());
    setName(product.getName());
    setUnitCost(product.getUnitCost());
}
public String toString(){
    String product="";
    product+="Product Code: "+getCode()+"\n";
product+="Product Name: "+getName()+"\n";
product+="Product Unit Cost: "+getUnitCost()+"\n";
return product;
}
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(float unitCost) {
        this.unitCost = unitCost;
    }
}
