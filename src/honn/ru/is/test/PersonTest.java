package honn.ru.is.test;

import honn.ru.is.data.CreatePerson;
import honn.ru.is.data.ReadPersons;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PersonTest {
    public static void main(String[] args) throws IOException, ParseException {

        ReadPersons readPersons = new ReadPersons();

        JSONArray personsArray = readPersons.getJSONArray();

        System.out.println(personsArray.get(2));

        JSONObject jsonObject = readPersons.getJSONObjectByIndex(1);

        System.out.println(jsonObject.get("address"));

        CreatePerson createPerson = new CreatePerson();
        System.out.println("Current ID" + createPerson.getCurrentId());

        createPerson.AddPerson("Hello", "World", "hello@world.com", "555 444 333", "Home 33");

    }
}
