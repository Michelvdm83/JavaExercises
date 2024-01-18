package PlayersGuide.PackingInventory;

import java.util.ArrayList;

public class Pack {
    private final int MAX_ITEMS;
    private final double MAX_WEIGHT;
    private final double MAX_VOLUME;

    private double currentWeight;
    private double currentVolume;

    private final ArrayList<InventoryItem> itemList = new ArrayList<>();

    public Pack(int maxItems, double maxWeight, double maxVolume) {
        MAX_ITEMS = maxItems;
        MAX_WEIGHT = maxWeight;
        MAX_VOLUME = maxVolume;
        currentWeight = 0.0;
        currentVolume = 0.0;
    }

    public boolean add(InventoryItem newItem) {
        if (currentVolume + newItem.getVolume() > MAX_VOLUME) {
            System.out.println("Too much volume!");
            return false;
        }
        if (currentWeight + newItem.getWeight() > MAX_WEIGHT) {
            System.out.println("Too much weight!");
            return false;
        }
        if (itemList.size() == MAX_ITEMS) {
            System.out.println("Your pack has the maximum number of items it can contain!");
            return false;
        }
        itemList.add(newItem);
        currentVolume += newItem.getVolume();
        currentWeight += newItem.getWeight();
        return true;
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
        return currentWeight;
    }

    public double getCurrentVolume() {
        return currentVolume;
    }
}
