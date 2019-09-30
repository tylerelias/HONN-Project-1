package is.ru.honn.borrow;

import is.ru.honn.borrow.exception.BorrowServiceException;
import is.ru.honn.person.CreatePerson;
import is.ru.honn.publication.CreatePublication;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreateBorrow {

    private ReadBorrow readBorrow = new ReadBorrow();

    public CreateBorrow() throws IOException, ParseException {
    }

    public void createBorrow(Borrow borrow) throws IOException, ParseException {

        if(IsValidPersonId(borrow.getPersonID()) && IsValidPublicationId(borrow.getPublicationID())) {

        String filePath = "./src/json/t-302-honn_2019_Borrow.json";
        JSONParser jsonParser = new JSONParser();

        Object object = jsonParser.parse(new FileReader(filePath));
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

        FileWriter file = new FileWriter(filePath);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
        }
        else {
            throw new BorrowServiceException("Please make sure the IDs are valid");
        }
    }

    private boolean IsValidPublicationId(int id) throws IOException, ParseException {
        CreatePublication createPublication = new CreatePublication();
        return id <= createPublication.getCurrentId();
    }

    private boolean IsValidPersonId(int id) throws IOException, ParseException {
        CreatePerson createPerson = new CreatePerson();
        return id <= createPerson.GetCurrentId();
    }

    private int getCurrentId() throws IOException, ParseException {
        return readBorrow.getJSONArray().size();
    }
}
