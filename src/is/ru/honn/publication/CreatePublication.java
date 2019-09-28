package is.ru.honn.publication;

/*
    AbstractFactory.java

    Gets a definition file
    as well as loading a plugin class
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreatePublication {
    private ReadPublication readPublication = new ReadPublication();
    private String fileName = "./src/json/t-302-honn_2019_Publications.json";

    public CreatePublication() throws IOException, ParseException {
    }

    public void AddPublication(Publication publication) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        Object object = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) object;

        JSONObject addPublication = new JSONObject();
        addPublication.put("id", getCurrentId() + 1);
        addPublication.put("editor_first_name", publication.getFirstName());
        addPublication.put("editor_last_name", publication.getLastName());
        addPublication.put("publication_title", publication.getPublicationTitle());
        addPublication.put("isbn", publication.getISBN());
        addPublication.put("type", publication.getType());
        addPublication.put("year", publication.getYear());
        addPublication.put("journal", publication.getJournal());

        jsonArray.add(addPublication);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }

    public int getCurrentId() throws IOException, ParseException {
        return readPublication.getJSONArray().size();
    }
}
