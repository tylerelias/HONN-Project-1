package is.ru.honn.person;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
    CreatePerson.java
    Creates a new instance of Person and adds it to the Person JSON file
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreatePerson extends AbstractCreatePerson {
    // We need to read the current highest ID from the JSON file
    private ReadPerson readPerson = new ReadPerson();

    public CreatePerson() throws IOException, ParseException { }

    // AddPerson() Takes in the Person class and puts it in a JSON object and writes it to the file.
    public void AddPerson(Person person) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        Object object = jsonParser.parse(new FileReader(getFilePath()));
        JSONArray jsonArray = (JSONArray) object;

        JSONObject addPerson = new JSONObject();
        addPerson.put("id", GetCurrentId() + 1);
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

    // Needed to increment the ID when writing a new Person to the JSON file
    public int GetCurrentId() throws IOException, ParseException {
        return readPerson.getJSONArray().size();
    }
}
