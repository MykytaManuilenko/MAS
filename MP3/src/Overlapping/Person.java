package Overlapping;

import java.util.EnumSet;
import java.util.List;

public class Person {
    // attributes for Person
    private String firstName;
    private String lastName;

    // attributes for Doctor
    private double salary;
    private List<String> specialties;

    // attribute for Patient
    private String sickness;

    private EnumSet<PersonType> types = EnumSet.of(PersonType.PERSON);

    // Constructor for Doctor
    public Person(String firstName, String lastName, double salary, List<String> specialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.specialties = specialties;

        this.types.add(PersonType.DOCTOR);
    }

    // Constructor for Patient
    public Person(String firstName, String lastName, String sickness) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sickness = sickness;

        this.types.add(PersonType.PATIENT);
    }

    // Constructor for Doctor and Patient at the same time
    public Person(String firstName, String lastName, double salary, List<String> specialties, String sickness) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.specialties = specialties;
        this.sickness = sickness;

        this.types.add(PersonType.DOCTOR);
        this.types.add(PersonType.PATIENT);
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

    // method for Doctor
    public double getSalary() {
        if (types.contains(PersonType.DOCTOR)) {
            return salary;
        } else {
            throw new Error("This person is not a doctor");
        }
    }

    // method for Doctor
    public void setSalary(double salary) {
        if (types.contains(PersonType.DOCTOR)) {
            this.salary = salary;
        } else {
            throw new Error("This person is not a doctor");
        }
    }

    // method for Doctor
    public List<String> getSpecialties() {
        if (types.contains(PersonType.DOCTOR)) {
            return specialties;
        } else {
            throw new Error("This person is not a doctor");
        }
    }

    // method for Doctor
    public void setSpecialties(List<String> specialties) {
        if (types.contains(PersonType.DOCTOR)) {
            this.specialties = specialties;
        } else {
            throw new Error("This person is not a doctor");
        }
    }

    // method for Patient
    public String getSickness() {
        if (types.contains(PersonType.PATIENT)) {
            return sickness;
        } else {
            throw new Error("This person is not a patient");
        }
    }

    // method for Patient
    public void setSickness(String sickness) {
        if (types.contains(PersonType.PATIENT)) {
            this.sickness = sickness;
        } else {
            throw new Error("This person is not a patient");
        }
    }

    @Override
    public String toString() {
        String personInfo = "Person{first name=" + this.firstName + ", last name=" + this.lastName;

        if(types.contains(PersonType.DOCTOR) && (!types.contains(PersonType.PATIENT))){
            personInfo += ", salary=" + salary + ", specialties=" + specialties + ", so this person is a doctor}";
        }

        if(types.contains(PersonType.PATIENT) && (!types.contains(PersonType.DOCTOR))){
            personInfo += ", sickness=" + sickness + ", so this person is a patient}";
        }

        if(types.contains(PersonType.DOCTOR) && (types.contains(PersonType.PATIENT))){
            personInfo += ", salary=" + salary + ", specialties=" + specialties + ", sickness=" + sickness + " " +
                    ", so this person is a doctor and a patient}";
        }

        return personInfo;
    }
}