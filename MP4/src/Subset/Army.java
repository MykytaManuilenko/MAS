package Subset;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private String name;

    private Soldier generalOfTheArmy;
    private List<Soldier> soldiers = new ArrayList<>();

    public Army(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void addSoldier(Soldier soldier) {
        if (soldier == null) {
            throw new NullPointerException("Soldier can not be null");
        } else if (!soldiers.contains(soldier)) {
            soldiers.add(soldier);
            soldier.setArmy(this);
        }
    }

    public void removeSoldier(Soldier soldier) {
        if (soldiers.contains(soldier)) {
            soldiers.remove(soldier);
            soldier.setArmy(null);
        }
    }

    public Soldier getGeneralOfTheArmy() {
        return generalOfTheArmy;
    }

    public void setGeneralOfTheArmy(Soldier soldier) {
        if (soldier == null) {
            throw new NullPointerException("Soldier can not be null");
        }

        if (!soldiers.contains(soldier)) {
            throw new Error("You can't be the general of the army");
        }

        this.generalOfTheArmy = soldier;
        soldier.setRunArmy(this);
    }
}
