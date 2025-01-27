package Multiple;

public class Cocktail extends Brandy implements ICola {
    private double amountOfSugar;

    public Cocktail(String name, String description, String aroma, double alcoholPercentage, double amountOfSugar) {
        super(name, description, aroma, alcoholPercentage);
        this.amountOfSugar = amountOfSugar;
    }

    @Override
    public double getAmountOfSugar() {
        return amountOfSugar;
    }

    @Override
    public void setAmountOfSugar(double amountOfSugar) {
        this.amountOfSugar = amountOfSugar;
    }
}
