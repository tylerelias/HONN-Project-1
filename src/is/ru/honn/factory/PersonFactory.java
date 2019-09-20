package is.ru.honn.factory;

import is.ru.honn.exception.FactoryException;
import is.ru.honn.exception.PersonServiceException;
import is.ru.honn.service.PersonService;

public class PersonFactory extends AbstractFactory{
    public PersonService getPersonService() {
        PersonService personService = null;
        try {
            loadProperties("arm.properties");
            personService.setFilePath(getProperties().getProperty("persons.file"));
        } catch(FactoryException fex) {
            throw new PersonServiceException("Unable to load class ", fex);
        }
        return personService;
    }
}
