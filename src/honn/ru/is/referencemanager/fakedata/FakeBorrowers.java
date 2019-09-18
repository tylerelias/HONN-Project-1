package honn.ru.is.referencemanager.fakedata;

import honn.ru.is.referencemanager.Borrower;

/*
    TEMP SOLUTION TO NO DATA BEING GIVEN AS OF 17/09
    FakeBorrowers.java creates fake examples of borrowers
    and returns a ArrayList of them
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class FakeBorrowers {

    public FakeBorrowers() {}

    public List<Borrower> dummyList() {
        GregorianCalendar d1 = new GregorianCalendar();
        GregorianCalendar d2 = new GregorianCalendar();
        GregorianCalendar d3 = new GregorianCalendar();
        GregorianCalendar d4 = new GregorianCalendar();
        GregorianCalendar d5 = new GregorianCalendar();
        GregorianCalendar d6 = new GregorianCalendar();
        GregorianCalendar d7 = new GregorianCalendar();
        GregorianCalendar d8 = new GregorianCalendar();
        GregorianCalendar d9 = new GregorianCalendar();
        GregorianCalendar d10 = new GregorianCalendar();

        d1.set(2019, Calendar.OCTOBER, 17);
        d2.set(2019, Calendar.NOVEMBER, 17);
        d3.set(2019, Calendar.NOVEMBER, 1);
        d4.set(2019, Calendar.NOVEMBER, 1);
        d5.set(2018, Calendar.NOVEMBER, 17);
        d6.set(2018, Calendar.NOVEMBER, 17);
        d7.set(2019, Calendar.JANUARY, 17);
        d8.set(2019, Calendar.FEBRUARY, 17);
        d9.set(2018, Calendar.MAY, 17);
        d10.set(2018, Calendar.JULY, 17);

        List<Borrower> borrowerList = new ArrayList<>();

        Borrower borrower1 = new Borrower("hi@you.cool", d1.getTime(), d2.getTime(),  "The Title of 42");
        borrowerList.add(borrower1);
        Borrower borrower2 = new Borrower("hi2@you.cool", d3.getTime(), d4.getTime(),  "The Title of 42");
        borrowerList.add(borrower2);
        Borrower borrower3 = new Borrower("hi3@you.cool", d5.getTime(), d6.getTime(),  "The Title of 42");
        borrowerList.add(borrower3);
        Borrower borrower4 = new Borrower("hi4@you.cool", d7.getTime(), d8.getTime(),  "The Title of 42");
        borrowerList.add(borrower4);
        Borrower borrower5 = new Borrower("hi5@you.cool", d9.getTime(), d10.getTime(),  "The Title of 42");
        borrowerList.add(borrower5);

        return borrowerList;
    }
}
