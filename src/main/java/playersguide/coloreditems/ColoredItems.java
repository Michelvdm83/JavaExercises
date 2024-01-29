package playersguide.coloreditems;

import playersguide.coloreditems.items.Axe;
import playersguide.coloreditems.items.Bow;
import playersguide.coloreditems.items.Sword;

public class ColoredItems {
    public static void main(String[] args) {
        ColoredItem<Sword> sword = new ColoredItem<>(new Sword(), "blue");
        ColoredItem<Bow> bow = new ColoredItem<>(new Bow(), "red");
        ColoredItem<Axe> axe = new ColoredItem<>(new Axe(), "green");
        sword.display();
        System.out.println();
        bow.display();
        System.out.println();
        axe.display();
    }
}
