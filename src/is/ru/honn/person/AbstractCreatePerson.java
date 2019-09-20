package is.ru.honn.person;

import is.ru.honn.person.service.PersonService;

public class AbstractCreatePerson implements PersonService {

    protected String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
