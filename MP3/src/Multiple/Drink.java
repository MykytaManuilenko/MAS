package Multiple;

public class Drink {
    private String name;
    private String description;
    private String aroma;

    public Drink(String name, String description, String aroma) {
        this.name = name;
        this.description = description;
        this.aroma = aroma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }
}
