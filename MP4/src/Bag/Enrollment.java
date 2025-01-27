package Bag;

import java.time.LocalDate;

public class Enrollment {
    private int currentSemester;
    private LocalDate startDate;
    private LocalDate endDate;

    private Student student;
    private University university;

    public Enrollment(int currentSemester, LocalDate startDate, LocalDate endDate, Student student, University university) {
        this.currentSemester = currentSemester;
        this.startDate = startDate;
        this.endDate = endDate;

        setStudent(student);
        setUniversity(university);
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        if (this.student == student) return;

        if (this.student != null) {
            this.student.removeEnrollment(this);
        }

        this.student = student;

        if (student != null) {
            student.addEnrollment(this);
        }
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        if (this.university == university) return;

        if (this.university != null) {
            this.university.removeEnrollment(this);
        }

        this.university = university;

        if (university != null) {
            university.addEnrollment(this);
        }
    }

    @Override
    public String toString() {
        return "Guest [" + student.getFirstName() + " " + student.getLastName() + "] studies in University ["
                + university.getName() + "] from " + startDate + " to " + endDate + " and his current semester is "
                + currentSemester;
    }
}
