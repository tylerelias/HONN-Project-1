package honn.ru.is.test;

import honn.ru.is.data.ReadPersons;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PersonTest {
    public static void main(String[] args) throws IOException, ParseException {

        ReadPersons readPersons = new ReadPersons();

        JSONArray personsArray = readPersons.getJSONArray();

        System.out.println(personsArray.get(2));
    }
}
