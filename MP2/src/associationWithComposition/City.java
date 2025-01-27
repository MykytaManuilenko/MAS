package associationWithComposition;

public class City {
    private String name;

    private Country country;

    private City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public static City createCity(String name, Country country) {
        if (country == null) {
            throw new NullPointerException("Country can not be null");
        }

        City city = new City(name, country);
        country.addCity(city);

        return city;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}
