package is.ru.honn.borrow;

import is.ru.honn.borrow.service.AbstractReadBorrowService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadBorrow extends AbstractReadBorrowService {

    private Object object;
    String fileName = "./src/json/t-302-honn_2019_Borrow.json";

    public ReadBorrow() throws IOException, ParseException {
        object = new JSONParser().parse(new FileReader(fileName));
    }

    public JSONArray getJSONArray() throws IOException, ParseException {
        object = new JSONParser().parse(new FileReader(fileName));
        return (JSONArray) object;
    }

    public JSONObject getJOSNObjectByIndex(int index) throws IOException, ParseException {
        return (JSONObject)getJSONArray().get(index);
    }
}
