package com.codedifferently;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestAddressBook {
    @Test
    public void getAllPeopleTest() {
        //Given
        ArrayList<Person> people = new ArrayList();
        people.add(new Person("Tariq", "Hook", "tariq.hook@gmail.com", 41));
        people.add(new Person("Stephanie", "Eldridge", "stephanie.eldridge@codedifferently.com", 41));

        int expected = 2;
        int actual = people.size();

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void getOwnerTest(){
        //Given
        AddressBook addressBook = new AddressBook();
        addressBook.setOwner(new Person("Linda", "O'Hara", "lindaaohara@gmail.com", 62));

        String expected = "O'Hara";
        String actual = addressBook.getOwner().getLastName();

        Assert.assertEquals(expected, actual);

    }
}
