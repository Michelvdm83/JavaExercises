package PlayersGuide.TheGame;

public enum DefensiveBuff {
    STONE_ARMOR(1, DamageType.ALL),
    OBJECT_SIGHT(2, DamageType.DECODING);

    DefensiveBuff(int damageReduction, DamageType resistantTo) {
        DAMAGE_REDUCTION = damageReduction;
        RESISTANT_TO = resistantTo;
    }

    public int getDAMAGE_REDUCTION() {
        return DAMAGE_REDUCTION;
    }

    public boolean isResistantTo(DamageType damageType) {
        if (RESISTANT_TO == DamageType.ALL) {
            return true;
        }
        return (RESISTANT_TO == damageType);
    }

    private final int DAMAGE_REDUCTION;
    private final DamageType RESISTANT_TO;
}

