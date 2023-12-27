package PlayersGuide.TheGame;

import java.util.Random;

public enum AttackAction {
    PUNCH(1, 1),
    BONE_CRUNCH(0, 1),
    DECODE(0, 2),
    STAB(1, 1),
    SLASH(2, 2);

    AttackAction(int MIN_DMG, int MAX_DMG) {
        this.MAX_DMG = MAX_DMG;
        this.MIN_DMG = MIN_DMG;
    }

    private final int MIN_DMG;
    private final int MAX_DMG;

    public int calculateDMG() {
        if (MIN_DMG == MAX_DMG) {
            return MIN_DMG;
        }
        return new Random().nextInt(MIN_DMG, MAX_DMG + 1);
    }
}
