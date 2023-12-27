package PlayersGuide.TheGame;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Party {
    private final String NAME;
    private final PlayerType playerType;
    private final List<Character> TEAM = new ArrayList<>();
    private final List<Item> INVENTORY = new ArrayList<>();
    private boolean potionInInventory = false;
    private boolean gearInInventory = false;

    public Party(String name, PlayerType playerType) {
        NAME = name;
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
                character.useItem(potion);
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
                Weapon characterWeapon = character.equipWeapon(weapon);
                if (characterWeapon != null) {
                    INVENTORY.add(characterWeapon);
                }
                gearInInventory = false;
                for (Item item : INVENTORY) {
                    if (item.getItemType() == ItemType.GEAR) {
                        gearInInventory = true;
                        break;
                    }
                }
            }
        }
    }

    public void addToInventory(Item item) {
        if (item.getItemType() == ItemType.POTION) potionInInventory = true;
        if (item.getItemType() == ItemType.GEAR) gearInInventory = true;
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

    public PlayerType getPlayerType() {
        return playerType;
    }

    public String getNAME() {
        return NAME;
    }
}
