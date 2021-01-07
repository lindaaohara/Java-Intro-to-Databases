package com.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class TestPerson {
    @Test
    public void getEmailTest() {
        //Given
        Person person = new Person("Tariq", "Hook", "tariq.hook@gmail.com", 42);

        //When
        String expected = "tariq.hook@gmail.com";
        String actual = person.getEmail();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getLastName() {
        //Given
        Person person = new Person("Tariq", "Hook", "tariq.hook@gmail.com", 42);

        //When
        String expected = "Hook";
        String actual = person.getLastName();

        //Then
        Assert.assertEquals(expected,actual);
    }
}
