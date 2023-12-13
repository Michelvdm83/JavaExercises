package PlayersGuide.TheFeud;

import PlayersGuide.TheFeud.ifield.Sheep;
import PlayersGuide.TheFeud.mcdroid.Cow;

public class TheFeud {
    public static void main(String[] args) {
        Cow mcDroidCow = new Cow();
        PlayersGuide.TheFeud.mcdroid.Pig mcDroidPig = new PlayersGuide.TheFeud.mcdroid.Pig();
        var ifieldPig = iFieldPig();
        Sheep mcDroidSheep = new Sheep();
    }

    public static PlayersGuide.TheFeud.ifield.Pig iFieldPig() {
        return new PlayersGuide.TheFeud.ifield.Pig();
    }
}
