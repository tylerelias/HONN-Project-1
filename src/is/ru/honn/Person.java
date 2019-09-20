package is.ru.honn;

/*
       Borrower.java
       Has the information regarding the person borrowing a publication
 */

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

    // empty constr
    Person() {}

    public Person(int id, String firstName, String lastName, String email, String phoneNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Person(String firstName, String lastName, String email, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // GETTERS

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString() override

    @Override
    public String toString() {
        return "Full Name: " + this.firstName + " " + this.lastName + "\n" +
                "Email: "  + this.email + "\n" +
                "Phone number" + this.phoneNumber + "\n" +
                "Address: " + this.address + "\n";
    }
}
