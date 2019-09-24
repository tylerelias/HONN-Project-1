package is.ru.honn.borrow;

public class DatesBorrow {

    private int year, month, day;

    public DatesBorrow() {}

    DatesBorrow (int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // GETTERS

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    //SETTERS

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
