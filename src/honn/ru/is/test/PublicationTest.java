package honn.ru.is.test;

import honn.ru.is.Publication;
import honn.ru.is.exception.PublicationException;

public class PublicationTest {
    public static void main(String[] args) {

        //This test should fail since year is less than 0
        Publication publication1 = new Publication("John", "Title 42", "Some Journal", -1, true);
        if(publication1.getYear() < 0) {
            throw new PublicationException("Year must be a positive number");
        }
        Publication publication2 = new Publication("Smith John", "The Title of 42", "The Journal", 1998, true);

        System.out.println(publication2.toString());

    }
}
