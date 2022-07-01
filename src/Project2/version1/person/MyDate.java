package Project2.version1.person;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class MyDate implements Serializable {

    private int year;

    private int month;

    private int day;

    public MyDate() {
        year = new GregorianCalendar().get(GregorianCalendar.YEAR);
        month = new GregorianCalendar().get(GregorianCalendar.MONTH);
        day = new GregorianCalendar().get(GregorianCalendar.DAY_OF_MONTH);
    }

    public MyDate(long elapsedTime) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(elapsedTime);
        year = gregorianCalendar.get(GregorianCalendar.YEAR);
        month = gregorianCalendar.get(GregorianCalendar.MONTH);
        day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public void setDate(long elapsedTime) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(elapsedTime);
        year = gregorianCalendar.get(GregorianCalendar.YEAR);
        month = gregorianCalendar.get(GregorianCalendar.MONTH);
        day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    @Override
    public String toString() {
        return year + "年" + (month + 1) + "月" + day + "日";
    }
}
