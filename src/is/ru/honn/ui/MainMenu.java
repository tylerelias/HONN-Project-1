package is.ru.honn.ui;

import is.ru.honn.borrow.Borrow;
import is.ru.honn.borrow.CreateBorrow;
import is.ru.honn.person.CreatePerson;
import is.ru.honn.person.ListPerson;
import is.ru.honn.person.Person;
import is.ru.honn.publication.CreatePublication;
import is.ru.honn.publication.ListPublication;
import is.ru.honn.publication.Publication;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;

public class MainMenu {

    public MainMenu() {
    }

    public void DisplayMenu() throws IOException, ParseException {

        HomeLayout();

        int input = ReadInputInteger();

        switch (input) {
            case 1:
                DisplayPeopleRegistryMenu();
                break;
            case 2:
                DisplayPublicationRegistryMenu();
                break;
            case 3:
                DisplayBorrowingMenu();
                break;
            case 4:
                DisplayListOfPublicationByDateMenu();
                break;
            case 5:
                DisplayListOfBorrowersByDateMenu();
                break;
            case 6:
                DisplayListOfPeopleBorrowingForMoreThanMonth();
                break;
        }
    }


    private void HomeLayout() {
        System.out.println("\t\t==============================================");
        System.out.println("\t\tWelcome to Tyler's Academic Reference Manager!");
        System.out.println("\t\t==============================================");
        System.out.println("Please type in the number, for the action you want to execute");
        System.out.println("\t1: Register a person");
        System.out.println("\t2: Register a publication");
        System.out.println("\t3: Register a borrowed publication");
        System.out.println("\t4: List publications that are out on loan by date");
        System.out.println("\t5: List who is borrowing a publication by date");
        System.out.println("\t6: List people who have borrowed a publication for more than a month");
    }

    private void DisplayPeopleRegistryMenu() throws IOException, ParseException {

        Person person = new Person();

        System.out.println("\t\t==============================================");
        System.out.println("\t\t            Register a new Person             ");
        System.out.println("\t\t==============================================");
        System.out.println("\t\tPlease fill in the following details");

        System.out.print("First Name: ");
        person.setFirstName(ReadInputString());
        System.out.print("Last Name: ");
        person.setLastName(ReadInputString());
        System.out.print("Email: ");
        person.setEmail(ReadInputString());
        System.out.print("Phone Number: ");
        person.setPhoneNumber(ReadInputString());
        System.out.print("Address: ");
        person.setAddress(ReadInputString());

        CreatePerson createPerson = new CreatePerson();
        createPerson.AddPerson(person);

        //TODO: Throw into a function
        System.out.println("The Person has been created! Welcome to the system:");
        System.out.println("First Name: " + person.getFirstName());
        System.out.println("Last Name: " + person.getLastName());
        System.out.println("Email: " + person.getEmail());
        System.out.println("Phone Number: " + person.getPhoneNumber());
        System.out.println("Address: " + person.getAddress());
    }

    private void DisplayPublicationRegistryMenu() throws IOException, ParseException {

        Publication publication = new Publication();

        System.out.println("\t\t==============================================");
        System.out.println("\t\t            Register a new Person             ");
        System.out.println("\t\t==============================================");
        System.out.println("\t\tPlease fill in the following details");

        System.out.print("First Name: ");
        publication.setFirstName(ReadInputString());
        System.out.print("Last Name: ");
        publication.setLastName(ReadInputString());
        System.out.print("Publication Title: ");
        publication.setPublicationTitle(ReadInputString());
        System.out.print("ISBN: ");
        publication.setISBN(ReadInputString());
        System.out.print("Journal: ");
        publication.setJournal(ReadInputString());
        System.out.print("Year: ");
        publication.setYear(ReadInputInteger());
        System.out.print("Type: ");

        while (true) {
            String input = ReadInputString();
            if (!input.matches("printed|electronic")) {
                System.out.println("Invalid Type! 'printed' and 'electronic' are valid");
            } else {
                publication.setType(input);
                break;
            }
            System.out.print("Type: ");
        }

        CreatePublication createPublication = new CreatePublication();
        createPublication.AddPublication(publication);

        //TODO: Throw into a function
        System.out.println("Publication has been created");
        System.out.println("First Name: " + publication.getFirstName());
        System.out.println("Last Name: " + publication.getLastName());
        System.out.println("Publication Title: " + publication.getPublicationTitle());
        System.out.println("ISBN: " + publication.getISBN());
        System.out.println("Journal: " + publication.getJournal());
        System.out.println("Type: " + publication.getType());
    }

