package com.company.probability.cities;

//i have created this factory to make access to db easier
public class CityDatabaseFactory {

    private static CityDatabase cityDatabase;

    public static CityDatabase getDb() {
        if (cityDatabase == null) {
            cityDatabase = new CityDatabase();
        }
        return cityDatabase;
    }
}
