package org.example;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PhoneBookTest {

    PhoneBook phoneBook0 = new PhoneBook();

    PhoneBook phoneBook1 = new PhoneBook();
    Human human0;
    Human human1;
    Human human2;

    ArrayList<String> phones0;
    ArrayList<String> phones1;
    ArrayList<String> phones2;

    @Before
    public void setUp() {
        human0 = new Human("Иван", "Иванов", "Иванович", 34);
        human1 = new Human("Влад", "Смирнов", "Иванович", 24);
        human2 = new Human("Иван", "Чирков", "Иванович", 45);


        phones0 = new ArrayList<>();
        phones0.add("1120");
        phones0.add("1121");
        phones0.add("1122");

        phones1 = new ArrayList<>();
        phones1.add("2120");
        phones1.add("2121");
        phones1.add("2122");

        phones2 = new ArrayList<>();
        phones2.add("3120");
        phones2.add("3121");
        phones2.add("3122");

        phoneBook0 = new PhoneBook();
        phoneBook0.addPhone(human0, "1120");
        phoneBook0.addPhone(human0, "1121");
        phoneBook0.addPhone(human0, "1122");

        phoneBook0.addPhone(human1, "2120");
        phoneBook0.addPhone(human1, "2121");
        phoneBook0.addPhone(human1, "2122");

        phoneBook0.addPhone(human2, "3120");
        phoneBook0.addPhone(human2, "3121");
        phoneBook0.addPhone(human2, "3122");


        phoneBook1.addPhone(human1, "2120");
        phoneBook1.addPhone(human1, "2121");
        phoneBook1.addPhone(human1, "2122");
    }

    @Test
    public void addPhoneTest0() {
        phones0.add("1123");
        phoneBook0.addPhone(human0, "1123");
        assertArrayEquals(phones0.toArray(), phoneBook0.getAllPhone(human0).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPhoneTest1() {
        phoneBook0.addPhone(new Human("Иван", "Иванов", "Иванович", 34), "1120");
    }

    @Test
    public void removePhoneTest0() {
        phones0.remove("1122");
        phoneBook0.removePhone(human0, "1122");
        assertArrayEquals(phones0.toArray(), phoneBook0.getAllPhone(human0).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removePhoneTest1() {
        phoneBook0.removePhone(human0, "1120");
        phoneBook0.removePhone(human0, "1121");
        phoneBook0.removePhone(human0, "1122");
        phoneBook0.getAllPhone(human0);
    }

    @Test
    public void getAllPhoneTest() {
        assertArrayEquals(phones0.toArray(), phoneBook0.getAllPhone(human0).toArray());
        assertArrayEquals(phones1.toArray(), phoneBook0.getAllPhone(human1).toArray());
    }

    @Test
    public void getHumanWithPhoneTest() {
        assertEquals(human0, phoneBook0.getHumanWithPhone("1120"));
        assertEquals(human2, phoneBook0.getHumanWithPhone("3120"));
    }

    @Test
    public void getPhoneBookStartWithTest() {
        assertEquals(phoneBook1, phoneBook0.getPhoneBookStartWith("См"));
    }
}