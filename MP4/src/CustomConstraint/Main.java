package CustomConstraint;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("AAA AAA", "test@gmail.com");
        System.out.println(user1);

        System.out.println();

        try {
            User user2 = new User("BBB BBB", "test2_gmail.com");
            System.out.println(user2);
        } catch (Error error) {
            System.err.println(error);
        }
    }
}
