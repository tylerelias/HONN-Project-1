package honn.ru.is.data;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadPersons {

    private Object object;

    public ReadPersons() throws IOException, ParseException {
        object = new JSONParser().parse(new FileReader("./src/json/t-302-honn_2019_Friends.json"));
    }

    JSONArray LoadData() {
        return (JSONArray) object;
    }
}
