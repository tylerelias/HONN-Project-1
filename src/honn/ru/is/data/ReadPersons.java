package honn.ru.is.data;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadPersons {

    private Object object;
    String fileName = "./src/json/t-302-honn_2019_Friends.json";

    public ReadPersons() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(fileName);
        object = parser.parse(reader);
//        object = new JSONParser().parse(new FileReader(fileName));
    }

    public JSONArray getJSONArray() {
        return (JSONArray) object;
    }

    public JSONObject getJSONObjectByIndex(int index) {
        return (JSONObject)getJSONArray().get(index);
    }
}
