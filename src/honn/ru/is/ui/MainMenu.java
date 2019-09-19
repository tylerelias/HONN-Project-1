package honn.ru.is.ui;

public class MainMenu {

    public MainMenu() {
        DisplayMenu();
    }


    private void DisplayMenu() {

        HomeLayout();

        String input = System.console().readLine();

        if(isNumber(input)) {
            int number = Integer.parseInt(input);
            switch (number) {
                case 1: DisplayPeopleRegistryMenu();
                        break;
                case 2: DisplayPublicationRegistryMenu();
                        break;
                case 3: DisplayBorrowingMenu();
                        break;
                case 4: DisplayListOfPublicationByDateMenu();
                        break;
                case 5: DisplayListOfBorrowersByDateMenu();
                        break;
                case 6: DisplayListOfPeopleBorrowingForMoreThanMonth();
                        break;
            }
        }
    }


    private void HomeLayout() {
        System.out.println("\t\tWelcome to Tyler's Academic Reference Manager!");
        System.out.println("\t\t==============================================");
        System.out.println("Please type in the number, for the action you want to execute");
        System.out.println("\t1: Register a person that borrows a publication");
        System.out.println("\t2: Register a publication");
        System.out.println("\t3: Register a borrowed publication");
        System.out.println("\t4: List publications that are out on loan by date");
        System.out.println("\t5: List who is borrowing a publication by date");
        System.out.println("\t6: List people who have borrowed a publication for more than a month");
    }

    private void DisplayPeopleRegistryMenu() {

    }

    private void DisplayPublicationRegistryMenu() {}

    private void DisplayBorrowingMenu() {}

    private void DisplayListOfPublicationByDateMenu() {}

    private void DisplayListOfBorrowersByDateMenu() {}

    private void DisplayListOfPeopleBorrowingForMoreThanMonth() {}

    private static boolean isNumber(String s)
    {
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i))
                    == false)
                return false;

        return true;
    }
}
