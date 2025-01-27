package Bag;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private String address;

    private List<Enrollment> enrollments = new ArrayList<>();

    public University(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void addEnrollment(Enrollment enrollment) {
        if (enrollment == null) {
            throw new NullPointerException("Enrollment can not be null");
        } else if (!this.enrollments.contains(enrollment)) {
            this.enrollments.add(enrollment);
            enrollment.setUniversity(this);;
        }
    }

    public void removeEnrollment(Enrollment enrollment) {
        if (enrollments.contains(enrollment)) {
            enrollments.remove(enrollment);
            enrollment.setUniversity(null);
        }
    }

    @Override
    public String toString() {
        String info = "University " + this.name + " has students:\n";

        for (Enrollment e : enrollments) {
            info += " " + e.getStudent().getFirstName() + " " + e.getStudent().getLastName() + "\n";
        }

        return info;
    }
}
