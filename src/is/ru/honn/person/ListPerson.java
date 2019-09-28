package is.ru.honn.person;

import is.ru.honn.borrow.DatesBorrow;
import is.ru.honn.publication.ListPublication;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Date;

public class ListPerson {
    private static final int MORE_THAN_ONE_MONTH = 3; // In the code, 3 would not be descriptive of its functionality
    private static final int DECEMBER = 12;
    private static final int JANUARY = 1;
    private ListPublication listPublication;
    private JSONArray matchesArray;

    public ListPerson() throws IOException, ParseException {
        listPublication = new ListPublication();
        matchesArray    = new JSONArray();
    }

    public JSONArray getMoreThanMonthBorrowers(Date lookupDate) throws IOException, ParseException {
        JSONArray monthOrMoreArray = new JSONArray();
        matchesArray = listPublication.findPublicationsByDate(lookupDate);

        DatesBorrow borrowDate;
        DatesBorrow returnDate;

        for (int i = 0; i < matchesArray.size(); i++) {
            // Using a function from ListPublication to prevent code duplication, perhaps a general
            // helper class with getDatesFromJSONObject() is better?
            borrowDate = listPublication.getDatesFromJSONObject(i, "borrow_date");
            returnDate = listPublication.getDatesFromJSONObject(i, "return_date");

            if (isBorrowedForMoreThanOneMonth(borrowDate, returnDate)) {
                monthOrMoreArray.add(matchesArray.get(i));
            }
        }
        return monthOrMoreArray;
    }

    private boolean isBorrowedForMoreThanOneMonth(DatesBorrow borrowDate, DatesBorrow returnDate) {
        int     borrowYear  = borrowDate.getYear(),
                borrowMonth = borrowDate.getMonth(),
                borrowDay   = borrowDate.getDay(),
                returnYear  = returnDate.getYear(),
                returnMonth = returnDate.getMonth(),
                returnDay   = returnDate.getDay();

        // There is an edge case for publications that were borrowed the previous year of its return
        // If it was borrowed in December and returned in January next year, it needs to be checked if
        // it has been borrowed for more than 4 * 7 + 1 days
        if (borrowYear < returnYear) {
            if (borrowMonth == DECEMBER && returnMonth == JANUARY) {
                // Any value above 3 when returnDay - borrowDay is calculated, is a value you get
                // if the dates are not 4 weeks and 1 day apart
                if ((returnDay - borrowDay) > MORE_THAN_ONE_MONTH) {
                    return true;
                }
            }
            return true;
        }
        if (borrowYear == returnYear) {
            // If there is more than a month gap between the borrowing and returning
            // we known for sure that the book was borrowed for more then one month
            if ((returnMonth - borrowMonth) > 1) {
                return true;
            }
            // We know that if the borrow and return took place at the same month
            // then its not possible to have had it for more than a month
            if (borrowMonth == returnMonth) {
                return false;
            }
            // If the borrowing and return took place in two consecutive months we need to
            // check it it was borrowed for 4 or more weeks
            if (returnMonth - borrowMonth == 1) {
                if ((returnDay - borrowDay) > MORE_THAN_ONE_MONTH) {
                    return true;
                }
            }
        }
        return false;
    }

    // This lists the people who have borrowed a publication for a given date,
    // and which publication they borrowed.
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
                    .append("\n\n\n");

        }
        return text;
    }
}
