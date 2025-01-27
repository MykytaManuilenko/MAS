package Bag;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String studNumber;

    private List<Enrollment> enrollments = new ArrayList<>();

    public Student(String firstName, String lastName, String studNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studNumber = studNumber;
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

    public String getStudNumber() {
        return studNumber;
    }

    public void setStudNumber(String studNumber) {
        this.studNumber = studNumber;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void addEnrollment(Enrollment enrollment) {
        if (enrollment == null) {
            throw new NullPointerException("Enrollment can not be null");
        } else if (!this.enrollments.contains(enrollment)) {
            this.enrollments.add(enrollment);
            enrollment.setStudent(this);;
        }
    }

    public void removeEnrollment(Enrollment enrollment) {
        if (enrollments.contains(enrollment)) {
            enrollments.remove(enrollment);
            enrollment.setStudent(null);
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Student " + this.firstName + " " + this.lastName + " studied at universities such as:\n");

        for (Enrollment e : enrollments) {
            info.append(" ").append(e.getUniversity().getName()).append(" from ").append(e.getStartDate()).append(" to ").append(e.getEndDate()).append("\n");
        }

        return info.toString();
    }
}
