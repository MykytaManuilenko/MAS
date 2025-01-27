package Multiple;

public class Cola extends Drink implements ICola {
    private double amountOfSugar;

    public Cola(String name, String description, String aroma, double amountOfSugar) {
        super(name, description, aroma);
        this.amountOfSugar = amountOfSugar;
    }

    public double getAmountOfSugar() {
        return amountOfSugar;
    }

    public void setAmountOfSugar(double amountOfSugar) {
        this.amountOfSugar = amountOfSugar;
    }
}
