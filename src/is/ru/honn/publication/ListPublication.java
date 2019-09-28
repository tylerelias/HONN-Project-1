package is.ru.honn.publication;

// For a particular date, output a ​list of publications​ that are on loan,
// and who borrowed them

import is.ru.honn.borrow.DatesBorrow;
import is.ru.honn.borrow.ReadBorrow;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ListPublication {
    private Date lookupDate;        // The date that is being looked up
    private int year, month, day;   // Convert the date from string to integers
    private Calendar calendar;      // Helps us get numeric values for dates
    private ReadBorrow readBorrow;  // Reads the Borrow JSON file
    private JSONArray matchesArray; // The array of people who borrowed on a specific date

    public ListPublication() throws IOException, ParseException {
        calendar     = new GregorianCalendar();
        readBorrow   = new ReadBorrow();
        matchesArray = new JSONArray();
    }

    public JSONArray findPublicationsByDate(Date lookupDate) throws IOException, ParseException {
        // This is a little messy, but there needs to be a lot of conversion because
        // JSON doesn't have a standard Date format
        this.lookupDate = lookupDate;
        calendar.setTime(lookupDate);               // Convert the Lookup Date to Calendar format
        this.year       = calendar.get(Calendar.YEAR);    // Converting the dates to numeric values
        this.month      = calendar.get(Calendar.MONTH);
        this.day        = calendar.get(Calendar.DAY_OF_MONTH);

        DatesBorrow borrowDate;
        DatesBorrow returnDate;

        JSONArray borrowerJSONArray = readBorrow.getJSONArray();

        for (int i = 0; i < borrowerJSONArray.size(); i++) {
            // The Dates for the arrays is indexed as follows [0] = day, [1] = month, [2] = year
            borrowDate = getDatesFromJSONObject(i, "borrow_date"); // Get the borrow dates into an int array
            returnDate = getDatesFromJSONObject(i, "return_date"); // Get the return dates into an int array
            //first it needs to be checked if the book was borrowed on the same date, or before the given date
            if (IsBorrowedOnDate(borrowDate)) {
                //second we need to check if the book has a return date on the given date or after it
                if (IsReturnedOnDate(returnDate)) {
                    matchesArray.add(borrowerJSONArray.get(i));
                }
            }
        }
        return matchesArray;
    }

    // getReturnDate() parses the 'return_date' string to integers
    // this makes the handling of date comparison simpler
    // returns the DatesBorrow class with the values needed
    public DatesBorrow getDatesFromJSONObject(int index, String objectName) throws IOException, ParseException {

        String jsonString; // A string to read the date from the JSON file
        DatesBorrow datesBorrow = new DatesBorrow();
        JSONObject jsonObject = readBorrow.getJOSNObjectByIndex(index);
        jsonString = jsonObject.get(objectName).toString();
        String[] returnDateArray = jsonString.split("-"); // Split the DD-MM-YYYY format to separate String values

        for (int i = 0; i < returnDateArray.length; i++) {
            switch (i) { // Place the split strings into the correct date fields in the DatesBorrow class
                case 0:
                    datesBorrow.setDay(Integer.parseInt(returnDateArray[i]));
                case 1:
                    datesBorrow.setMonth(Integer.parseInt(returnDateArray[i]));
                case 2:
                    datesBorrow.setYear(Integer.parseInt(returnDateArray[i]));
            }
        }
        return datesBorrow;
    }

    private boolean IsBorrowedOnDate(DatesBorrow borrowDate) {
        // If the year we are looking up is higher than the lookup borrow date, we know that the borrowing
        // took place before the Lookup Date
        if (this.year > borrowDate.getYear()) {
            return true;
        }
        if(borrowDate.getYear() == this.year && borrowDate.getMonth() - 1 == this.month && borrowDate.getDay() <= this.day) {
            return true;
        }
        // We need to check to see of the borrowing date is NOT higher than the Lookup date
        if (borrowDate.getYear() == this.year  && borrowDate.getMonth() - 1 < this.month) {
            return true;
        }
        else return false;
    }

    private boolean IsReturnedOnDate(DatesBorrow returnDate) {
        if(this.year <= returnDate.getYear() && this.month < returnDate.getMonth()) {
            return true;
        }
        // We need to check if the Lookup Date is lower than or equal to the return date
        if (this.year <= returnDate.getYear() && this.month  == returnDate.getMonth() - 1 && this.day <= returnDate.getDay()) {
            return true;
        }
        else return false;
    }

    // GETTERS

    public int getYear() {
        return year;
    }

    public Date getLookupDate() {
        return lookupDate;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    //SETTERS

    public void setYear(int year) {
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setLookupDate(Date lookupDate) {
        this.lookupDate = lookupDate;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY");
        return format.format(date);
    }

    // This lists the publications that are out on loan for a given date, and who borrowed them
    public StringBuilder PublicationToStringBuilder() {

        StringBuilder text = new StringBuilder();
        JSONObject jsonObject;

        for (int i = 0; i < matchesArray.size(); i++) {
            jsonObject = (JSONObject)matchesArray.get(i);
            text
                    .append("Borrower Name: ")
                    .append(jsonObject.get("person_name"))
                    .append("\nPublication: ")
                    .append(jsonObject.get("publication_name"))
                    .append("\nBorrow Date: ")
                    .append(jsonObject.get("borrow_date"))
                    .append("\nReturn Date: ")
                    .append(jsonObject.get("return_date"))
                    .append("\n\n");

        }
        return text;
    }

    public StringBuilder PersonToStringBuilder() {

        StringBuilder text = new StringBuilder();
        JSONObject jsonObject;

        for (int i = 0; i < matchesArray.size(); i++) {
            jsonObject = (JSONObject)matchesArray.get(i);
            text
                    .append("Publication: ")
                    .append(jsonObject.get("publication_name"))
                    .append("\nBorrower Name: ")
                    .append(jsonObject.get("person_name"))
                    .append("\nBorrow Date: ")
                    .append(jsonObject.get("borrow_date"))
                    .append("\nReturn Date: ")
                    .append(jsonObject.get("return_date"))
                    .append("\n\n");
        }
        return text;
    }
}
