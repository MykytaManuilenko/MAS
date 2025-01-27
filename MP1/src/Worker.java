import java.time.LocalDate;
import java.util.List;

public class Worker extends Extension {
    private String firstName; // simple, required attribute
    private String secondName = null; // simple, optional attribute
    private String lastName; // simple, required attribute
    private String email; // simple, required attribute
    private String phoneNumber; // simple, required attribute
    private Double grossSalary; // simple, required attribute
    private LocalDate dateOfBirth; // complex attribute
    private LocalDate dateOfEmployment; // complex attribute

    private static final double MAX_SALARY = 10000; // class attribute
    private static final double MIN_SALARY = 3000; // class attribute
    private static final int SOCIAL_SECURITY = 411; // class attribute
    private static final int HEALTH = 233; // class attribute
    private static final int TAX = 151; // class attribute

    public List<Rank> ranks; // multi-value attribute

    public Worker(String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, LocalDate dateOfEmployment, Double grossSalary, List<Rank> ranks) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setDateOfBirth(dateOfBirth);
        setDateOfEmployment(dateOfEmployment);
        setGrossSalary(grossSalary);
        setRanks(ranks);
    }

    // constructor overloading
    public Worker(String firstName, String secondName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, LocalDate dateOfEmployment, Double grossSalary, List<Rank> ranks) {
        setFirstName(firstName);
        this.secondName = secondName;
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setDateOfBirth(dateOfBirth);
        setDateOfEmployment(dateOfEmployment);
        setGrossSalary(grossSalary);
        setRanks(ranks);
    }

    // class method
    public static Worker findTheHighestPaidEmployee() throws Exception {
        List<Worker> workers = getAllExtents(Worker.class);

        Worker highestPaidEmployee = null;
        double maxSalary = 0;

        for (Worker worker : workers) {
            if (worker.grossSalary > maxSalary) {
                maxSalary = worker.grossSalary;
                highestPaidEmployee = worker;
            }
        }

        return highestPaidEmployee;
    }

    public static void showExtent() throws Exception {
        Extension.showExtent(Worker.class);
    }

    // First name (required attribute)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new NullPointerException("First name is required");
        } else {
            this.firstName = firstName;
        }
    }

    // Second name (optional attribute)
    public String getSecondName() {
        return secondName != null ? secondName : "no second name";
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    // Last name (required attribute)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new NullPointerException("Last name is required");
        } else {
            this.lastName = lastName;
        }
    }

    // Email (required attribute)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new Error("Email is required");
        } else {
            this.email = email;
        }
    }

    // Phone Number (required attribute)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new Error("Phone number is required");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    // Date of birth (complex attribute)
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            throw new Error("Date of birth is required");
        } else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    // Age (derived attribute)
    public int getAge() {
        return LocalDate.now().getYear() - this.dateOfBirth.getYear();
    }

    // Date of employment (complex attribute)
    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        if (dateOfEmployment == null) {
            throw new Error("Date of employment is required");
        } else {
            this.dateOfEmployment = dateOfEmployment;
        }
    }

    // gross salary (required attribute)
    public Double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(Double grossSalary) {
        if (grossSalary == null) {
            throw new Error("Gross salary is required");
        }

        if (grossSalary <= Worker.MAX_SALARY && grossSalary >= Worker.MIN_SALARY) {
            this.grossSalary = grossSalary;
        } else {
            throw new Error("gross salary must be less than " + Worker.MAX_SALARY + " and more than " + Worker.MIN_SALARY);
        }
    }

    // netSalary (derived attribute)
    public double getNetSalary() {
        return this.grossSalary - (Worker.SOCIAL_SECURITY + Worker.HEALTH + Worker.TAX);
    }

    // roles (multi-value attribute)
    public List<Rank> getRanks() {
        return ranks;
    }

    public void setRanks(List<Rank> ranks) {
        if (ranks == null || ranks.isEmpty()) {
            throw new Error("List of roles can't be empty or null");
        } else {
            this.ranks = ranks;
        }
    }

    // method overriding
    @Override
    public String toString() {
        return "Worker: \n" + "first name: " + this.firstName + "\nsecond name: " + (this.secondName != null ? this.secondName : "no second name") +
                "\nlast name: " + this.lastName + "\nemail: " + this.email + "\nphone number: " + this.phoneNumber +
                "\ndate of birth: " + this.dateOfBirth + "\ndate of employment: " + this.dateOfEmployment +
                "\ngross salary: " + this.grossSalary + "\nRoles: " + this.ranks.toString();
    }
}
