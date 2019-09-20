package is.ru.honn.data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreatePublication {
    private ReadPublications readPublications = new ReadPublications();
    private String fileName = "./src/json/t-302-honn_2019_Publications.json";

    public CreatePublication() throws IOException, ParseException {
    }

    public void AddPublication(String firstName, String lastName, String publicationTitle, String ISBN,
                               String type, int year, String journal) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        Object object = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) object;

        JSONObject addPublication = new JSONObject();
        addPublication.put("id", getCurrentId() + 1);
        addPublication.put("editor_first_name", firstName);
        addPublication.put("editor_last_name", lastName);
        addPublication.put("publication_title", publicationTitle);
        addPublication.put("isbn", ISBN);
        addPublication.put("type", type);
        addPublication.put("year", year);
        addPublication.put("journal", journal);

        jsonArray.add(addPublication);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }

    public int getCurrentId() throws IOException, ParseException {
        return readPublications.getJSONArray().size();
    }
}
