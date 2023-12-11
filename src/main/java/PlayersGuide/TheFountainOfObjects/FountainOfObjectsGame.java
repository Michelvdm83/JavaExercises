package PlayersGuide.TheFountainOfObjects;

import PlayersGuide.AnsiColors.AnsiColors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

enum Command {
    MOVE_NORTH,
    MOVE_SOUTH,
    MOVE_EAST,
    MOVE_WEST,
    ENABLE_FOUNTAIN,
    SHOOT_NORTH,
    SHOOT_SOUTH,
    SHOOT_EAST,
    SHOOT_WEST,
    HELP
}

enum RoomType {
    EMPTY,
    ENTRANCE,
    FOUNTAIN,
    PIT,
    MAELSTROM,
    AMAROK
}

public class FountainOfObjectsGame {
    //private final String[] COMMANDS = {"move north", "move south", "move east", "move west", "enable fountain"};
    private RoomType[][] field;
    private boolean fountainActivated = false;
    boolean playerWins = false, playerLoses = false;
    private Coordinate currentLocation;
    private int numberOfArrows = 5;

    private final Coordinate ENTRANCE_LOCATION = new Coordinate(0, 0);
    private Coordinate fountainLocation;// = new Coordinate(0, 2);
    private final String NARRATIVE = AnsiColors.ANSI_PURPLE;
    private final String DESCRIPTION = AnsiColors.ANSI_WHITE;
    private final String INPUT = AnsiColors.ANSI_CYAN;
    private final String LIGHT = AnsiColors.ANSI_YELLOW;
    private final String FOUNTAIN = AnsiColors.ANSI_BLUE;
    private final String RESET = AnsiColors.ANSI_RESET;

    private final Scanner input = new Scanner(System.in);

    public FountainOfObjectsGame() {

    }

    public void run() {
        System.out.println(NARRATIVE + "You are at the entrance of the cave with the " +
                FOUNTAIN + "Fountain of Objects");
        System.out.println(NARRATIVE + "If you can find and activate the " + FOUNTAIN + "Fountain" +
                NARRATIVE + ", you will save the island!");
        System.out.println("But there is a darkness in the cave impenetrable by any light!");
        System.out.println("Get to the " + FOUNTAIN + "Fountain of Objects" + NARRATIVE + "\n, activate it");
        System.out.println("and escape the cave to win!");
        /*
        If you chose to do the Pits challenge, add the following to the description: “Look out for pits. You
will feel a breeze if a pit is in an adjacent room. If you enter a room with a pit, you will die.”
If you chose to do the Maelstroms challenge, add the following to the description: “Maelstroms are
violent forces of sentient wind. Entering a room with one could transport you to any other location
in the caverns. You will be able to hear their growling and groaning in nearby rooms.”
If you chose to do the Amaroks challenge, add the following to the description: “Amaroks roam the
caverns. Encountering one is certain death, but you can smell their rotten stench in nearby rooms.”
If you chose to do the Getting Armed challenge, add the following to the description: “You carry with
you a bow and a quiver of arrows. You can use them to shoot monsters in the caverns but be warned:
you have a limited supply.”
         */
        System.out.println("""
                Look out for pits. You will feel a breeze if a pit is in an adjacent room.
                If you enter a room with a pit, you will die.
                                
                Maelstroms are violent forces of sentient wind.
                Entering a room with one could transport you to any other location
                in the caverns. You will be able to hear their growling and groaning in nearby rooms.
                                
                Amaroks roam the caverns. Encountering one is certain death,
                but you can smell their rotten stench in nearby rooms.
                """);
        System.out.println("You carry with you a bow and a quiver of arrows.\n" +
                "You can use them to shoot monsters in the caverns but be warned:\n" +
                "you have a limited supply of: " + numberOfArrows + "arrows." + RESET);

        while (true) {
            System.out.println("Please choose from the options below: ");
            System.out.println("""
                    The first 3 options will start the game with a field of the corresponding size
                    1. Small  (4 x 4)
                    2. Medium (6 x 6)
                    3. Large  (8 x 8)
                    4. Help""");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> createField(4);
                case 2 -> createField(6);
                case 3 -> createField(8);
                case 4 -> {
                    showHelp();
                    continue;
                }
                default -> {
                    continue;
                }
            }
            System.out.println("Your choice was: " + field.length + " x " + field.length);
            break;
        }
        currentLocation = new Coordinate(0, 0);

