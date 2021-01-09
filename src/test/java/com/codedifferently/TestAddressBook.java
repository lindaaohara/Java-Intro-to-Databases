package com.codedifferently;

import com.codedifferently.database.DataBase;
import com.codedifferently.models.addressbook.AddressBook;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestAddressBook {
    @Test
    public void constructorTest() {
        DataBase dataBase = new MockDatabase();
        AddressBook addressBook = new AddressBook(null, dataBase);
    }
}