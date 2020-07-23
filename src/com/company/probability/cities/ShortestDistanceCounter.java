package com.company.probability.cities;

import java.util.Set;

public class ShortestDistanceCounter {
   private int minWay = 10000;
    public ShortestDistanceCounter() {
    }

    public void executeSearch(String route) {

        CityDatabase db = CityDatabaseFactory.getDb();
        String[] res = route.split(" ");
        City from = db.findByName(res[0]);
        City to = db.findByName(res[1]);
        compute(from, to, 0);
    }

    // Method which looks for the shortest way from one city to other
    private void compute(City from, City to, int currentLength) {
        Set<City> cities = from.getNeighbors().keySet();
        for (City city : cities) {
            if (city.equals(to)) {
    if (from.getNeighbors().get(city)<minWay){
        minWay=from.getNeighbors().get(city);
    }
                break;
            } else {
                compute(city, to, currentLength + from.getNeighbors().get(city));
            }
        }
    }
}
