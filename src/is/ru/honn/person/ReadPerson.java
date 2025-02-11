package is.ru.honn.person;

/*  ReadPerson.java
    Reads the t-302-honn_2019_Friends.json file that was
    provided for this project and converts it to either a JSONArray or JSONObject
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadPerson {

    private Object object;
    private String fileName = "./src/json/t-302-honn_2019_Friends.json";

    public ReadPerson() throws IOException, ParseException {
        // Parse the JSON file into an Object
        object = new JSONParser().parse(new FileReader(fileName));
    }

    //Return an array of the JSON data
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
