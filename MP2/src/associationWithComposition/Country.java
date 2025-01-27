package associationWithComposition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Country {
    private String name;

    private List<City> cities = new ArrayList<>();
    private static Set<City> allCities = new HashSet<>();
    private static List<Country> extension = new ArrayList<>();

    public Country(String name) {
        this.name = name;
        extension.add(this);
    }

    public void addCity(City city) {
        if (!cities.contains(city)) {
            if (allCities.contains(city)) {
                throw new IllegalArgumentException("This city is already in another country");
            }

            cities.add(city);
            allCities.add(city);
        }
    }

    public void removeCity(City city) {
        if (city == null) throw new NullPointerException("City can't be null");
        allCities.remove(city);
        cities.remove(city);
    }

    public void remove() {
        cities.forEach(allCities::remove);
        extension.remove(this);
    }

    public static void show() {
        for (Country country : extension) {
            System.out.println(country.toString());
        }
    }

    public void showCities(){
        for(City city : cities){
            System.out.println(cities);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }
}
