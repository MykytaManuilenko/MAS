package Dynamic;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Intern intern = new Intern(LocalDate.of(2020, 10, 10), LocalDate.of(2021, 1, 1));
        intern.setFirstName("AAA");
        intern.setLastName("AAA");
        intern.setSalary(500);

        System.out.println(intern.getFirstName() + " " + intern.getLastName() + " earns " + intern.getSalary() + " dollars" +
                " and has internship from " + intern.getInternshipStartDate() + " to " + intern.getInternshipEndDate());

        Junior junior = new Junior(intern, 0.5);
        junior.setSalary(1000);

        intern = null;

        System.out.println(junior.getFirstName() + " " + junior.getLastName() + " earns " + junior.getSalary() + " dollars" +
                " and has " + junior.getWorkExperience() + " years of experience");
    }
}
