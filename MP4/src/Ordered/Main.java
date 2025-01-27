package Ordered;

public class Main {
    public static void main(String[] args) {
        // 1 Shop - * Item
        Shop shop = new Shop("Auchan", "ul. Puławska 427 02-801 Warsaw Poland");

        Item item1 = new Item("DDD", 10);
        Item item2 = new Item("AAA", 17);

        shop.addItem(item1);
        shop.addItem(item2);

        Item item3 = new Item("CCC", 88, shop);

        System.out.println(shop + "\n");
    }
}
