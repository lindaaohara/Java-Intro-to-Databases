package com.codedifferently;

import com.codedifferently.database.DataBase;
import com.codedifferently.database.exceptions.DataBaseSaveException;

import java.util.List;

public class MockDatabase implements DataBase {
    @Override
    public void savePerson(Person person) throws DataBaseSaveException {

    }

    @Override
    public void saveAllPeople(List<Person> people) throws DataBaseSaveException{

    }
    @Override
    public List<Person> getAllPeople(){
        return null;
    }
}
