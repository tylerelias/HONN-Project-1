package is.ru.honn.borrow.service;

import is.ru.honn.borrow.Borrow;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface CreateBorrowService {
    void setFilePath(String filePath);
    void createBorrow(Borrow borrow) throws IOException, ParseException;
}
