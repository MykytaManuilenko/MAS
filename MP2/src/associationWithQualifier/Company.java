package associationWithQualifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Company {
    private String companyName;
    private String headquarterAddress;
    private LocalDate dateOfFoundation;

    private Map<String, ComputerGame> computerGameQualifier = new HashMap<>();

    public Company(String companyName, String headquarterAddress, LocalDate dateOfFoundation) {
        this.companyName = companyName;
        this.headquarterAddress = headquarterAddress;
        this.dateOfFoundation = dateOfFoundation;
    }

    public void addComputerGame(ComputerGame computerGame) {
        if (!this.computerGameQualifier.containsKey(computerGame.getName())) {
            this.computerGameQualifier.put(computerGame.getName(), computerGame);
            computerGame.setCompany(this);
        }
    }

    public void removeComputerGame(ComputerGame computerGame) {
        if(this.computerGameQualifier.containsValue(computerGame)) {
            this.computerGameQualifier.remove(computerGame.getName(), computerGame);
            computerGame.setCompany(null);
        }
    }

    public ComputerGame findComputerGame(String name) {
        if (!this.computerGameQualifier.containsKey(name)) {
            throw new Error("Can not find computer game with name: " + name);
        }

        return this.computerGameQualifier.get(name);
    }

    public List<ComputerGame> getComputerGames() {
        return new ArrayList<>(computerGameQualifier.values());
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getHeadquarterAddress() {
        return headquarterAddress;
    }

    public void setHeadquarterAddress(String headquarterAddress) {
        this.headquarterAddress = headquarterAddress;
    }

    public LocalDate getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(LocalDate dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", headquarterAddress='" + headquarterAddress + '\'' +
                ", dateOfFoundation=" + dateOfFoundation +
                ", games=" + computerGameQualifier +
                '}';
    }
}
