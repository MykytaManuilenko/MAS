package Bag;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1 Student - * Enrollment && 1 University - * Enrollment
        Student student1 = new Student("AAA", "AAA", "s12345");

        University university1 = new University("University of Cambridge", "The Old Schools, Trinity Ln, Cambridge CB2 1TN, United Kingdom");

        Enrollment e1 = new Enrollment(1, LocalDate.of(2018, 10, 1), LocalDate.of(2021, 10, 1), student1, university1);
        Enrollment e2 = new Enrollment(3, LocalDate.of(2021, 10, 1), LocalDate.of(2025, 10, 1), student1, university1);

        System.out.println(e1);
        System.out.println(e2);

        System.out.println(student1.getEnrollments());
    }
}
