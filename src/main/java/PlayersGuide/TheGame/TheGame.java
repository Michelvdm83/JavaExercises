package PlayersGuide.TheGame;

import PlayersGuide.AnsiColors.AnsiColors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TheGame {
    private Party HEROES;
    private Party MONSTERS;
    private final List<Party> monsterList = new ArrayList<>();
    private int numberOfMonsterTeamsLeft;
    private final int TOTAL_NUMBER_OF_MONSTER_TEAMS;
    private final Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        TheGame game = new TheGame();
        game.run();
    }

    public TheGame() {
        createOpponents();
        numberOfMonsterTeamsLeft = monsterList.size();
        TOTAL_NUMBER_OF_MONSTER_TEAMS = numberOfMonsterTeamsLeft;
    }

    private void createOpponents() {
        //file format:
        /*
        Teamname
        nrOfItems
        items: ItemType Item
        nrOfMembers
        members: Name Type Weapon
         */
        Path filePath = Path.of("src/main/java/PlayersGuide/TheGame/Opponents.txt");

        System.out.println(filePath);
        try {
            //read the entire file
            LinkedList<String> fileLines = new LinkedList<>(Files.readAllLines(filePath));

            //while there are more lines available, create new teams
            while (!fileLines.isEmpty()) {
                LinkedList<String> partyText = new LinkedList<>();
                String s = fileLines.removeFirst();
                while (!s.isEmpty()) {
                    partyText.add(s);
                    s = fileLines.removeFirst();
                }
                String partyName = partyText.removeFirst();
                Party party = new Party(partyName);
                int nrOfItems = Integer.parseInt(partyText.removeFirst());
                for (int i = 0; i < nrOfItems; i++) {
                    String[] itemLine = partyText.removeFirst().split(" ");
                    ItemType type = ItemType.valueOf(itemLine[0]);

                    Item item = switch (type) {
                        case POTION -> Potion.valueOf(itemLine[1]);
                        case WEAPON -> Weapon.valueOf(itemLine[1]);
                    };
                    party.addToInventory(item);
                }
                int nrOfMembers = Integer.parseInt(partyText.removeFirst());
                for (int j = 0; j < nrOfMembers; j++) {
                    String[] memberLine = partyText.removeFirst().split(" ");
                    String memberName = memberLine[0];
                    CharacterType type = CharacterType.valueOf(memberLine[1]);
                    Character member = new Character(memberName, type);
                    try {
                        Weapon weapon = Weapon.valueOf(memberLine[2]);
                        member.equipWeapon(weapon);
                        System.out.println(memberLine[2] + " is a weapon");
                    } catch (Exception e) {
                        System.out.println(memberLine[2] + " is no weapon");
                    }
                    party.addCharacterToTeam(member);
                }
                monsterList.add(party);
            }

        } catch (IOException e) {
            System.out.println("loading levels has failed!");
            e.printStackTrace(System.out);
            System.exit(0);
        }

    }

    public void run() {
        System.out.println("Choose game type:");
        ArrayList<String> gameTypeOptions = new ArrayList<>();
        gameTypeOptions.add("Computer vs Computer");
        gameTypeOptions.add("Human vs Computer");
        gameTypeOptions.add("Human vs Human");
        PlayerType[] playerTypes = switch (createMenuAndAskInput(gameTypeOptions)) {
            case 0 -> new PlayerType[]{PlayerType.AI, PlayerType.AI};
            case 1 -> new PlayerType[]{PlayerType.HUMAN, PlayerType.AI};
            case 2 -> new PlayerType[]{PlayerType.HUMAN, PlayerType.HUMAN};
            default -> new PlayerType[]{PlayerType.AI, PlayerType.HUMAN};
        };
        HEROES = new Party("The Heroes");
        HEROES.setPlayerType(playerTypes[0]);

        for (int i = 0; i < TOTAL_NUMBER_OF_MONSTER_TEAMS; i++) {
            monsterList.get(i).setPlayerType(playerTypes[1]);
        }
        MONSTERS = monsterList.get(0);

        System.out.print("Please enter the True Programmer's character name: ");
        String programmerName = input.nextLine();
        Character trueProgrammer = new Character(programmerName, CharacterType.TRUE_PROGRAMMER);
        HEROES.addCharacterToTeam(trueProgrammer);
        HEROES.addCharacterToTeam(new Character("Vin Fletcher", CharacterType.VIN_FLETCHER));
        HEROES.addToInventory(Potion.HEALTH_POTION);
        HEROES.addToInventory(Potion.HEALTH_POTION);
        HEROES.addToInventory(Potion.HEALTH_POTION);


        Party winner;
        while (true) {
            playerActions(HEROES);
            if (MONSTERS.getTEAM().isEmpty()) {
                System.out.println("The Heroes won this battle!");
                List<Item> lootedInventory = MONSTERS.getInventory();
                if (!lootedInventory.isEmpty()) {
                    System.out.println("Loot:");
                    for (Item item : lootedInventory) {
                        HEROES.addToInventory(item);
                        System.out.println(item.toString().replace("_", " "));
                    }
                }
                if (numberOfMonsterTeamsLeft > 0) {
                    numberOfMonsterTeamsLeft--;
                }
                if (numberOfMonsterTeamsLeft <= 0) {
                    winner = HEROES;
                    break;
                } else {
                    System.out.println("More enemies approaching!");
                    MONSTERS = monsterList.get(TOTAL_NUMBER_OF_MONSTER_TEAMS - numberOfMonsterTeamsLeft);
                    continue;
                }
            }
            playerActions(MONSTERS);
            if (HEROES.getTEAM().isEmpty()) {
                winner = MONSTERS;
                break;
            }
        }
        if (winner.equals(HEROES)) {
            System.out.printf("%s's party has defeated %s and his evil minions!%n", winner.getNAME(), MONSTERS.getNAME());
        } else {
            System.out.printf("The heroes have lost! %s's forces have prevailed!", MONSTERS.getNAME());
        }
    }

    private int createMenuAndAskInput(ArrayList<String> options) {
        int itemNumber = 1;
        for (String s : options) {
            System.out.println(itemNumber + ". " + s);
            itemNumber++;
        }
        System.out.print("Your choice: ");
        try {
            String option = input.nextLine();
            int choice = Integer.parseInt(option) - 1;
            if (choice < 0 || options.size() <= choice) {
                throw new IndexOutOfBoundsException();
            }
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("Not a number!");
            return createMenuAndAskInput(options);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please choose a number from the list!");
            return createMenuAndAskInput(options);
        }
    }

    private BasicAction askForAction(Character currentCharacter, EnumSet<BasicAction> options) {
        System.out.println("Choose an action: ");
        ArrayList<String> actionList = new ArrayList<>();
        for (BasicAction a : options) {
            String actionString = a.toString().replace("_", " ");
            if (a == BasicAction.ATTACK) {
                actionString = actionString.concat(" (" + currentCharacter.getAttackType().toString() + ")");
            }
            if (a == BasicAction.WEAPON_ATTACK) {
                actionString = actionString.concat(" (" + currentCharacter.getWeapon().getAttackAction().toString() + ")");
            }
            actionList.add(actionString);
        }
        int choice = createMenuAndAskInput(actionList);
        return BasicAction.values()[choice];
    }

    private void playerActions(Party player) {
        Collection<Character> team = player.getTEAM();
        System.out.println(player.getNAME() + "'s team has it's turns now");
        for (Character c : team) {
            Party opposingPlayer = player.equals(HEROES) ? MONSTERS : HEROES;
            if (opposingPlayer.getTEAM().isEmpty()) {
                return;
            }
            showBattleState(c);
            System.out.println("It's " + c.getNAME() + "'s turn.");
            EnumSet<BasicAction> options = player.getPossibleActionsForMember(c);
            if (player.getPlayerType() == PlayerType.HUMAN) {
                BasicAction currentAction = askForAction(c, options);
                performAction(player, c, currentAction);
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Something interrupted my sleep!");
                }
                //getAIAction?
                if (options.contains(BasicAction.USE_ITEM)) {
                    double hpPercentage = (double) c.getCurrentHP() / c.getMAX_HP();
                    if (player.hasPotionInInventory() && hpPercentage < 0.5) {
                        double chance = Math.random();
                        if (chance <= 0.25) {
                            performAction(player, c, BasicAction.USE_ITEM);
                            System.out.println();
                            continue;
                        }
                    }
                }
                if (options.contains(BasicAction.EQUIP_GEAR)) {
                    if (player.hasGearInInventory() && c.getWeapon() == null) {
                        double chance = Math.random();
                        if (chance <= 0.50) {
                            performAction(player, c, BasicAction.EQUIP_GEAR);
                            System.out.println();
                            continue;
                        }
                    }
                }
                if (c.getWeapon() != null) {
                    performAction(player, c, BasicAction.WEAPON_ATTACK);
                } else performAction(player, c, BasicAction.ATTACK);
            }
            System.out.println();
        }
    }

    private void performAction(Party player, Character character, BasicAction action) {
        if (action.equals(BasicAction.DO_NOTHING)) {
            character.doNothing();
        } else if (action.equals(BasicAction.ATTACK) || action.equals(BasicAction.WEAPON_ATTACK)) {
            List<Character> opponentTeam = player.equals(HEROES) ? MONSTERS.getTEAM() : HEROES.getTEAM();
            Character opponent = opponentTeam.get(0);
            if (action == BasicAction.ATTACK) character.attack(opponent);
            if (action == BasicAction.WEAPON_ATTACK) character.weaponAttack(opponent);
            if (!opponent.isAlive()) {
                Party opposingPlayer = player.equals(HEROES) ? MONSTERS : HEROES;
                if (opposingPlayer.removeCharacterFromTeam(opponent)) {
                    System.out.println(opponent.getNAME() + " has been defeated!");
                    Weapon opponentWeapon = opponent.getWeapon();
                    if (opponentWeapon != null) {
                        player.addToInventory(opponentWeapon);
                        System.out.println(player.getNAME() + " looted " + opponentWeapon);
                    }
                } else {
                    System.out.println(opponent.getNAME() + " isn't part of " + opposingPlayer.getNAME() + "'s team");
                }
            }
        } else if (action.equals(BasicAction.USE_ITEM)) {
            Potion potionUsed;
            List<Item> filteredInventory = player.getInventory().stream().filter(item -> item.getClass() == Potion.class).toList();
            if (player.getPlayerType() == PlayerType.AI) {
                potionUsed = (Potion) filteredInventory.get(0);
                player.letMemberUsePotion(character, potionUsed);
            } else {
                ArrayList<String> options = new ArrayList<>();
                for (Item i : filteredInventory) {
                    options.add(i.toString());
                }
                int choice = createMenuAndAskInput(options);
                potionUsed = (Potion) filteredInventory.get(choice);
                player.letMemberUsePotion(character, potionUsed);
            }
            System.out.println(potionUsed.toString() + " was used");
        } else if (action.equals(BasicAction.EQUIP_GEAR)) {
            Weapon weaponEquipped;
            List<Item> filteredInventory = player.getInventory().stream().filter(item -> item.getClass() == Weapon.class).toList();
            if (player.getPlayerType() == PlayerType.AI) {
                weaponEquipped = (Weapon) filteredInventory.get(0);
                player.equipToMember(character, weaponEquipped);
            } else {
                ArrayList<String> options = new ArrayList<>();
                for (Item i : filteredInventory) {
                    options.add(i.toString());
                }
                int choice = createMenuAndAskInput(options);
                weaponEquipped = (Weapon) filteredInventory.get(choice);
                player.equipToMember(character, weaponEquipped);
            }
            System.out.println(character.getNAME() + " has equipped " + weaponEquipped.toString());
        }
    }

    private void showBattleState(Character currentCharacter) {
        ArrayList<Character> heroesTeam = new ArrayList<>(HEROES.getTEAM());
        ArrayList<Character> monstersTeam = new ArrayList<>(MONSTERS.getTEAM());
        StringBuilder battleOverview = new StringBuilder("============================================= BATTLE ============================================\n");
        for (Character c : heroesTeam) {
            String textColor = c.equals(currentCharacter) ? AnsiColors.ANSI_PURPLE : AnsiColors.ANSI_RESET;
            String newLine = textColor + c.getNAME() + " (" + c.getCurrentHP() + "/" + c.getMAX_HP() + ")" + AnsiColors.ANSI_RESET;
            if (c.getWeapon() != null) newLine = newLine.concat(" (equipped with: " + c.getWeapon().toString() + ")");
            battleOverview.append(newLine.concat("\n"));
        }
        battleOverview.append("---------------------------------------------- VS -----------------------------------------------\n");
        for (Character c : monstersTeam) {
            String textColor = c.equals(currentCharacter) ? AnsiColors.ANSI_PURPLE : AnsiColors.ANSI_RESET;
            String newLine = textColor + c.getNAME() + " (" + c.getCurrentHP() + "/" + c.getMAX_HP() + ")" + AnsiColors.ANSI_RESET;
            if (c.getWeapon() != null) newLine = newLine.concat(" (equipped with: " + c.getWeapon().toString() + ")");
            battleOverview.append(newLine.concat("\n"));
        }
        battleOverview.append("=================================================================================================");
        System.out.println(battleOverview);
    }
}