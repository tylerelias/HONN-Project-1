package is.ru.honn.test;

import is.ru.honn.data.CreatePublication;
import is.ru.honn.data.ReadPublications;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PublicationTest {
    public static void main(String[] args) throws IOException, ParseException {

        ReadPublications readPublications = new ReadPublications();

        JSONArray publicationArray = readPublications.getJSONArray();


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
