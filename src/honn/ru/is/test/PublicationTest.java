package honn.ru.is.test;

import honn.ru.is.data.ReadPublications;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PublicationTest {
    public static void main(String[] args) throws IOException, ParseException {

        ReadPublications readPublications = new ReadPublications();

        JSONArray publicationArray = readPublications.getJSONArray();

        System.out.println(publicationArray.get(2));

        //This test should fail since year is less than 0
//        if(publication1.getYear() < 0) {
//            throw new PublicationException("Year must be a positive number");
//        }

    }
}
