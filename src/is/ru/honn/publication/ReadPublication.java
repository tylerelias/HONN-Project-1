package is.ru.honn.publication;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadPublication {

    private Object object;
    private String fileName = "./src/json/t-302-honn_2019_Publications.json";

    public ReadPublication() throws IOException, ParseException {
        object = new JSONParser().parse(new FileReader(fileName));
    }

    // Return an array of the JSON data
    public JSONArray getJSONArray() throws IOException, ParseException {
        object = new JSONParser().parse(new FileReader(fileName));
        return (JSONArray) object;
    }

    // This takes an index of a certain JSON row and returns it, enables lookup by key values
    // something that was not (at least I couldn't do) with getJSONArray alone
    public JSONObject getJSONObjectByIndex(int index) throws IOException, ParseException {
        return (JSONObject)getJSONArray().get(index);
    }
}