package com.codedifferently.database;

import com.codedifferently.Person;
import com.codedifferently.database.exceptions.DataBaseSaveException;

import java.util.List;

public interface DataBase {
    void savePerson(Person person) throws DataBaseSaveException;
    void saveAllPeople(List<Person> people) throws DataBaseSaveException;
    List<Person> getAllPeople();
}
