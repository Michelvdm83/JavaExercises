package playersguide.TheGame;

public enum Weapon implements Item {
    DAGGER(AttackAction.STAB),
    VINS_BOW(AttackAction.QUICK_SHOT),
    SWORD(AttackAction.SLASH);


    //private int turnsUsed = 0;
    private final ItemType TYPE = ItemType.WEAPON;
    private final AttackAction attackAction;

    Weapon(AttackAction attackAction) {
        this.attackAction = attackAction;
    }

    @Override
    public ItemType getItemType() {
        return TYPE;
    }

    public AttackAction getAttackAction() {
        return attackAction;
    }

    public String toString() {
        if (this == VINS_BOW) return "VIN'S BOW";
        return super.toString();
    }
}
