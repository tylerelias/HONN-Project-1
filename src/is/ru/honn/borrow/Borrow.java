package is.ru.honn.borrow;

/*
    Borrower.java
    Registers when a person borrows a publicationID
    We will treat the person's email as its identifier
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class Borrow {
    private int personID;
    private Date borrowDate;
    private Date returnDate;
    private int publicationID;

    public Borrow() {}

    public Borrow(int personID, Date borrowDate, Date returnDate, int publicationID) {
        this.personID = personID;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.publicationID = publicationID;
    }

    //GETTERS

    public int getPersonID() {
        return personID;
    }

    public String getBorrowDate() {
        return formatDate(borrowDate);
    }

    public String getReturnDate() {
        return formatDate(returnDate);
    }

    public int getpublicationID() {
        return publicationID;
    }

    // SETTERS

    public void setBorrowerEmail(int personID) {
        this.personID = personID;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setPublicationID(int publicationID) {
        this.publicationID = publicationID;
    }

    private String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY");
        return format.format(date);
    }

    @Override
    public String toString() {
        return "Borrower ID: " + this.personID + "\n" +
                "Borrow Date: " + formatDate(this.borrowDate) + "\n" +
                "Return Date: " + formatDate(this.returnDate) + "\n" +
                "publicationID: " + this.publicationID + "\n";
    }
}
