package is.ru.honn.publication.test;

import is.ru.honn.publication.ListPublication;
import is.ru.honn.publication.ReadPublication;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PublicationTest {
    public static void main(String[] args) throws IOException, ParseException {

        ReadPublication readPublication = new ReadPublication();

        JSONArray publicationArray = readPublication.getJSONArray();

        //This test should fail since year is less than 0
//        if(publication1.getYear() < 0) {
//            throw new PublicationException("Year must be a positive number");
//        }

//        CreatePublication createPublication = new CreatePublication();
//        createPublication.AddPublication("FristName", "LastName", "The Title",
//                                         "12345-33", "electronic", 2019, "Very Int");
        // Check the current highest ID in the JSON file
//        System.out.println("Current ID " + createPublication.getCurrentId());

        GregorianCalendar testing = new GregorianCalendar(2019, Calendar.SEPTEMBER, 30);
        ListPublication listPublication = new ListPublication();

        JSONArray a = listPublication.findPublicationsByDate(testing.getTime());
        System.out.println("The following publications were borrowed out on the following date: " + listPublication.formatDate(testing.getTime()));
        System.out.println(listPublication.PublicationToStringBuilder());

    }
}
