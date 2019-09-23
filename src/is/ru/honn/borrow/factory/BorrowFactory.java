package is.ru.honn.borrow.factory;

import is.ru.honn.borrow.exception.BorrowServiceException;
import is.ru.honn.borrow.service.CreateBorrowService;
import is.ru.honn.factory.AbstractFactory;
import is.ru.honn.factory.exception.FactoryException;

public class BorrowFactory extends AbstractFactory {
    public CreateBorrowService getBorrowService() {
        CreateBorrowService createBorrowService;
        try {
            loadProperties("arm.properties");
            createBorrowService = (CreateBorrowService) loadClass(
                    getProperties().getProperty("borrow.service.class"));
            createBorrowService.setFilePath(getProperties().getProperty("borrow.file"));
        } catch(FactoryException fex) {
            throw new BorrowServiceException("Unable to load class ", fex);
        }
        return createBorrowService;
    }
}
