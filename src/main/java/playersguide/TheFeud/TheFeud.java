package playersguide.TheFeud;

import playersguide.TheFeud.ifield.Sheep;
import playersguide.TheFeud.mcdroid.Cow;

public class TheFeud {
    public static void main(String[] args) {
        Cow mcDroidCow = new Cow();
        playersguide.TheFeud.mcdroid.Pig mcDroidPig = new playersguide.TheFeud.mcdroid.Pig();
        var ifieldPig = iFieldPig();
        Sheep mcDroidSheep = new Sheep();
    }

    public static playersguide.TheFeud.ifield.Pig iFieldPig() {
        return new playersguide.TheFeud.ifield.Pig();
    }
}
