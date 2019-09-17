package honn.ru.is.referencemanager.test;

import honn.ru.is.referencemanager.Borrower;
import honn.ru.is.referencemanager.fakedata.FakeBorrowers;

import java.util.List;

public class BorrowerTest {
    public static void main(String[] args) {

        FakeBorrowers fakeBorrowers = new FakeBorrowers();

        List<Borrower> borrowerList = fakeBorrowers.dummyList();

        for (Borrower borrower : borrowerList) {
            System.out.println(borrower.toString());
        }
    }


}
