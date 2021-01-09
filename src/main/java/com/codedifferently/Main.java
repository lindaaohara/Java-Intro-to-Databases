package com.codedifferently;

import com.codedifferently.database.DataBase;
import com.codedifferently.database.MySQLDataBase;
import com.codedifferently.database.exceptions.DataBaseConnectionException;
import com.codedifferently.models.addressbook.AddressBook;
import com.codedifferently.models.addressbook.exceptions.AddressBookPersonNotFoundException;

import java.util.*;

public class Main {

    private DataBase dataBase;
    private AddressBook addressBook;
    private static Scanner scanner;
    private ArrayList<String> menu;

    public Main() throws DataBaseConnectionException {
        dataBase = new MySQLDataBase();
        scanner = new Scanner(System.in);
        addressBook = new AddressBook(null, dataBase);
        initMenuOption();
    }

    private void initMenuOption(){
        menu = new ArrayList<>();
        menu.add("Exit");
        menu.add("Show All");
        menu.add("Add New Person");
        menu.add("Find by email");
        /**
         * Add your menu items here
         */
    }


    public Integer displayMenu(){
        int option = 0;
        for(int i = 0; i < menu.size(); i++){
            String menuOption = String.format("Press %d for %s", i, menu.get(i));
            System.out.println(menuOption);
        }
        option = scanner.nextInt();
        return option;
    }

    public void displayAllPeople(){
        System.out.println("Here is a list of all the people in your address book:");
        List<Person> people = addressBook.getAllPeople();
        if(people.size() == 0){
            System.out.println("You have no one in your address book yet");
        }
        for (Person person:people){
            displayPerson(person);
        }
    }

    private String getStringOutput(String msg){
        System.out.println(msg);
        return scanner.next();
    }

    private Integer getIntegerOutput(String msg){
        System.out.println(msg);
        String response = scanner.next();

        //check value
        return Integer.parseInt(response);
    }

    public void createNewPerson(){
        Map<String, String> rawData = new HashMap<>();
        rawData.put("firstName", getStringOutput("Please enter first name:"));
        rawData.put("lastName", getStringOutput("Please enter last name:"));
        rawData.put("email", getStringOutput("Please enter email"));
        rawData.put("age", getStringOutput("Please enter age:"));
        Person person = new Person(rawData);
        addressBook.addPerson(person);
    }

    public void findPerson(){
        String email = getStringOutput("What email are you looking for?");
        try{
            Person person = addressBook.getPersonByEmail(email);
            displayPerson(person);
        } catch (AddressBookPersonNotFoundException e){
            System.out.println("There is not user with the email: "+ email);
        }
    }

    private void displayPerson(Person person){
        String output = String.format("%s %s %s %s %d", person.getId(), person.getFirstName(),person.getLastName(), person.getEmail(), person.getAge());
        System.out.println(output);
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();
            Boolean endProgram = false;
            System.out.println("Welcome to address book");
            while (!endProgram) {
                /* Your code goes here */
                int menuOption = main.displayMenu();

                switch(menuOption){
                    case 0:
                        System.out.println("Goodbye!!");
                        endProgram = true;
                        break;
                    case 1:
                        main.displayAllPeople();
                        break;
                    case 2:
                        main.createNewPerson();
                        break;
                    case 3:
                        main.findPerson();
                        break;
                    default:
                        System.out.println("I don't know that command");
                        break;
                }
            }
        } catch (DataBaseConnectionException e) {
            System.out.println("Your database could not be connected to.");
        }
    }
}
