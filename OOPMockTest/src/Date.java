/**
 * Created by Khalin on 10/14/2016.
 */
public class Date {
    private int day;
    private int month;
    private int year;

    public Date(){
        setDay(1);
        setMonth(1);
        setYear(2000);
    }
    public Date(int day, int month, int year){
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    public Date(Date date){
        setDay(date.getDay());
        setMonth(date.getMonth());
        setYear(date.getYear());
    }

    public int getDay () {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

public String toString(){
    String string="";
    string+=day+"/";
    string+=month+"/";
    string+=year;
    return string;
}
}
