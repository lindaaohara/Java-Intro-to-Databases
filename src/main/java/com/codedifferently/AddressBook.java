package com.codedifferently;

import com.codedifferently.database.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AddressBook {
    private static final Logger logger = Logger.getGlobal();
    private DataBase dataBase;
    private Person owner;
    private Person person;
    ArrayList<Person> people = new ArrayList();


    //example of dependency injection; part of dependency inversion
    public AddressBook(DataBase dataBase){
        this.dataBase = dataBase;
      }

      public AddressBook(){

      }

    public Person getOwner(){
        return owner;
    }
    public void setOwner(Person owner){
        this.owner = owner;
    }

    public void addPerson (Person person) {
        people.add(person);
        logger.info("adding new person "+person.getFirstName());
        logger.info("we have this many people: "+people.size());
    }

    public void removePerson(Person person){
        people.remove(person);

    }

    public void editPerson(Person person){

    }

    public Person getPersonByEmail(String email){
        for(Person person:people) {
            if(email.equals(person.getEmail()))
                return person;
        }
        return null;
    }

    public ArrayList<Person> getAllPeople(){
        return people;
        }




    public boolean saveAll(){
        return false;
    }
}
