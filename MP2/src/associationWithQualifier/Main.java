package associationWithQualifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1 Company - * Computer Games
        Company company1 = new Company("Jagex", "Pennsylvania Avenue", LocalDate.of(1998, 10, 1));

        // Computer Game 1
        List<OperatingSystems> operatingSystemsForCompGame1 = new ArrayList<>();
        operatingSystemsForCompGame1.add(OperatingSystems.MICROSOFT_WINDOWS);

        ComputerGame computerGame1 = new ComputerGame("Ace of Spades", 1000, LocalDate.of(2001, 9, 18), operatingSystemsForCompGame1);
        computerGame1.setCompany(company1);

        // Computer Game 2
        List<OperatingSystems> operatingSystemsForCompGame2 = new ArrayList<>();
        operatingSystemsForCompGame2.add(OperatingSystems.MICROSOFT_WINDOWS);
        operatingSystemsForCompGame2.add(OperatingSystems.LINUX);
        operatingSystemsForCompGame2.add(OperatingSystems.MAC_OS);

        ComputerGame computerGame2 = new ComputerGame("AdvertCity", 700, LocalDate.of(2003, 10, 7), operatingSystemsForCompGame2);
//        computerGame2.setCompany(company1); // *1
        company1.addComputerGame(computerGame2); // same result as in *1

        System.out.println(computerGame1 + "\n");
        System.out.println(company1 + "\n");

        System.out.println("Find games");
        System.out.println(company1.findComputerGame("AdvertCity"));
        System.out.println(company1.findComputerGame("AAA"));
    }
}
