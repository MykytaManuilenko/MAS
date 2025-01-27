package associationWithQualifier;

import java.time.LocalDate;
import java.util.List;

public class ComputerGame {
    private String name;
    private double price;
    private LocalDate dateReleased;
    private List<OperatingSystems> operatingSystem;

    private Company company;

    public ComputerGame(String name, double price, LocalDate dateReleased, List<OperatingSystems> operatingSystem) {
        this.name = name;
        this.price = price;
        this.dateReleased = dateReleased;
        this.operatingSystem = operatingSystem;
    }

    public void setCompany(Company company) {
        if (this.company == company) {
            return;
        }

        if (this.company != null) {
            this.company.removeComputerGame(this);
        }

        this.company = company;

        if (company != null) {
            company.addComputerGame(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(LocalDate dateReleased) {
        this.dateReleased = dateReleased;
    }

    public List<OperatingSystems> getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(List<OperatingSystems> operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "ComputerGame{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", dateReleased=" + dateReleased +
                ", operatingSystem=" + operatingSystem +
                ", company=" + company.getCompanyName() +
                '}';
    }
}
