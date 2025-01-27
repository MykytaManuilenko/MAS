package Ordered;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
    private String name;
    private String address;

    private List<Item> items = new ArrayList<>();

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (item == null) {
            throw new NullPointerException("Item can not be null");
        } else if (!items.contains(item)) {
            items.add(item);
            item.setShop(this);
        }

        Collections.sort(items);
    }

    public void removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            item.setShop(null);
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Shop " + this.name + " with address" + this.address + "has items:\n");

        for (Item item : items) {
            info.append(" Item={name=").append(item.getName()).append(", price=").append(item.getPrice()).append("}\n");
        }

        return info.toString();
    }
}
