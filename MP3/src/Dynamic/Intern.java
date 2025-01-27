package Dynamic;

import java.time.LocalDate;

public class Intern extends Employee {
    private LocalDate internshipStartDate;
    private LocalDate internshipEndDate;

    public Intern(Employee employee, LocalDate internshipStartDate, LocalDate internshipEndDate) {
        super(employee.getFirstName(), employee.getLastName(), employee.getSalary());
        this.internshipStartDate = internshipStartDate;
        this.internshipEndDate = internshipEndDate;
    }

    public Intern(LocalDate internshipStartDate, LocalDate internshipEndDate) {
        this.internshipStartDate = internshipStartDate;
        this.internshipEndDate = internshipEndDate;
    }

    public LocalDate getInternshipStartDate() {
        return internshipStartDate;
    }

    public void setInternshipStartDate(LocalDate internshipStartDate) {
        this.internshipStartDate = internshipStartDate;
    }

    public LocalDate getInternshipEndDate() {
        return internshipEndDate;
    }

    public void setInternshipEndDate(LocalDate internshipEndDate) {
        this.internshipEndDate = internshipEndDate;
    }
}
