package honn.ru.is.referencemanager;

/*
    Borrower.java
    Registers when a person borrows a publication
    We will treat the person's email as its identifier
 */

import java.util.Date;

public class Borrower {
    public String borrowerEmail;
    public Date borrowDate;
    public Date returnDate;
    public String publication;

    public Borrower() {}

    public Borrower(String borrowerEmail, Date borrowDate, Date returnDate, String publication) {
        this.borrowerEmail = borrowerEmail;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.publication = publication;
    }

    //GETTERS

    public String getBorrowerEmail() {
        return borrowerEmail;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public String getPublication() {
        return publication;
    }

    // SETTERS

    public void setBorrowerEmail(String borrowerEmail) {
        this.borrowerEmail = borrowerEmail;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "Borrower ID: " + this.borrowerEmail + "\n" +
                "Borrow Date: " + this.borrowDate + "\n" +
                "Return Date: " + this.returnDate + "\n" +
                "Publication: " + this.publication + "\n";
    }
}
