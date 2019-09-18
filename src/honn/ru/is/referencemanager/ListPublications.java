package honn.ru.is.referencemanager;

// For a particular date, output a ​list of publications​ that are on loan,
// and who borrowed them

import honn.ru.is.referencemanager.fakedata.FakeBorrowers;
import honn.ru.is.referencemanager.test.BorrowerTest;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ListPublications {
    GregorianCalendar lookupDate;
    FakeBorrowers fakeBorrowers = new FakeBorrowers();
    List<Borrower> dummyList = fakeBorrowers.dummyList();

}
