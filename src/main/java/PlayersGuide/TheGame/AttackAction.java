package PlayersGuide.TheGame;

import java.util.Random;

public enum AttackAction {
    PUNCH(1, 1, 100, DamageType.NORMAL),
    BONE_CRUNCH(0, 1, 100, DamageType.NORMAL),
    BITE(1, 1, 100, DamageType.NORMAL),
    DECODE(0, 4, 100, DamageType.DECODING),
    QUICK_SHOT(3, 3, 50, DamageType.NORMAL),
    STAB(1, 1, 90, DamageType.NORMAL),
    SLASH(2, 2, 90, DamageType.NORMAL);

    AttackAction(int MIN_DMG, int MAX_DMG, int PERCENTAGE_CHANCE_TO_HIT, DamageType DAMAGE_TYPE) {
        this.MAX_DMG = MAX_DMG;
        this.MIN_DMG = MIN_DMG;
        this.PERCENTAGE_CHANCE_TO_HIT = PERCENTAGE_CHANCE_TO_HIT;
        this.DAMAGE_TYPE = DAMAGE_TYPE;
    }

    private final int MIN_DMG;
    private final int MAX_DMG;
    private final int PERCENTAGE_CHANCE_TO_HIT;
    private final DamageType DAMAGE_TYPE;

    public int calculateDMG() {
        if (MIN_DMG == MAX_DMG) {
            return MIN_DMG;
        }
        return new Random().nextInt(MIN_DMG, MAX_DMG + 1);
    }

    public boolean attackHit() {
        return PERCENTAGE_CHANCE_TO_HIT - new Random().nextInt(100) > 0;
    }

    public DamageType getDAMAGE_TYPE() {
        return DAMAGE_TYPE;
    }
}
