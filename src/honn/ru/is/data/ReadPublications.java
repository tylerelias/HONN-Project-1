package honn.ru.is.data;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadPublications {

    private Object object;

    public ReadPublications() throws IOException, ParseException {
        object = new JSONParser().parse(new FileReader("./src/json/t-302-honn_2019_Publications.json"));
    }

    public JSONArray getJSONArray() {
        return (JSONArray) object;
    }
}