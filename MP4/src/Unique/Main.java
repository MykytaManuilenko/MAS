package Unique;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("AAA", 1000, 1111);
        System.out.println(bankAccount1);

        BankAccount bankAccount2 = new BankAccount("BBB", 1000, 2222);
        System.out.println(bankAccount2);

        System.out.println();

        try {
            BankAccount bankAccount3 = new BankAccount("CCC", 1000, 1111);
            System.out.println(bankAccount3);
        } catch (IllegalArgumentException error) {
            System.err.println(error);
        }

        try {
            BankAccount bankAccount4 = new BankAccount("DDD", 1000, 2222);
            System.out.println(bankAccount4);
        } catch (IllegalArgumentException error) {
            System.err.println(error);
        }

        BankAccount bankAccount5 = new BankAccount("EEE", 1000, 5555);
        System.out.println(bankAccount5);
    }
}
