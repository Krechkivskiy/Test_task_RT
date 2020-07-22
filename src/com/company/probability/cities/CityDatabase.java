package com.company.probability.cities;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CityDatabase {

    //I have decided to create db as individual entity to avoid "spagetti code"
    private List<City> cities = new ArrayList<>();

    public CityDatabase() {
    }

    public City findByIndex(int index) {
        for (City city : cities) {
            if (city.getIndex() == index) {
                return city;
            }
        }
        throw new NoSuchElementException("City with this index does not exists");
    }

    public City findByName(String name) {
        for (City city : cities) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        throw new NoSuchElementException("User with this index does not exist");
    }

    public void addCity(City city) {
        cities.add(city);
    }
}