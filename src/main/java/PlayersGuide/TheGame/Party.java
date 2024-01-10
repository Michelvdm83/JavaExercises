package PlayersGuide.TheGame;


import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Party {
    private final String NAME;
    private PlayerType playerType = PlayerType.AI;
    private final List<Character> TEAM = new ArrayList<>();
    private final List<Item> INVENTORY = new ArrayList<>();
    private boolean potionInInventory = false;
    private boolean gearInInventory = false;

    public Party(String name) {
        NAME = name;
    }

    public Party(Party p) {
        NAME = p.getNAME();
        playerType = p.getPlayerType();
        for (Character c : p.getTEAM()) {
            Character newC = new Character(c.getNAME(), c.getTYPE());
            newC.equipWeapon(c.getWeapon());
            TEAM.add(newC);
        }
        for (Item item : p.getInventory()) {
            this.addToInventory(item);
        }
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public void addCharacterToTeam(Character character) {
        TEAM.add(character);
    }

    public boolean removeCharacterFromTeam(Character character) {
        return TEAM.remove(character);
    }

    public void letMemberUsePotion(Character character, Potion potion) {
        if (TEAM.contains(character)) {
            if (INVENTORY.remove(potion)) {
                character.usePotion(potion);
                potionInInventory = false;
                for (Item item : INVENTORY) {
                    if (item.getItemType() == ItemType.POTION) {
                        potionInInventory = true;
                        break;
                    }
                }
            }
        }
    }

    public void equipToMember(Character character, Weapon weapon) {
        if (TEAM.contains(character)) {
            if (INVENTORY.remove(weapon)) {
                Weapon characterWeapon = character.getWeapon();
                if (characterWeapon != null) {
                    INVENTORY.add(characterWeapon);
                }
                character.equipWeapon(weapon);
                gearInInventory = false;
                for (Item item : INVENTORY) {
                    if (item.getItemType() == ItemType.WEAPON) {
                        gearInInventory = true;
                        break;
                    }
                }
            }
        }
    }

    public void addToInventory(Item item) {
        if (item.getItemType() == ItemType.POTION) potionInInventory = true;
        if (item.getItemType() == ItemType.WEAPON) gearInInventory = true;
        INVENTORY.add(item);
    }

    public List<Item> getInventory() {
        return INVENTORY;
    }

    public List<Character> getTEAM() {
        return TEAM;
    }

    public EnumSet<BasicAction> getPossibleActionsForMember(Character character) {
        EnumSet<BasicAction> options = EnumSet.allOf(BasicAction.class);
        if (!potionInInventory) options.remove(BasicAction.USE_ITEM);
        if (!gearInInventory) options.remove(BasicAction.EQUIP_GEAR);
        if (character.getWeapon() == null) options.remove(BasicAction.WEAPON_ATTACK);
        return options;
    }

    public boolean hasPotionInInventory() {
        return potionInInventory;
    }

    public boolean hasGearInInventory() {
        return gearInInventory;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public String getNAME() {
        return NAME;
    }
}
