package is.ru.honn.borrow.test;

import is.ru.honn.borrow.Borrow;
import is.ru.honn.borrow.ReadBorrow;
import is.ru.honn.borrow.factory.BorrowFactory;
import is.ru.honn.borrow.service.CreateBorrowService;
import is.ru.honn.publication.ListPublication;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BorrowerTest {
    public static void main(String[] args) throws IOException, ParseException {

        GregorianCalendar borrowDate1 = new GregorianCalendar(2019, Calendar.AUGUST, 24);
        GregorianCalendar returnDate1 = new GregorianCalendar(2019, Calendar.SEPTEMBER, 30);
        GregorianCalendar borrowDate2 = new GregorianCalendar(2019, Calendar.JANUARY, 1);
        GregorianCalendar returnDate2 = new GregorianCalendar(2019, Calendar.MARCH, 30);
        GregorianCalendar borrowDate3 = new GregorianCalendar(2019, Calendar.FEBRUARY, 24);
        GregorianCalendar returnDate3 = new GregorianCalendar(2019, Calendar.MARCH, 30);
        GregorianCalendar borrowDate4 = new GregorianCalendar(2019, Calendar.MARCH, 24);
        GregorianCalendar returnDate4 = new GregorianCalendar(2019, Calendar.AUGUST, 30);
        GregorianCalendar borrowDate5 = new GregorianCalendar(2019, Calendar.SEPTEMBER, 24);
        GregorianCalendar returnDate5 = new GregorianCalendar(2019, Calendar.OCTOBER, 30);
        GregorianCalendar borrowDate6 = new GregorianCalendar(2019, Calendar.NOVEMBER, 24);
        GregorianCalendar returnDate6 = new GregorianCalendar(2019, Calendar.DECEMBER, 30);
        GregorianCalendar borrowDate7 = new GregorianCalendar(2019, Calendar.JUNE, 24);
        GregorianCalendar returnDate7 = new GregorianCalendar(2019, Calendar.JULY, 30);
        GregorianCalendar borrowDate8 = new GregorianCalendar(2018, Calendar.JUNE, 24);
        GregorianCalendar returnDate8 = new GregorianCalendar(2019, Calendar.DECEMBER, 30);

        GregorianCalendar testing = new GregorianCalendar(2019, Calendar.DECEMBER, 30);

        Borrow borrow1 = new Borrow(1, "Bubbi", borrowDate1.getTime(), returnDate1.getTime(), 2, "placeholder");
        Borrow borrow2 = new Borrow(2, "Daddi", borrowDate2.getTime(), returnDate2.getTime(), 3, "notaplaceholder");
        Borrow borrow3 = new Borrow(3, "Guggi", borrowDate3.getTime(), returnDate3.getTime(), 4, "DefinaetlyAPlaceHolder");
        Borrow borrow4 = new Borrow(4, "Muggi", borrowDate4.getTime(), returnDate4.getTime(), 5, "Good Name");
        Borrow borrow5 = new Borrow(5, "Beggi", borrowDate5.getTime(), returnDate5.getTime(), 6, "Better Name");
        Borrow borrow6 = new Borrow(6, "Darri", borrowDate6.getTime(), returnDate6.getTime(), 7, "BestName");
        Borrow borrow7 = new Borrow(7, "John Smith", borrowDate7.getTime(), returnDate7.getTime(), 8, "Some publication");
        Borrow borrow8 = new Borrow(8, "Sparri", borrowDate8.getTime(), returnDate8.getTime(), 9, "No Name");

        BorrowFactory borrowFactory = new BorrowFactory();
        CreateBorrowService createBorrowService = borrowFactory.getBorrowService();
//        createBorrowService.createBorrow(borrow1);
//        createBorrowService.createBorrow(borrow2);
//        createBorrowService.createBorrow(borrow3);
//        createBorrowService.createBorrow(borrow4);
//        createBorrowService.createBorrow(borrow5);
//        createBorrowService.createBorrow(borrow6);
//       createBorrowService.createBorrow(borrow7);
//        createBorrowService.createBorrow(borrow8);

        ReadBorrow readBorrow = new ReadBorrow();
        JSONArray borrowArray = readBorrow.getJSONArray();
        System.out.println(borrowArray);

        ListPublication listPublication = new ListPublication();
        JSONArray a = listPublication.findPublicationsByDate(testing.getTime());
        System.out.println(listPublication.toStringBuilder());
//        for(int i = 0; i < a.size(); i++) {
//            System.out.println(a.get(i));
//        }


    }
}
