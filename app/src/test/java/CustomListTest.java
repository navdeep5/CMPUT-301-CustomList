import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount(); // 4
        list.addCity(new City("Halifax", "NS"));
        assertEquals(listSize+1, list.getCount()); // 5
    }

    @Test
    public void hasCityTest() {
        City newCity = new City("Victoria", "BC");
        list.addCity(newCity);
        assertTrue(list.hasCity(newCity));
    }

    @Test
    public void deleteCityTest() {
        City newCity = new City("Victoria", "BC");
        list.addCity(newCity);
        assertTrue(list.hasCity(newCity));
        list.deleteCity(newCity);
        assertFalse(list.hasCity(newCity));
    }

    @Test
    public void countCitiesTest() {
        int listSize = list.getCount();
        City newCityNS = new City("Halifax", "NS");
        list.addCity(newCityNS);
        list.addCity(new City("Red Deer", "AB"));
        assertEquals(listSize + 2, list.countCities());
        list.deleteCity(newCityNS);
        assertEquals(listSize + 1, list.countCities());

    }

}
