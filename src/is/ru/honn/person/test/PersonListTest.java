package is.ru.honn.person.test;

import is.ru.honn.person.ListPerson;
import is.ru.honn.publication.ListPublication;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PersonListTest {

    public static void main(String[] args) throws IOException, ParseException {
        GregorianCalendar testing = new GregorianCalendar(2019, Calendar.AUGUST, 26);

        ListPublication listPublication = new ListPublication();
//         = listPublication.findPublicationsByDate(testing.getTime());
        ListPerson listPerson = new ListPerson();
        JSONArray a = listPerson.getMoreThanMonthBorrowers(testing.getTime());
        System.out.println("The following publications were borrowed out on the following date: " + listPublication.formatDate(testing.getTime()));
        System.out.println(listPerson.PersonToStringBuilder());
    }
}
