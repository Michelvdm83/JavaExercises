package playersguide.PackingInventory;

import java.util.ArrayList;

public class Pack {
    private final int MAX_ITEMS;
    private final double MAX_WEIGHT;
    private final double MAX_VOLUME;

    private final ArrayList<InventoryItem> itemList = new ArrayList<>();

    public Pack(int maxItems, double maxWeight, double maxVolume) {
        MAX_ITEMS = maxItems;
        MAX_WEIGHT = maxWeight;
        MAX_VOLUME = maxVolume;
    }

    public boolean canItemBeAdded(InventoryItem newItem) {
        if (itemList.size() >= MAX_ITEMS) {
            System.out.println("Your pack has the maximum number of items it can contain!");
            return false;
        }
        boolean tooMuchVolume = (getCurrentVolume() + newItem.getVolume() > MAX_VOLUME);
        boolean tooMuchWeight = (getCurrentWeight() + newItem.getWeight() > MAX_WEIGHT);
        if (tooMuchVolume) {
            System.out.println("Too much volume!");
        }
        if (tooMuchWeight) {
            System.out.println("Too much weight!");
        }
        return !(tooMuchVolume || tooMuchWeight);
    }

    public void add(InventoryItem newItem) {
        if (canItemBeAdded(newItem)) {
            itemList.add(newItem);
        } else {
            System.out.println("Forgot to check with canItemBeAdded method");
        }
    }

    @Override
    public String toString() {
        ArrayList<String> list = new ArrayList<>();
        itemList.forEach(i -> list.add(i.toString()));
        list.sort(null);
        return String.join(" ", list);
    }

    public int getMaxItems() {
        return MAX_ITEMS;
    }

    public double getMaxWeight() {
        return MAX_WEIGHT;
    }

    public double getMaxVolume() {
        return MAX_VOLUME;
    }

    public int getCurrentNumberOfItems() {
        return itemList.size();
    }

    public double getCurrentWeight() {
        return itemList.stream().mapToDouble(InventoryItem::getWeight).sum();
    }

    public double getCurrentVolume() {
        return itemList.stream().mapToDouble(InventoryItem::getVolume).sum();
    }
}
