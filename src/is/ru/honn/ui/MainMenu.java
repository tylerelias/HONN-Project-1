package is.ru.honn.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {

    public MainMenu() {
    }

//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Enter String");
//    String s = br.readLine();
//        System.out.print("Enter Integer:");
//        try {
//        int i = Integer.parseInt(br.readLine());
//    } catch(NumberFormatException nfe) {
//        System.err.println("Invalid Format!");
//    }

    public void DisplayMenu() throws IOException {

        HomeLayout();

        int input = 0;

        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        try {
            input = Integer.parseInt(bufferedReader.readLine());
        } catch(NumberFormatException nfe) {
            System.err.println("Please inter a number");
        }


        switch (input) {
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

}
