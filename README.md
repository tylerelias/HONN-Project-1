# Project 1

## Structure and Setup

The general structure of the program is that each item that can be place in its own category, has its own class. 
Say if we have data stored for Persons, we make a class for Persons. If we store data for a Publication, we make a 
Publication class and so on. This is done to make the different functions of the program, separate. Divide and conquer. 
All specific actions that are taken for each class are broken down to separate classes. So a Create operation for a 
specific object will be in its own class, as would a Read operation and so on. An example would be that Person has a 
ReadPerson, CreatePerson class and so on. 

This keeps the code clean makes it easier to go into the code later to change or fix things. It also makes it easier to add
features and functionality to the program later down the road.

The class structure is as follows:

## Person [Folder]

### Person.java

- Stores all information needed for the Person data
- Functions in the class:
```java
public Person(int id, String firstName, String lastName, String email, String phoneNumber, String address)
public Person(String firstName, String lastName, String email, String phoneNumber, String address)
GETTERS
SETTERS
public String toString()
```
- This class is used to store data related to the user that is being processed in the system by the program. The usage 
of this class is quite extensive in the program, since the data related to Person touches many parts of the program.


### PersonFactory.java 

- Loads all properties needed for the Person classes
- Functions in the class:
```java
public class PersonFactory extends AbstractFactory
```
- Is not a functional class, but was added rather as an placeholder for when an expansion of the program
will take place, having its basic structure will save time.

### CreatePerson.java

- Creates a new JSON object of a person and saves it to the JSON file
- Functions in the class:
```java
public CreatePerson() 
public void AddPerson(Person person) 
public int GetCurrentId() 
```
- This class was made before the TA pointed out to me that I did NOT have to write a new JSON file with the changes,
I also somehow missed that part in the project description, although it is state quite clearly that we didn't have to.
But what this class does is to first read from the JSON file, place that content into an JSONArray. Then the filled out
Person class is created as a JSON Object and added to the JSON Array. Then a file writer writes the new JSON Array and
saves it locally on the machine.

### PersonService.java

- Gets custom settings needed for Person classes
- This is not being used in the code, but rather a implementation to make it easier to implement
factory classes in the future
- Function in the class:
```java
public void setFilePath(String filePath)
```

### ReadPerson.java

- Reads the JSON file of People and returns it
- Functions in the class:
```java
public ReadPerson()
public JSONArray getJSONArray()
public JSONObject getJSONObjectByIndex(int index)
```
- This class reads the JSON file and returns the contents in JSON- Array or Object format

### PersonTest.java

- Testing the People Class
- This was a class where all the tests for Person are, these test are not meant as pass/failed tests.

### AbstractCreatePerson.java

- A function made for a factory implementation

## Publication [Folder]

### Publication.java

- Stores information needed for Publication data
- Functions in the class:
```java
public Publication(String firstName, String lastName, String publicationTitle, String ISBN, String journal, int year, String type)
GETTERS
SETTERS
public String toString()
```

### ListPublications

- Filter and list Publications that meet the selected date criteria
- Functions in the class:
```java
public JSONArray findPublicationsByDate(Date lookupDate)
public DatesBorrow getDatesFromJSONObject(int index, String objectName)
private boolean IsBorrowedOnDate(DatesBorrow borrowDate)
private boolean IsReturnedOnDate(DatesBorrow returnDate)
GETTERS
SETTERS
public String formatDate(Date date)
public StringBuilder PublicationToStringBuilder()
public StringBuilder PersonToStringBuilder() 
```
- This function has a lot going on for itself. It does more than just List Publications, it also filters and processes
data coming into it. The latter should be moved to another class if there is refactoring to be done

### ReadPublication 

- Reads the JSON file for Publications and returns it
- Functions in the class:
```java
public ReadPublication()
public JSONArray getJSONArray()
public JSONObject getJSONObjectByIndex(int index)
```
- This class reads the JSON file and returns the contents in JSON- Array or Object format

### CreatePublication.java

- Creates a new Publication that is written to the JSON file
- Functions in the class:
```java
public void AddPublication(Publication publication) 
public int getCurrentId() 
```
- This class was made before the TA pointed out to me that I did NOT have to write a new JSON file with the changes,
  I also somehow missed that part in the project description, although it is state quite clearly that we didn't have to.
  But what this class does is to first read from the JSON file, place that content into an JSONArray. Then the filled out
  Person class is created as a JSON Object and added to the JSON Array. Then a file writer writes the new JSON Array and
  saves it locally on the machine.

## Borrow [Folder]

### Borrow.java
  
  - Stores information needed for Borrow
  - Functions in the class:
```java
public Borrow(int personID, String personName, Date borrowDate, Date returnDate, int publicationID, String publicationName)
GETTERS
SETTERS
public String formatDate(Date date)
public String toString() 
```

### CreateBorrow.java

- Creates a new Borrow that is written in a JSON file
- Functions in the class:
```java
public void createBorrow(Borrow borrow)
private boolean IsValidPublicationId(int id) 
private boolean IsValidPersonId(int id) 
private int getCurrentId()
```
- CreatesBorrow creates a Borrow instance and saves it in JSON format. There is a check for valid IDs from Person and Publication,
although the check does not compare the incoming ID with all current ones, it only checks if its higher than the current
highest ID, and if its more than 0. This could cause problems if a Borrow entry was deleted, and the freed up ID would fail that check,

### ReadBorrow.java

- Reads the JSON file for Publications and returns it
- Functions in the class:
```java
public ReadBorrow()
public JSONArray getJSONArray()
public JSONObject getJSONObjectByIndex(int index)
```
- This class reads the JSON file and returns the contents in JSON- Array or Object format

### DatesBorrow.java

- A class to store the dates in numeric format when they are being read from the JSON file

## UI [Folder]

### MainMenu.java

- This class handles all the command line interface and logic
- Functions in the class:
```java
public void DisplayMenu()
private void HomeLayout()
private void DisplayPeopleRegistryMenu()
private void DisplayPublicationRegistryMenu()
private void DisplayBorrowingMenu()
private void DisplayListOfPublicationByDateMenu()
private void DisplayListOfBorrowersByDateMenu()
private void DisplayListOfPeopleBorrowingForMoreThanMonth()
private String ReadInputString()
private int ReadInputInteger()
private GregorianCalendar ReadInputDate()
```
- This class has all the menus that the CLI uses. This should be broken down to smaller classes of refactoring
takes place. And there is sometimes a lot of logic being done for a CLI class, should also be separated from this class.

## json [Folder]

- Stores all JSON files for the program
