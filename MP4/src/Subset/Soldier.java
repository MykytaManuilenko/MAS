package Subset;

public class Soldier {
    private String firstName;
    private String lastName;
    private MilitaryRank militaryRank;

    private Army army; // this soldier belongs to this army
    private Army runArmy; // this soldier runs this army

    public Soldier(String firstName, String lastName, MilitaryRank militaryRank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.militaryRank = militaryRank;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MilitaryRank getMilitaryRank() {
        return militaryRank;
    }

    public void setMilitaryRank(MilitaryRank militaryRank) {
        this.militaryRank = militaryRank;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        if (this.army == army) return;

        if (this.army != null) {
            this.army.removeSoldier(this);
        }

        this.army = army;

        if (army != null) {
            army.addSoldier(this);
        }
    }

    public Army getRunArmy() {
        return runArmy;
    }

    public void setRunArmy(Army runArmy) {
        if (this.runArmy == runArmy) return;

        if (this.runArmy != null) {
            this.runArmy.removeSoldier(this);
        }

        if (runArmy != null && runArmy.getSoldiers().contains(this)) {
            this.runArmy = runArmy;
            runArmy.setGeneralOfTheArmy(this);
        } else {
            throw new Error("You must be in the army to run it");
        }
    }
}
