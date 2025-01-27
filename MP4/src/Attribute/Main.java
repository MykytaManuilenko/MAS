package Attribute;

public class Main {
    public static void main(String[] args) {
        TheaterPlay theaterPlay1 = new TheaterPlay("Scarlet Sails", 90);
        System.out.println(theaterPlay1);

        System.out.println();

        try {
            TheaterPlay theaterPlay2 = new TheaterPlay("Roméo et Juliette", 30);
            System.out.println(theaterPlay2);
        } catch (Error error) {
            System.err.println(error);
        }
    }
}
