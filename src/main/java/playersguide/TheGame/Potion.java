package playersguide.TheGame;

public enum Potion implements Item {
    HEALTH_POTION,
    SIMULAS_SOUP;

    public void useOn(Character character) {
        switch (this) {
            case HEALTH_POTION -> character.getHealed(10);
            case SIMULAS_SOUP -> character.getHealed(character.getMAX_HP());
        }
    }

    private final ItemType TYPE = ItemType.POTION;

    @Override
    public ItemType getItemType() {
        return TYPE;
    }
}
