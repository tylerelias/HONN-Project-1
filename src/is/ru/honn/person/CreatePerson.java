package is.ru.honn.person;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreatePerson extends AbstractCreatePerson {

    private ReadPerson readPerson = new ReadPerson();

    public CreatePerson() throws IOException, ParseException { }

    public void AddPerson(Person person) throws IOException, ParseException {
        //PersonService personService = new PersonFactory().getPersonService();
        JSONParser jsonParser = new JSONParser();

        Object object = jsonParser.parse(new FileReader(getFilePath()));
        JSONArray jsonArray = (JSONArray) object;

        JSONObject addPerson = new JSONObject();
        addPerson.put("id", getCurrentId() + 1);
        addPerson.put("first_name", person.getFirstName());
        addPerson.put("last_name", person.getLastName());
        addPerson.put("email", person.getEmail());
        addPerson.put("phone", person.getPhoneNumber());
        addPerson.put("address", person.getAddress());

        jsonArray.add(addPerson);

        FileWriter file = new FileWriter(getFilePath());
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }

    public int getCurrentId() throws IOException, ParseException {
        return readPerson.getJSONArray().size();
    }
}
