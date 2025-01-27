package Ordered;

public class Item implements Comparable<Item> {
    private String name;
    private double price;

    private Shop shop;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Item(String name, double price, Shop shop) {
        this.name = name;
        this.price = price;
        setShop(shop);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        if (this.shop == shop) return;

        if (this.shop != null) {
            this.shop.removeItem(this);
        }

        this.shop = shop;

        if (shop != null) {
            shop.addItem(this);
        }
    }

    @Override
    public String toString() {
        return "You can find this item={name=" +  name + ", price=" + price + "} in " + shop.getName();
    }

    @Override
    public int compareTo(Item item) {
        return this.name.compareTo(item.name);
    }
}
