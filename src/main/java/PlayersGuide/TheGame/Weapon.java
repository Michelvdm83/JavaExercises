package PlayersGuide.TheGame;

public enum Weapon implements Item {
    DAGGER(AttackAction.STAB),
    SWORD(AttackAction.SLASH);


    //private int turnsUsed = 0;
    private final ItemType TYPE = ItemType.GEAR;
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
}
