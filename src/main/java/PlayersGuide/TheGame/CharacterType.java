package PlayersGuide.TheGame;

public enum CharacterType {
    TRUE_PROGRAMMER(25, AttackAction.PUNCH),
    SKELETON(5, AttackAction.BONE_CRUNCH),
    THE_UNCODED_ONE(15, AttackAction.DECODE);

    CharacterType(final int MAX_HP, final AttackAction STANDARD_ATTACK) {
        this.MAX_HP = MAX_HP;
        this.STANDARD_ATTACK = STANDARD_ATTACK;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public AttackAction getSTANDARD_ATTACK() {
        return STANDARD_ATTACK;
    }

    private final int MAX_HP;
    private final AttackAction STANDARD_ATTACK;
}
