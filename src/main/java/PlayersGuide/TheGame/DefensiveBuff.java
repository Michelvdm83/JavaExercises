package PlayersGuide.TheGame;

import java.util.Arrays;

public enum DefensiveBuff {
    STONE_ARMOR(1, DamageType.values()),
    OBJECT_SIGHT(2, new DamageType[]{DamageType.DECODING});

    DefensiveBuff(int damageReduction, DamageType[] resistantTo) {
        DAMAGE_REDUCTION = damageReduction;
        RESISTANT_TO = resistantTo;

    }

    public int getDAMAGE_REDUCTION() {
        return DAMAGE_REDUCTION;
    }

    public boolean isResistantTo(DamageType damageType) {
        return Arrays.asList(RESISTANT_TO).contains(damageType);
/*        if (RESISTANT_TO == DamageType.ALL) {
            return true;
        }
        return (RESISTANT_TO == damageType);*/
    }

    private final int DAMAGE_REDUCTION;
    private final DamageType[] RESISTANT_TO;
}

