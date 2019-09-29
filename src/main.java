import is.ru.honn.ui.MainMenu;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException, ParseException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.DisplayMenu();

    }
}
