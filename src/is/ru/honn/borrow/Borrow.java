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
    private String personName;
    private String publicationName;

    public Borrow() {}

    public Borrow(int personID, String personName, Date borrowDate, Date returnDate, int publicationID, String publicationName) {
        this.personID = personID;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.publicationID = publicationID;
        this.personName = personName;
        this.publicationName = publicationName;
    }

    //GETTERS

    public String getPublicationName() {
        return publicationName;
    }

    public int getPersonID() {
        return personID;
    }

    public String getBorrowDate() {
        return formatDate(borrowDate);
    }

    public String getReturnDate() {
        return formatDate(returnDate);
    }

    public int getPublicationID() {
        return publicationID;
    }

    public String getPersonName() {
        return personName;
    }

    // SETTERS

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

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

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY");
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
