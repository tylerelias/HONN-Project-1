package is.ru.honn.publication.test;

import is.ru.honn.publication.CreatePublication;
import is.ru.honn.publication.ReadPublication;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PublicationTest {
    public static void main(String[] args) throws IOException, ParseException {

        ReadPublication readPublication = new ReadPublication();

        JSONArray publicationArray = readPublication.getJSONArray();


        //This test should fail since year is less than 0
//        if(publication1.getYear() < 0) {
//            throw new PublicationException("Year must be a positive number");
//        }

        CreatePublication createPublication = new CreatePublication();
        createPublication.AddPublication("FristName", "LastName", "The Title",
                                         "12345-33", "electronic", 2019, "Very Int");
        System.out.println("Current ID " + createPublication.getCurrentId());


    }
}