        checkRoom(currentLocation);
        while (playerWins == playerLoses) {
            System.out.println(DESCRIPTION + "You are in the room at " + currentLocation + "." + RESET);
            System.out.println(DESCRIPTION + "You have " + numberOfArrows + " arrows left." + RESET);
            System.out.print("What do you want to do? ");
            System.out.print(INPUT);
            String command = input.nextLine().toUpperCase();
            System.out.print(RESET);
            System.out.println("--------------------------------------------------------------");
            command = command.replace(" ", "_");
            if (!command.isEmpty()) executeCommand(command);
            //System.out.println(DESCRIPTION + "You are in the room at " + currentLocation + "." + RESET);
            checkRoom(currentLocation);
            //if(!(playerWins || playerLoses))System.out.print("What do you want to do? ");
        }

    }

    public void showHelp() {
        Map<Command, String> commandHelp = new LinkedHashMap<>();
        commandHelp.put(Command.MOVE_NORTH, "move 1 step north");
        commandHelp.put(Command.MOVE_SOUTH, "move 1 step south");
        commandHelp.put(Command.MOVE_EAST, "move 1 step east");
        commandHelp.put(Command.MOVE_WEST, "move 1 step west");
        commandHelp.put(Command.SHOOT_NORTH, "shoot an arrow into the room north of you");
        commandHelp.put(Command.SHOOT_SOUTH, "shoot an arrow into the room south of you");
        commandHelp.put(Command.SHOOT_EAST, "shoot an arrow into the room east of you");
        commandHelp.put(Command.SHOOT_WEST, "shoot an arrow into the room west of you");
        commandHelp.put(Command.ENABLE_FOUNTAIN, "activate the fountain if you're in the fountain room");
        commandHelp.put(Command.HELP, "show this help list");
        commandHelp.forEach((key, value) ->
                System.out.println(key.toString().toLowerCase().replace("_", " ") + ": " + value));
    }

    //create the game's field with different room types
    private void createField(int sizeOfSide) {
        field = new RoomType[sizeOfSide][sizeOfSide];
        fountainLocation = getRandomLocation();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                Coordinate current = new Coordinate(i, j);
                if (current.equals(fountainLocation)) {
                    field[i][j] = RoomType.FOUNTAIN;
                } else if (current.equals(ENTRANCE_LOCATION)) {
                    field[i][j] = RoomType.ENTRANCE;
                } else {
                    field[i][j] = RoomType.EMPTY;
                }
            }
        }
        //possibly doable with a map for the different number of special rooms
        int numberOfPits;
        int numberOfMaelstrom;
        int numberOfAmaroks;
        switch (sizeOfSide) {
            case 4 -> {
                numberOfPits = 1;
                numberOfMaelstrom = 1;
                numberOfAmaroks = 1;
            }
            case 6 -> {
                numberOfPits = 2;
                numberOfMaelstrom = 1;
                numberOfAmaroks = 2;
            }
            case 8 -> {
                numberOfPits = 4;
                numberOfMaelstrom = 2;
                numberOfAmaroks = 3;
            }
            default -> {
                numberOfPits = 0;
                numberOfMaelstrom = 0;
                numberOfAmaroks = 0;
            }
        }
        setRandomRoomTypeLocations(RoomType.PIT, numberOfPits);
        setRandomRoomTypeLocations(RoomType.MAELSTROM, numberOfMaelstrom);
        setRandomRoomTypeLocations(RoomType.AMAROK, numberOfAmaroks);
    }

    private void setRandomRoomTypeLocations(RoomType roomtype, int numberOfRooms) {
        for (int i = 0; i < numberOfRooms; i++) {
            while (true) {
                Coordinate temp = getRandomLocation();
                if (field[temp.row()][temp.column()] == RoomType.EMPTY) {
                    field[temp.row()][temp.column()] = roomtype;
                    break;
                }
            }
        }
    }

    private Coordinate getRandomLocation() {
        Random random = new Random();
        boolean randomizer = random.nextBoolean();
        int randomRow;
        int randomColumn;
        if (randomizer) {
            randomRow = (int) (Math.random() * (field.length - 2)) + 2;
            randomColumn = (int) (Math.random() * (field.length));
        } else {
            randomRow = (int) (Math.random() * (field.length));
            randomColumn = (int) (Math.random() * (field.length - 2)) + 2;
        }
        return new Coordinate(randomRow, randomColumn);
    }

    //check if something happens or is heard/felt in the room
    private void checkRoom(Coordinate currentPosition) {
        int row = currentPosition.row();
        int column = currentPosition.column();
        RoomType thisRoom = field[row][column];
        switch (thisRoom) {
            case ENTRANCE -> {
                if (fountainActivated) {
                    System.out.println("You made it out of the cave and reactivated the " + FOUNTAIN + "fountain" + RESET);
                    System.out.println("You win!");
                    playerWins = true;
                    return;
                } else {
                    System.out.println(LIGHT + "You see light coming from the cavern entrance." + RESET);
                }
            }
            case FOUNTAIN -> {
                if (fountainActivated) {
                    System.out.println(DESCRIPTION + "You hear the rushing waters from the "
                            + FOUNTAIN + "Fountain of Objects" + DESCRIPTION + ". It has been reactivated!" + RESET);
                } else {
                    System.out.println(DESCRIPTION + "You hear water dripping in this room. "
                            + FOUNTAIN + "The Fountain of Objects" + DESCRIPTION + " is here!" + RESET);
                }
            }
            case PIT -> {
                System.out.println("You fell into a pit.");
                System.out.println("game over!");
                playerLoses = true;
                return;
            }
            case AMAROK -> {
                System.out.println("An Amarok got you!");
                System.out.println("game over!");
                playerLoses = true;
                return;
            }
            case MAELSTROM -> {
                System.out.println(NARRATIVE + "A maelstrom blew you away" + RESET);
                field[row][column] = RoomType.EMPTY;
                int newRow = row - 1;
                int newColumn = column - 2;
                while (true) {
                    if (newRow < 0) newRow += field.length;
                    if (newColumn < 0) newColumn += field.length;
                    if (field[newRow][newColumn] == RoomType.EMPTY) {
                        field[newRow][newColumn] = RoomType.MAELSTROM;
                        break;
                    }
                    newRow -= 2;
                    newColumn--;
                }
                newRow = row + 1;
                newColumn = column + 2;
                if (newRow >= field.length) newRow -= field.length;
                if (newColumn >= field.length) newColumn -= field.length;
                currentLocation = new Coordinate(newRow, newColumn);
                checkRoom(currentLocation);
                return;
            }
            case EMPTY -> {
            }
        }
        //check the surrounding rooms for nearby special events
        if (checkNeighberhoodForRoomType(RoomType.PIT, row, column)) {
            System.out.println(NARRATIVE + "You feel a draft. There is a pit in a nearby room." + RESET);
        }
        if (checkNeighberhoodForRoomType(RoomType.MAELSTROM, row, column)) {
            System.out.println(NARRATIVE + "You hear the growling and groaning of a maelstrom nearby." + RESET);
        }
        if (checkNeighberhoodForRoomType(RoomType.AMAROK, row, column)) {
            System.out.println(NARRATIVE + "You can smell the rotten stench of an amarok in a nearby room." + RESET);
        }
    }

    private boolean checkNeighberhoodForRoomType(RoomType roomtype, int row, int column) {
        for (int i = row - 1; i <= row + 1; i++) {
            if (0 > i || i > field.length - 1) continue;
            for (int j = column - 1; j <= column + 1; j++) {
                if (0 > j || j > field[i].length - 1) continue;
                if (field[i][j] == roomtype) {
                    return true;
                }
            }
        }
        return false;
    }

    //checks if the entered command is legal and executes this if it is
    private void executeCommand(String command) {
        Command commando;
        try {
            commando = Command.valueOf(command);
        } catch (IllegalArgumentException e) {
            System.out.println("This is not a legal command!");
            return;
        }
        GameCommand nextCommand = GameCommand.getCommand(commando);
        nextCommand.run(this);
    }

    void moveOnRow(int step) {
        int newRowLocation = currentLocation.row() + step;
        if (0 <= newRowLocation && newRowLocation < field.length) {
            currentLocation = new Coordinate(newRowLocation, currentLocation.column());
        }
    }

    void moveOnColumn(int step) {
        int newColumnLocation = currentLocation.column() + step;
        if (0 <= newColumnLocation && newColumnLocation < field.length) {
            currentLocation = new Coordinate(currentLocation.row(), newColumnLocation);
        }
    }

    void enableFountain() {
        if (currentLocation.equals(fountainLocation)) fountainActivated = true;
        else System.out.println("You are not in the correct room");
    }

    void shoot(Coordinate room) {
        if (0 > Math.min(room.row(), room.column()) || Math.max(room.row(), room.column()) > field.length) {
            System.out.println(NARRATIVE + "You shot against a wall!");
            System.out.println("Luckily you managed to catch the arrow in the rebound." + RESET);
            return;
        }
        if (numberOfArrows > 0) {
            if (getRoomTypeOfRoom(room) == RoomType.AMAROK) {
                System.out.println(NARRATIVE + "You shot an Amarok!" + RESET);
                field[room.row()][room.column()] = RoomType.EMPTY;
            } else if (getRoomTypeOfRoom(room) == RoomType.MAELSTROM) {
                System.out.println(NARRATIVE + "You shot a Maelstrom!" + RESET);
                field[room.row()][room.column()] = RoomType.EMPTY;
            } else {
                System.out.println(NARRATIVE + "Your shot missed." + RESET);
            }
            numberOfArrows--;
        } else {
            System.out.println(NARRATIVE + "Sadly, you're out of arrows." + RESET);
        }
    }

    private RoomType getRoomTypeOfRoom(Coordinate room) {
        return field[room.row()][room.column()];
    }

    Coordinate getCurrentLocation() {
        return currentLocation;
    }
}

record Coordinate(int row, int column) {
}