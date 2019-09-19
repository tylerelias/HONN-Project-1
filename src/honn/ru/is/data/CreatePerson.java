package honn.ru.is.data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class CreatePerson {

    private JSONArray jsonArray = new JSONArray();
    private ReadPersons readPersons = new ReadPersons();

    public CreatePerson() throws IOException, ParseException {
        jsonArray = readPersons.getJSONArray();
    }

    public void AddPerson(String firstName, String lastName, String email, String phoneNumber, String address) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", getCurrentId() + 1);
        jsonObject.put("first_name", firstName);
        jsonObject.put("last_name", lastName);
        jsonObject.put("email", email);
        jsonObject.put("phone", phoneNumber);
        jsonObject.put("address", address);
        System.out.println(jsonObject);
    }

    public int getCurrentId() {
        return jsonArray.size();
    }
}
