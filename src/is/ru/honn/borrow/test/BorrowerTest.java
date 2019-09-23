package is.ru.honn.borrow.test;

import is.ru.honn.borrow.Borrow;
import is.ru.honn.borrow.factory.BorrowFactory;
import is.ru.honn.borrow.service.CreateBorrowService;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BorrowerTest {
    public static void main(String[] args) throws IOException, ParseException {

        GregorianCalendar borrowDate = new GregorianCalendar(2019, Calendar.AUGUST, 24);
        GregorianCalendar returnDate = new GregorianCalendar(2019, Calendar.SEPTEMBER, 30);

        Borrow borrow = new Borrow(1, borrowDate.getTime(), returnDate.getTime(), 2);

        BorrowFactory borrowFactory = new BorrowFactory();
        CreateBorrowService createBorrowService = borrowFactory.getBorrowService();
        createBorrowService.createBorrow(borrow);

    }
}
