import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        final String PATH = "DataBase.bin";

        try {
            readExtentFromFile(PATH);

            System.out.println("================An extension that already exists:================\n");
            Worker.showExtent();
        } catch (Error | Exception error) {
            System.err.println(error);
        }

        //===============Worker 1
        List<Rank> rankForWorker1 = new ArrayList<>();
        rankForWorker1.add(Rank.JUNIOR);

        Worker jan = new Worker("Jan", "Kowalski", "jkow@gamil.com", "123456789", LocalDate.of(1998, 10, 1), LocalDate.of(2020, 10, 1), 5000d, rankForWorker1);
        System.out.println("\n========Worker 1========\n" + jan);


        //===============Worker 2
        List<Rank> rankForWorker2 = new ArrayList<>();
        rankForWorker2.add(Rank.MANAGER);
        rankForWorker2.add(Rank.SENIOR);

        Worker jakub = new Worker("Jakub", "Filip" , "Nowak", "jnow@gamil.com", "123456789", LocalDate.of(1990, 11, 2), LocalDate.of(2020, 10, 1), 7000d, rankForWorker2);
        System.out.println("\n========Worker 2========\n" + jakub);


        //===============The Highest Paid Worker
        Worker highestPaidEmployee = Worker.findTheHighestPaidEmployee();
        System.out.println("\n==============The Highest Paid Worker:==============\n" + highestPaidEmployee);

        try {
            saveExtentToFile(PATH);
        } catch (IOException exception) {
            System.err.println(exception);
        }
    }

    private static void saveExtentToFile(String path) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
        Extension.writeExtents(oos);
    }

    private static void readExtentFromFile(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));
        Extension.readExtents(ois);
    }
}