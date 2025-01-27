import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Employee extends Person {

    @Basic(optional = false)
    @Column(unique = true)
    private String email;

    @Basic(optional = false)
    private double salary;

    @Basic(optional = false)
    private LocalDate dateOfBirth;

    @ManyToOne
    private Restaurant restaurant;

    public Employee(String firstName, String secondName, String lastName, String phoneNr, String email, double salary, LocalDate dateOfBirth) {
        super(firstName, secondName, lastName, phoneNr);
        this.email = email;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee(String firstName, String lastName, String phoneNr, String email, double salary, LocalDate dateOfBirth) {
        super(firstName, lastName, phoneNr);
        this.email = email;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        if (this.restaurant == restaurant) return;

        if (this.restaurant != null) {
            this.restaurant.removeEmployee(this);
        }

        this.restaurant = restaurant;

        if (restaurant != null) {
            restaurant.addEmployee(this);
        }
    }

    @Transient
    public int getAge() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return super.toString().replace("Person", "Employee").replace("}", ", email='" + email + '\''
                + ", salary='" + salary + '\'' + ", dateOfBirth=" + dateOfBirth + ", age=" + getAge()
                + ", work in=" + restaurant.getName() + '}');
    }
}
