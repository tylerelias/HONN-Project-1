package is.ru.honn.factory;

import is.ru.honn.factory.exception.FactoryException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Logger;

public class AbstractFactory {
    private Logger logger = Logger.getLogger(AbstractFactory.class.getName());
    private Properties properties = new Properties();

    protected Properties loadProperties(String fileName) throws FactoryException {
        try {
            properties.load(new FileInputStream(new File(fileName)));
        } catch (FileNotFoundException fnex) {
            String message = "Factory: File " + fileName + " not found.";
            logger.severe(message);
            throw new FactoryException(message, fnex);
        } catch (IOException ioex) {
            String message = "Factory: Unable to read file " + fileName + ".";
            logger.severe(message);
            throw new FactoryException(message, ioex);
        }
        return properties;
    }

    public Properties getProperties() {
        return properties;
    }

    protected Object loadClass(String name) throws FactoryException {
        Class instanceClass;
        try {
            instanceClass = Class.forName(name);
            return instanceClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException cnfex) {
            String msg = "Factory: Class '" + name + "' not found. ";
            logger.severe(msg);
            throw new FactoryException(msg, cnfex);
        } catch (InstantiationException iex) {
            String msg = "Factory: Instancing class '" + name + "'failed.";
            logger.severe(msg);
            throw new FactoryException(msg, iex);
        } catch (IllegalAccessException iaex) {
            String msg = "Factory: Illegal Access Instantiating Class '" +
                    name + "'.";
            logger.severe(msg);
            throw new FactoryException(msg, iaex);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
    }
}
