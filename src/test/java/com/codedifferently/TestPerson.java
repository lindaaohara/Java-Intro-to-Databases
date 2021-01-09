package com.codedifferently;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestPerson {
    @Test
    public void constructorTest01(){
        Map<String, String> rawData = new HashMap<>();
        rawData.put("firstName", "Holly");
        rawData.put("lastName", "Chaffee");
        rawData.put("email", "holly@gmail.com");
        rawData.put("age", "25");
        Person person = new Person(rawData);
        String expected = "Holly Chaffee holly@gmail.com 25";
        String actual = person.toString();
        Assert.assertEquals("Create a Person with no id", expected, actual);
    }

    @Test
    public void constructorTest02(){
        Map<String, String> rawData = new HashMap<>();
        String id = UUID.randomUUID().toString();
        rawData.put("firstName", "Holly");
        rawData.put("lastName", "Chaffee");
        rawData.put("email", "holly@gmail.com");
        rawData.put("age", "25");
        Person person = new Person(id, rawData);
        String expected = id;
        String actual = person.getId();
        Assert.assertEquals("Create a Person with id", expected, actual);
    }
    @Test
    public void getEmailTest() {
        //Given
        Map<String, String> rawData = new HashMap<>();
        String id = UUID.randomUUID().toString();
        rawData.put("firstName", "Holly");
        rawData.put("lastName", "Chaffee");
        rawData.put("email", "holly@gmail.com");
        rawData.put("age", "25");
        Person person = new Person(id, rawData);

        //When
        String expected = "holly@gmail.com";
        String actual = person.getEmail();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getLastName() {
        //Given
        Map<String, String> rawData = new HashMap<>();
        String id = UUID.randomUUID().toString();
        rawData.put("firstName", "Holly");
        rawData.put("lastName", "Chaffee");
        rawData.put("email", "holly@gmail.com");
        rawData.put("age", "25");
        Person person = new Person(id, rawData);

        //When
        String expected = "Chaffee";
        String actual = person.getLastName();

        //Then
        Assert.assertEquals(expected,actual);
    }
}
