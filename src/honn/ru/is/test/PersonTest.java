package honn.ru.is.test;

import honn.ru.is.Person;
import honn.ru.is.data.ReadPersons;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PersonTest {
    public static void main(String[] args) throws IOException, ParseException {

        ReadPersons readPersons = new ReadPersons();

        Person person1 = new Person("Tyler", "Jones", "Hi@you.cool", "222-3333", "Home 42");
        System.out.print(person1.toString());
    }
}
