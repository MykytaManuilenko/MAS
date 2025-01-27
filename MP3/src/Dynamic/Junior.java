package Dynamic;

public class Junior extends Employee {
    private double workExperience;

    public Junior(Employee employee, double workExperience) {
        super(employee.getFirstName(), employee.getLastName(), employee.getSalary());
        this.workExperience = workExperience;
    }

    public Junior(double workExperience) {
        this.workExperience = workExperience;
    }

    public double getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(double workExperience) {
        this.workExperience = workExperience;
    }
}
