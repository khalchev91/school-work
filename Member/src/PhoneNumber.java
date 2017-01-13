/**
 * Created by Khalin on 9/16/2016.
    1501396

 */
public class PhoneNumber {

    private String areaCode;
    private String exchange;
    private String line;

    public PhoneNumber() throws Exception{
        setAreaCode("000");
        setExchange("000");
        setLine("0000");
    }

    public PhoneNumber(String areaCode, String exchange, String line) throws Exception{
        setAreaCode(areaCode);
        setExchange(exchange);
        setLine(line);
    }

    public PhoneNumber(PhoneNumber obj) throws Exception{
        setAreaCode(obj.areaCode);
        setExchange(obj.exchange);
        setLine(obj.line);
    }

    public String toString() {
        String out;
        out = "(" + areaCode + ")" + exchange + "-" + line;
        return out;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getExchange() {
        return exchange;
    }

    public String getLine() {
        return line;
    }

    public void setAreaCode(String areaCode) throws Exception{
       if (areaCode.length() != 3) {
            //System.err.println("Invalid Area Code");
            //this.areaCode = "000";
            throw new Exception("PhoneNumber area code invalid");
        } else {
            this.areaCode = areaCode;
        }
    }

    public void setExchange(String exchange) throws Exception{
        if (exchange.length() != 3) {
            //System.err.println("Invalid Exchange");
            //this.exchange = "000";
throw new Exception("Invalid Exchange entered");
        } else {
            this.exchange = exchange;
        }
    }

    public void setLine(String line) throws Exception{
        if (line.length() != 4) {
            //System.err.println("Invalid Line");//System.err.println is the error stream used to output errors to the user
            //this.line = "0000";
            throw new Exception("Invalid Line number entered");
        } else {
            this.line = line;
        }
    }
}