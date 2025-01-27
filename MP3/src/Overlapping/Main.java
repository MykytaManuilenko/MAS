package Overlapping;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> doctorSpecialties = new ArrayList<>();
        doctorSpecialties.add("Therapist");
        doctorSpecialties.add("Surgeon");

        Person doctor1 = new Person("AAA", "AAA", 2500, doctorSpecialties);
        System.out.println(doctor1);

        Person patient1 = new Person("BBB", "BBB", "flu");
        System.out.println(patient1);

        Person doctorAndPatient = new Person("AAA", "AAA", 2500, doctorSpecialties, "stroke");
        System.out.println(doctorAndPatient);

        System.out.println();
        System.out.println(doctor1.getSickness());
    }
}
