package honn.ru.is.data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreatePerson {

    private JSONArray jsonArray = new JSONArray();
    private ReadPersons readPersons = new ReadPersons();
    private String fileName = "./src/json/t-302-honn_2019_Friends.json";


    public CreatePerson() throws IOException, ParseException {
        jsonArray = readPersons.getJSONArray();
    }

    public void AddPerson(String firstName, String lastName, String email, String phoneNumber, String address) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        Object object = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) object;

        JSONObject addPerson = new JSONObject();
        addPerson.put("id", getCurrentId() + 1);
        addPerson.put("first_name", firstName);
        addPerson.put("last_name", lastName);
        addPerson.put("email", email);
        addPerson.put("phone", phoneNumber);
        addPerson.put("address", address);

        jsonArray.add(addPerson);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();

        //        JSONObject jsonObject = new JSONObject();
//
//        jsonObject.put("id", getCurrentId() + 1);
//        jsonObject.put("first_name", firstName);
//        jsonObject.put("last_name", lastName);
//        jsonObject.put("email", email);
//        jsonObject.put("phone", phoneNumber);
//        jsonObject.put("address", address);
//        System.out.println(jsonObject);
//
//
//        try {
//            Files.write(Paths.get(fileName), jsonObject.toString().getBytes(), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            //TODO: Add
//        }
    }

    public int getCurrentId() {
        return jsonArray.size();
    }
}
