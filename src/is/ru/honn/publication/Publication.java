package is.ru.honn.publication;

public class Publication {
    private String firstName;
    private String lastName;
    private String publicationTitle;
    private String journal;
    private String ISBN;
    private int year;
    private String type;

    public Publication() {
    }

    public Publication(String firstName, String lastName, String publicationTitle, String ISBN, String journal, int year, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.publicationTitle = publicationTitle;
        this.ISBN = ISBN;
        this.journal = journal;
        this.year = year;
        this.type = type;
    }

    //GETTERS

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public String getJournal() {
        return journal;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    //SETTERS

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Editor: " + this.firstName + " " + this.lastName + "\n" +
                "Title: " + this.publicationTitle + "\n" +
                "ISBN: " + this.ISBN + "\n" +
                "Journal: " + this.journal + "\n" +
                "Year: " + this.year + "\n" +
                "Type: " + this.type + "\n";
    }
}
