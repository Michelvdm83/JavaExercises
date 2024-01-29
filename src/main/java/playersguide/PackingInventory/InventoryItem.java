package playersguide.PackingInventory;

public class InventoryItem {
    private final double weight;
    private final double volume;

    public InventoryItem(double weight, double volume) {
        this.weight = weight;
        this.volume = volume;
    }

    @Override
    public String toString() {
        String nameString = getClass().getSimpleName();
        StringBuilder returner = new StringBuilder();
        for (int i = 0; i < nameString.length(); i++) {
            char c = nameString.charAt(i);
            if (i > 0 && Character.isUpperCase(c)) {
                returner.append(" ");
            }
            returner.append(Character.toLowerCase(c));
        }
        return returner.toString();
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }
}

class Arrow extends InventoryItem {

    public Arrow() {
        super(0.1, 0.05);
    }
}

class Bow extends InventoryItem {
    public Bow() {
        super(1.0, 4.0);
    }
}

class Rope extends InventoryItem {
    public Rope() {
        super(1.0, 1.5);
    }
}

class Water extends InventoryItem {
    public Water() {
        super(2.0, 3.0);
    }
}

class FoodRations extends InventoryItem {
    public FoodRations() {
        super(1.0, 0.5);
    }
}

class Sword extends InventoryItem {
    public Sword() {
        super(5.0, 3.0);
    }
}

/*
An arrow has a weight of 0.1 and a volume of 0.05.
A bow has a weight of 1 and a volume of 4.
Rope has a weight of 1 and a volume of 1.5.
Water has a weight of 2 and a volume of 3.
Food rations have a weight of 1 and a volume of 0.5.
A sword has a weight of 5 and a volume of 3.
 */
