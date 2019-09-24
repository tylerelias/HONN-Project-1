package is.ru.honn.borrow;

import is.ru.honn.borrow.service.AbstractCreateBorrowService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreateBorrow extends AbstractCreateBorrowService {

    private ReadBorrow readBorrow = new ReadBorrow();

    public CreateBorrow() throws IOException, ParseException {
    }

    public void createBorrow(Borrow borrow) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        Object object = jsonParser.parse(new FileReader(getFilePath()));
        JSONArray jsonArray = (JSONArray) object;

        JSONObject addBorrow = new JSONObject();
        addBorrow.put("id", getCurrentId() + 1);
        addBorrow.put("person_name", borrow.getPersonName());
        addBorrow.put("person_id", borrow.getPersonID());
        addBorrow.put("borrow_date", borrow.getBorrowDate());
        addBorrow.put("return_date", borrow.getReturnDate());
        addBorrow.put("publication_id", borrow.getPublicationID());
        addBorrow.put("publication_name", borrow.getPublicationName());

        jsonArray.add(addBorrow);

        FileWriter file = new FileWriter(getFilePath());
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }

    public int getCurrentId() throws IOException, ParseException {
        return readBorrow.getJSONArray().size();
    }
}