    private void DisplayBorrowingMenu() throws IOException, ParseException {
        int publicationId;

        System.out.println("\t\t==============================================");
        System.out.println("\t\t          Register a new Borrower             ");
        System.out.println("\t\t==============================================");
        System.out.println("\t\tPlease fill in the following details");

        Borrow borrow = new Borrow();

        System.out.print("Person Name: ");
        borrow.setPersonName(ReadInputString());

       System.out.println("Insert the following information for Borrowing Date:");
        borrow.setBorrowDate(ReadInputDate().getTime());

        System.out.println("Insert the following information for Return Date:");
        borrow.setReturnDate(ReadInputDate().getTime());

        CreatePublication createPublication = new CreatePublication();

        while(true) {
            System.out.print("Publication ID: ");
            publicationId = ReadInputInteger();
            if (publicationId < 1 || publicationId > createPublication.getCurrentId()) {
                System.out.println("Incorrect ID, please enter a valid ID.3");
            } else break;
        }
        borrow.setPublicationID(publicationId);

        System.out.print("Publication Name: ");
        borrow.setPersonName(ReadInputString());

        CreateBorrow createBorrow = new CreateBorrow();
        createBorrow.createBorrow(borrow);

        //TODO: Throw into a function
        System.out.println("Borrowing has been created:");
        System.out.println("Person's ID: " + borrow.getPersonID());
        System.out.println("Person's Name: " + borrow.getPersonName());
        System.out.println("Borrow Date: " + borrow.getBorrowDate());
        System.out.println("Return Date: " + borrow.getReturnDate());
        System.out.println("Publication ID: " + borrow.getPublicationID());
        System.out.println("Publication Name: " + borrow.getPersonName());


    }

    private void DisplayListOfPublicationByDateMenu() throws IOException, ParseException {

        System.out.println("\t\t==============================================");
        System.out.println("\t\tList Publications that are out on loan by date");
        System.out.println("\t\t==============================================");
        System.out.println("Enter the date to look up:");

        ListPublication listPublication = new ListPublication();
        listPublication.findPublicationsByDate(ReadInputDate().getTime());

        System.out.println("\nThe following matches came up:\n");
        System.out.println(listPublication.PublicationToStringBuilder());
    }

    private void DisplayListOfBorrowersByDateMenu() throws IOException, ParseException {

        System.out.println("\t\t========================================================");
        System.out.println("\t\tList Persons that took out publications at a given date");
        System.out.println("\t\t========================================================");
        System.out.println("Enter the date to look up:");

        ListPerson listPerson = new ListPerson();
        listPerson.getMoreThanMonthBorrowers(ReadInputDate().getTime());

        System.out.println("\nThe following matches came up:\n");
        System.out.println(listPerson.PersonToStringBuilder());
    }

    private void DisplayListOfPeopleBorrowingForMoreThanMonth() {
        System.out.println("\t\t========================================================");
        System.out.println("\t\t List Persons that have borrowed for more than a month");
        System.out.println("\t\t========================================================");
        System.out.println("Enter the date to look up:");

    }

    private String ReadInputString() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    private int ReadInputInteger() throws IOException {
        int input;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = Integer.parseInt(bufferedReader.readLine());
            return input;
        } catch (NumberFormatException e) {
            System.err.println("Input was not numeric, try again");
        }
        return 0;
    }

    private GregorianCalendar ReadInputDate() throws IOException {
        int day   = 0;
        int month = 0;
        int year  = 0;

        while(day <= 0 || day >= 31) {
            System.out.print("Date - DAY (Numeric 1 -31): ");
            day = ReadInputInteger();
        }
        while(month <= 0 || month > 12) {
            System.out.print("Date - MONTH (Numeric 1-12): ");
            month = ReadInputInteger();
        }
        while(year < 1900 || year > 2099) {
            System.out.print("Date - YEAR (Numeric 1900-2099: ");
            year = ReadInputInteger();
        }
        return new GregorianCalendar(year, month - 1, day);
    }
}
