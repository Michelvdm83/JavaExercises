package PlayersGuide.PackingInventory;

public class InventoryItem {
    private final double weight;
    private final double volume;
    public InventoryItem(double weight, double volume){
        this.weight = weight;
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }
}

class Arrow extends InventoryItem{

    public Arrow() {
        super(0.1, 0.05);
    }
    public String toString(){
        return "Arrow";
    }
}
class Bow extends InventoryItem{
    public Bow(){
        super(1.0, 4.0);
    }
    public String toString(){
        return "Bow";
    }
}
class Rope extends InventoryItem{
    public Rope(){
        super(1.0, 1.5);
    }
    public String toString(){
        return "Rope";
    }
}
class Water extends InventoryItem{
    public Water(){
        super(2.0, 3.0);
    }
    public String toString(){
        return "Water";
    }
}
class FoodRations extends InventoryItem{
    public FoodRations(){
        super(1.0, 0.5);
    }
    public String toString(){
        return "Food rations";
    }
}
class Sword extends InventoryItem{
    public Sword(){
        super(5.0, 3.0);
    }
    public String toString(){
        return "Sword";
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
