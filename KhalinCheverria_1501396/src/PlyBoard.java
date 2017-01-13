import sun.plugin2.main.server.Plugin;

/**
 * Created by Khalin on 11/25/2016.
 */
public class PlyBoard  extends Product{
private float length;
private float width;
private float thickness;

public PlyBoard(){
    super();
    setLength(10);
    setWidth(10);
    setThickness(2);
}
public PlyBoard(int code, String name,float unitCost, float inLength, float inWidth, float inThickness){
    super(code, name,unitCost);
    setLength(inLength);
    setWidth(inWidth);
    setThickness(inThickness);
}
public PlyBoard(PlyBoard plyBoard){
    super(plyBoard);
    setLength(plyBoard.getLength());
    setWidth(plyBoard.getWidth());
    setThickness(plyBoard.getThickness());
}
@Override
public String toString(){
String plyboard="";
plyboard+=super.toString();
plyboard+="Length: "+getLength()+"\n";
plyboard+="Width: "+getWidth()+"\n";
plyboard+="Thickness: "+getThickness()+"\n";
return plyboard;
}

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }
}
