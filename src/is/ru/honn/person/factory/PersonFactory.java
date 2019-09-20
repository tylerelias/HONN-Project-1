package is.ru.honn.person.factory;

import is.ru.honn.factory.exception.FactoryException;
import is.ru.honn.factory.AbstractFactory;
import is.ru.honn.person.exception.PersonServiceException;
import is.ru.honn.person.service.PersonService;

public class PersonFactory extends AbstractFactory {
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
