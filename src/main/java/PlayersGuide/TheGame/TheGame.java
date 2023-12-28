package PlayersGuide.TheGame;

import PlayersGuide.AnsiColors.AnsiColors;

import java.util.*;

public class TheGame {
    private Party HEROES;
    private Party MONSTERS;
    private final Party[] monsterTeams;
    private int numberOfMonsterTeamsLeft;
    private final int TOTAL_NUMBER_OF_MONSTER_TEAMS;
    private final Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        TheGame game = new TheGame();
        game.run();
    }

    public TheGame() {
        numberOfMonsterTeamsLeft = 3;
        TOTAL_NUMBER_OF_MONSTER_TEAMS = numberOfMonsterTeamsLeft;
        monsterTeams = new Party[TOTAL_NUMBER_OF_MONSTER_TEAMS];
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
        HEROES = new Party("The Hero", playerTypes[0]);
        for (int i = 0; i < TOTAL_NUMBER_OF_MONSTER_TEAMS; i++) {
            monsterTeams[i] = createNewMonsterTeam(TOTAL_NUMBER_OF_MONSTER_TEAMS - i, playerTypes[1]);
        }
        MONSTERS = monsterTeams[0];

        System.out.print("Please enter the True Programmer's character name: ");
        String programmerName = input.nextLine();
        TrueProgrammer trueProgrammer = new TrueProgrammer(programmerName);
        HEROES.addCharacterToTeam(trueProgrammer);
        HEROES.addToInventory(Potion.HEALTH_POTION);
        HEROES.addToInventory(Potion.HEALTH_POTION);
        HEROES.addToInventory(Potion.HEALTH_POTION);

        Party winner;
        while (true) {
            playerActions(HEROES);
            if (MONSTERS.getTEAM().isEmpty()) {
                System.out.println("The Heroes won this battle!");
                if (numberOfMonsterTeamsLeft > 0) {
                    numberOfMonsterTeamsLeft--;
                }
                if (numberOfMonsterTeamsLeft <= 0) {
                    winner = HEROES;
                    break;
                } else {
                    System.out.println("More enemies approaching!");
                    MONSTERS = monsterTeams[TOTAL_NUMBER_OF_MONSTER_TEAMS - numberOfMonsterTeamsLeft];
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

    private Party createNewMonsterTeam(int teamsLeft, PlayerType playerType) {
        Party returnParty = new Party("The Uncoded One", playerType);
        if (teamsLeft == 1) {
            returnParty.addCharacterToTeam(new Character("The Uncoded One", CharacterType.THE_UNCODED_ONE));
        } else {
            int numberOfMonsters = TOTAL_NUMBER_OF_MONSTER_TEAMS + 1 - teamsLeft;
            for (int i = 1; i <= numberOfMonsters; i++) {
                returnParty.addCharacterToTeam(Character.createSkeleton(i));
            }
            if (numberOfMonsters == 1) returnParty.getTEAM().get(0).equipWeapon(Weapon.DAGGER);
            if (numberOfMonsters == 2) {
                returnParty.addToInventory(Weapon.DAGGER);
                returnParty.addToInventory(Weapon.DAGGER);
            }
        }
        returnParty.addToInventory(Potion.HEALTH_POTION);
        return returnParty;
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
                    if (hpPercentage < 0.5) {
                        double chance = Math.random();
                        if (chance <= 0.25) {
                            performAction(player, c, BasicAction.USE_ITEM);
                            System.out.println();
                            continue;
                        }
                    }
                }
                if (options.contains(BasicAction.EQUIP_GEAR)) {
                    if (player.getInventory().contains(Weapon.DAGGER)) {
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
                } else {
                    System.out.println(opponent.getNAME() + " isn't part of " + opposingPlayer.getNAME() + "'s team");
                }
            }
        } else if (action.equals(BasicAction.USE_ITEM)) {
            if (player.getPlayerType() == PlayerType.AI) {
                player.letMemberUsePotion(character, Potion.HEALTH_POTION);
            } else {
                List<Item> filteredInventory = player.getInventory().stream().filter(item -> item.getClass() == Potion.class).toList();
                ArrayList<String> options = new ArrayList<>();
                for (Item i : filteredInventory) {
                    options.add(i.toString());
                }
                int choice = createMenuAndAskInput(options);
                player.letMemberUsePotion(character, (Potion) filteredInventory.get(choice));
            }
        } else if (action.equals(BasicAction.EQUIP_GEAR)) {
            if (player.getPlayerType() == PlayerType.AI) {
                player.equipToMember(character, Weapon.DAGGER);
            } else {
                List<Item> filteredInventory = player.getInventory().stream().filter(item -> item.getClass() == Weapon.class).toList();
                ArrayList<String> options = new ArrayList<>();
                for (Item i : filteredInventory) {
                    options.add(i.toString());
                }
                int choice = createMenuAndAskInput(options);
                player.equipToMember(character, (Weapon) filteredInventory.get(choice));
            }
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