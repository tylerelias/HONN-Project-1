package is.ru.honn.borrow.service;

public abstract class AbstractReadBorrowService implements ReadBorrowService{
    protected String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
