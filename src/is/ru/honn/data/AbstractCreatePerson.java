package is.ru.honn.data;

import is.ru.honn.service.PersonService;

public class AbstractCreatePerson implements PersonService {

    protected String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
