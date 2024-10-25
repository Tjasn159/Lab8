package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    public CustomList MockCityList(){
        CustomList list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        CustomList list = MockCityList();
        int expectedCountBeforeAdd = 0;
        assertEquals(expectedCountBeforeAdd, list.getCount(), "Count should have been 0");
        City cityToAdd = new City("Nanton", "AB");
        list.addCity(cityToAdd);

        int expectedCountAfterAdd = 1;
        assertEquals(expectedCountAfterAdd, list.getCount(), "The city was not added to the list");
    }

    @Test
    public void hasCityTest() {
        CustomList list = MockCityList();
        assertFalse(list.hasCity("Nanton", "AB"), "The city should not be in the list");
        City cityToAdd = new City("Nanton", "AB");
        list.addCity(cityToAdd);

        assertTrue(list.hasCity("Nanton", "AB"), "The city should be in the list");
    }

    @Test
    public void deleteCityTest() {
        CustomList list = MockCityList();
        assertFalse(list.hasCity("Nanton", "AB"));
        City cityToAdd = new City("Nanton", "AB");

        list.addCity(cityToAdd);
        assertTrue(list.hasCity("Nanton", "AB"));
        list.deleteCity("Nanton", "AB");
        assertFalse(list.hasCity("Nanton", "AB"));
    }

    @Test
    public void countCitiesTest() {
        CustomList list = MockCityList();
        int expectedCount = 0;
        assertEquals(expectedCount, list.getCount(), "Count should have been 0");

        City cityToAdd = new City("Nanton", "AB");
        list.addCity(cityToAdd);
        expectedCount = 1;
        assertEquals(expectedCount, list.getCount(), "The city was not added to the list");

        City cityToAdd2 = new City("Waterloo", "ON");
        list.addCity(cityToAdd2);
        expectedCount = 2;
        assertEquals(expectedCount, list.getCount(), "The city was not added to the list");

        list.deleteCity("Nanton", "AB");
        expectedCount = 1;
        assertEquals(expectedCount, list.getCount(), "The city was not deleted from the list");
    }
}
