package com.company.probability.cities;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class City {

    //field which will be increment when i will make city
    private static int inputCount = 0;
    private int index;
    private int neighborsCount;
    private String name;
    //Made neighbors as hashmap where key is city and distance is value.
    // In other case i would have created new entity which describes user - neighbor connection
    private Map<City, Integer> neighbors;

    public int getIndex() {
        return this.index;
    }

    public City(String name) {
        //auto generation index for user in order of creations
        ++inputCount;
        this.index = inputCount;
        this.name = name;
        this.neighbors = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<City, Integer> getNeighbors() {
        return neighbors;
    }

    public void setNeighbor(City neighbor, int distance) {
        this.neighbors.put(neighbor, distance);
    }

    public int getNeighborsCount() {
        return neighborsCount;
    }

    public void setNeighborsCount(int neighborsCount) {
        this.neighborsCount = neighborsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return index == city.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
