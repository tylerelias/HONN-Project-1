package is.ru.honn.borrow.service;

import is.ru.honn.borrow.Borrow;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public abstract class AbstractCreateBorrowService implements CreateBorrowService {

    protected String filePath;

    public abstract void createBorrow(Borrow borrow) throws IOException, ParseException;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
