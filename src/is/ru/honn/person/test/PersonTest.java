package is.ru.honn.person.test;

import is.ru.honn.person.Person;
import is.ru.honn.person.CreatePerson;
import is.ru.honn.person.ReadPerson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PersonTest {
    public static void main(String[] args) throws IOException, ParseException {

        ReadPerson readPerson = new ReadPerson();

        JSONArray personsArray = readPerson.getJSONArray();


        JSONObject jsonObject = readPerson.getJSONObjectByIndex(1);


        CreatePerson createPerson = new CreatePerson();
        System.out.println("Current ID " + createPerson.GetCurrentId());

        Person person = new Person("John", "Smith", "hello@world.com", "555 444 333", "Home 33");

        createPerson.AddPerson(person);

        System.out.println(personsArray.toJSONString());

        System.out.println("Current ID " + createPerson.GetCurrentId());
        System.out.println(personsArray.get(2));
        System.out.println(jsonObject.get("address"));
    }
}
