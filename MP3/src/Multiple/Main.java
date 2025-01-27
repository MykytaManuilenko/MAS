package Multiple;

public class Main {
    public static void main(String[] args) {
        Cocktail cocktail = new Cocktail("Whiskey with Coke", "Jack and Coke is a highball cocktail made by mixing ...", "sweet", 35, 64);

        System.out.println("Alcohol percentage: " + cocktail.getAlcoholPercentage());
        System.out.println("Amount of sugar: " + cocktail.getAmountOfSugar());
    }
}
