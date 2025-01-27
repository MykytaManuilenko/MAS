package Multiple;

public class Brandy extends Drink {
    private double alcoholPercentage;

    public Brandy(String name, String description, String aroma, double alcoholPercentage) {
        super(name, description, aroma);
        this.alcoholPercentage = alcoholPercentage;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }
}
