package com.company.probability.cities;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input tests count");
        // I didn't understand how do i need to use this variable and will not use this field in my program:(
        int testsNumber = scanner.nextInt();
        System.out.println("Please input cities Count");
        int citiesCount = scanner.nextInt();
        scanCities(citiesCount);
        showShortestWays();
    }
        // method which executes search the shortest way
    private static void showShortestWays() {
        ShortestDistanceCounter distanceCounter = new ShortestDistanceCounter();
        System.out.println("Please input route, for stop press STOP");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 1000; i++) {
            String route = scanner.nextLine();
            if (route != "STOP") {
                distanceCounter.executeSearch(route);
            } else
                break;
        }
    }

        //method, which is responsible for scanning console and builds city from input data
    private static void scanCities(int citiesCount) {
        Scanner scanner = new Scanner(System.in);
        CityDatabase cityDatabase = CityDatabaseFactory.getDb();
        //Create three-level array for save to temporary save user-neighbor relationship (if input city will have
        // neighbor which at that time was not yet created
        // (first element in array is current city index, second - neighbor, third - distance
        int[][] neighborsRelationship = new int[citiesCount][3];
        //create variable which shows city index
        int currentCityId = 1;
        // counter which shows current position for save data about city-neighbor relationship
        int currentRelationshipId = 0;
        for (int i = 0; i < citiesCount; i++) {
            scanner = new Scanner(System.in);
            System.out.println("Please input city name");
            String name = scanner.nextLine();
            City city = new City(name);
            System.out.println("Please input neighbor count");
            int neighborCount = scanner.nextInt();
            city.setNeighborsCount(neighborCount);
            cityDatabase.addCity(city);
            for (int j = 0; j < neighborCount; j++) {
                scanner = new Scanner(System.in);
                System.out.println("Please input route");
                String neighborInfo = scanner.nextLine();
                String[] inputData = neighborInfo.split(" ", 2);
                // Here i fill the array of information about city-neighbor relationship
                neighborsRelationship[currentRelationshipId][0] = currentCityId;
                neighborsRelationship[currentRelationshipId][1] = Integer.parseInt(inputData[0]);
                neighborsRelationship[currentRelationshipId][2] = Integer.parseInt(inputData[1]);
                currentCityId++;
                currentRelationshipId++;
            }
        }
        applyConnections(neighborsRelationship);
    }

    // Execute search of cities in db and set all of them the information about each other in field 'neighbors'
    private static void applyConnections(int[][] neighborsRelationship) {
        CityDatabase db = CityDatabaseFactory.getDb();
        for (int i = 0; i < neighborsRelationship.length; i++) {
            int[] relations = neighborsRelationship[i];
            City first = db.findByIndex(relations[0]);
            City second = db.findByIndex(relations[1]);
            first.setNeighbor(second, relations[2]);
            second.setNeighbor(first, relations[2]);
        }
    }
}
