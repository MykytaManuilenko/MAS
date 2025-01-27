package associationWithComposition;

public class Main {
    public static void main(String[] args) {
        // 1 Country - * City
        Country country = new Country("Brazil");

        City city1 = City.createCity("Rio de Janeiro", country);
        City city2 = City.createCity("Distrito Federal", country);

        System.out.println("===========Before deleting city==========");
        System.out.println(country);

        System.out.println("\n===========After deleting one city==========");
        country.removeCity(city1);
        System.out.println(country);

        country.remove();
        System.out.println("\nDeleted country");
        Country.show();
    }
}
