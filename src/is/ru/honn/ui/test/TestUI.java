package is.ru.honn.ui.test;

import is.ru.honn.ui.MainMenu;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class TestUI {
    public static void main(String[] args) throws IOException, ParseException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.DisplayMenu();

    }
}
