package is.ru.honn.test;

import is.ru.honn.Person;
import is.ru.honn.data.CreatePerson;
import is.ru.honn.data.ReadPersons;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PersonTest {
    public static void main(String[] args) throws IOException, ParseException {

        ReadPersons readPersons = new ReadPersons();

        JSONArray personsArray = readPersons.getJSONArray();


        JSONObject jsonObject = readPersons.getJSONObjectByIndex(1);


        CreatePerson createPerson = new CreatePerson();
        System.out.println("Current ID " + createPerson.getCurrentId());

        Person person = new Person("Hello", "World", "hello@world.com", "555 444 333", "Home 33");

        createPerson.AddPerson(person);

        System.out.println(personsArray.toJSONString());

        System.out.println("Current ID " + createPerson.getCurrentId());
        System.out.println(personsArray.get(2));
        System.out.println(jsonObject.get("address"));
    }
}
