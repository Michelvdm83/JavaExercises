package playersguide.TheFountainOfObjects;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.UnaryOperator;

import static generic.CommandLine.*;


enum RoomType {
    EMPTY,
    ENTRANCE,
    FOUNTAIN,
    PIT,
    MAELSTROM,
    AMAROK
}


public class FountainOfObjectsGame {

    private RoomType[][] field;
    private boolean fountainActivated;
    private Coordinate currentLocation;
    private int numberOfArrows = 5;

    private final Coordinate ENTRANCE_LOCATION = new Coordinate(0, 0);
    private Coordinate fountainLocation;

    private final UnaryOperator<String> NARRATE = purple;
    private final UnaryOperator<String> FOUNTAIN_TEXT = blue;
    private final UnaryOperator<String> DESCRIPE = white;
    private final UnaryOperator<String> LOCATION_TEXT = green;
    private final UnaryOperator<String> LIGHT_TEXT = yellow;


    public FountainOfObjectsGame() {
        currentLocation = ENTRANCE_LOCATION;
    }

    private void showIntroStory() {
        System.out.println(NARRATE.apply("You are at the entrance of the cave with the ") + FOUNTAIN_TEXT.apply("Fountain of Objects"));
        System.out.println(NARRATE.apply("If you can find and activate the ") + FOUNTAIN_TEXT.apply("Fountain") + NARRATE.apply(", you will save the island!"));
        System.out.println(NARRATE.apply("But there is a darkness in the cave impenetrable by any light!"));
        System.out.println(NARRATE.apply("Get to the ") + FOUNTAIN_TEXT.apply("Fountain of Objects\n") + NARRATE.apply(", activate it"));
        System.out.println(NARRATE.apply("and escape the cave to win!"));

        System.out.println(NARRATE.apply("""
                Look out for pits. You will feel a breeze if a pit is in an adjacent room.
                If you enter a room with a pit, you will die.
                                
                Maelstroms are violent forces of sentient wind.
                Entering a room with one could transport you to any other location
                in the caverns. You will be able to hear their growling and groaning in nearby rooms.
                                
                Amaroks roam the caverns. Encountering one is certain death,
                but you can smell their rotten stench in nearby rooms.
                """));

        System.out.println(NARRATE.apply("You carry with you a bow and a quiver of arrows.\n" +
                "You can use them to shoot monsters in the caverns but be warned:\n" +
                "you have a limited supply of: " + numberOfArrows + " arrows."));
    }

    private void startMenu() {
        do {
            var options = new ArrayList<String>();
            for (FieldData fd : FieldData.values()) {
                String optionString = String.format("new game with %s field (%dx%d)", fd.name(), fd.getSizeOfSides(), fd.getSizeOfSides());
                options.add(optionString);
            }
            String helpString = "Show list of ingame commands";
            options.add(helpString);

            int choice = askForIntFromMenu("Please choose from the options below: ", options.toArray(String[]::new));
            if (options.get(choice - 1).equals(helpString)) {
                showHelp();
            } else {
                FieldData chosenField = FieldData.values()[choice - 1];
                createField(chosenField);
            }
            System.out.println();

        } while (field == null);
        System.out.println("Your choice was: " + field.length + " x " + field.length);
        System.out.println(fountainLocation);
    }

    public void run() {
        showIntroStory();
        startMenu();

        LocalDateTime startMoment = LocalDateTime.now();
        do {
            System.out.println("-----------------------------------------------------------------------");
            showCurrentPosition();
            checkCurrentRoom();
            if ((currentLocation.equals(ENTRANCE_LOCATION) && fountainActivated)) {
                System.out.println("You win!");
                break;
            }
            checkSurroundingRooms();
            System.out.println(DESCRIPE.apply("You have " + numberOfArrows + " arrows left."));

            GameCommand command = askForEnumValueFromEnumMenu("What do you want to do? ", GameCommand.values());
            command.execute(this);
        } while (!hasPlayerLost());

        LocalDateTime finishMoment = LocalDateTime.now();
        Duration duration = Duration.between(startMoment, finishMoment);
        int hours = duration.toHoursPart();
        int minutes = duration.toMinutesPart();
        int seconds = duration.toSecondsPart();
        System.out.print("You've been inside the cave for ");
        if (hours > 0) System.out.print(hours + " hours, ");
        System.out.println(minutes + " minutes and " + seconds + " seconds");
    }

    public void showHelp() {
        for (GameCommand c : GameCommand.values()) {
            System.out.println(c + ": " + c.getDescription());
        }
    }

    private void createField(FieldData data) {
        int sizeOfSide = data.getSizeOfSides();
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

        setRandomRoomTypeLocations(RoomType.PIT, data.getNrOfPits());
        setRandomRoomTypeLocations(RoomType.MAELSTROM, data.getNrOfMaelstroms());
        setRandomRoomTypeLocations(RoomType.AMAROK, data.getNrOfAmaroks());
    }

    private void showCurrentPosition() {
        for (int i = field.length - 1; i >= 0; i--) {
            for (int j = 0; j < field[i].length; j++) {
                Coordinate current = new Coordinate(i, j);
                System.out.print(current.equals(currentLocation) ? LOCATION_TEXT.apply("[x]") : "[ ]");
            }
            System.out.println();
        }
    }

    private void setRandomRoomTypeLocations(RoomType roomtype, int numberOfRooms) {
        for (int i = 0; i < numberOfRooms; i++) {
            Coordinate temp;
            do {
                temp = getRandomLocation();
            } while (field[temp.row()][temp.column()] != RoomType.EMPTY);
            field[temp.row()][temp.column()] = roomtype;
        }
    }

    private Coordinate getRandomLocation() {
        int safety = 2;
        Random random = new Random();
        int randomRow;
        int randomColumn;
        if (random.nextBoolean()) {
            randomRow = (int) (random.nextDouble() * (field.length - safety)) + safety;
            randomColumn = (int) (random.nextDouble() * (field.length));
        } else {
            randomRow = (int) (random.nextDouble() * (field.length));
            randomColumn = (int) (random.nextDouble() * (field.length - safety)) + safety;
        }
        return new Coordinate(randomRow, randomColumn);
    }

    private boolean hasPlayerLost() {
        RoomType current = getRoomTypeOfRoom(currentLocation);
        if (current.equals(RoomType.AMAROK) || current.equals(RoomType.MAELSTROM)) {
            System.out.println("Game Over");
            return true;
        }
        return false;
    }

    private void checkCurrentRoom() {
        RoomType thisRoom = getRoomTypeOfRoom(currentLocation);
        switch (thisRoom) {
            case ENTRANCE -> {
                if (fountainActivated) {
                    System.out.println("You made it out of the cave and reactivated the " + FOUNTAIN_TEXT.apply("fountain"));
                } else {
                    System.out.println(LIGHT_TEXT.apply("You see light coming from the cavern entrance."));
                }
            }
            case FOUNTAIN -> {
                if (fountainActivated) {
                    System.out.println(DESCRIPE.apply("You hear the rushing waters from the ")
                            + FOUNTAIN_TEXT.apply("Fountain of Objects") + DESCRIPE.apply(". It has been reactivated!"));
                } else {
                    System.out.println(DESCRIPE.apply("You hear water dripping in this room. ")
                            + FOUNTAIN_TEXT.apply("The Fountain of Objects") + DESCRIPE.apply(" is here!"));
                }
            }
            case PIT -> System.out.println("You fell into a pit.");
            case AMAROK -> System.out.println("An Amarok got you!");
            case MAELSTROM -> {
                System.out.println(NARRATE.apply("A maelstrom blew you away"));
                maelstromMoves();
                blownAwayByMaelstrom();
                checkCurrentRoom();
            }
            case EMPTY -> {
            }
        }
    }

    private void checkSurroundingRooms() {
        if (checkNeighberhoodForRoomType(RoomType.PIT)) {
            System.out.println(NARRATE.apply("You feel a draft. There is a pit in a nearby room."));
        }
        if (checkNeighberhoodForRoomType(RoomType.MAELSTROM)) {
            System.out.println(NARRATE.apply("You hear the growling and groaning of a maelstrom nearby."));
        }
        if (checkNeighberhoodForRoomType(RoomType.AMAROK)) {
            System.out.println(NARRATE.apply("You can smell the rotten stench of an amarok in a nearby room."));
        }
    }

    private void blownAwayByMaelstrom() {
        int row = currentLocation.row();
        int column = currentLocation.column();
        row++;
        column += 2;
        if (row >= field.length) row -= field.length;
        if (column >= field.length) column -= field.length;
        moveTo(new Coordinate(row, column));
    }

    private void maelstromMoves() {
        int row = currentLocation.row();
        int column = currentLocation.column();
        field[row][column] = RoomType.EMPTY;
        do {
            row -= 2;
            column--;
            if (row < 0) row += field.length;
            if (column < 0) column += field.length;
        } while (!(field[row][column] == RoomType.EMPTY));
        field[row][column] = RoomType.MAELSTROM;
    }

    private boolean checkNeighberhoodForRoomType(RoomType roomtype) {
        int row = currentLocation.row();
        int column = currentLocation.column();
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

    protected void moveTo(Coordinate newLocation) {
        int newRowLocation = newLocation.row();
        int newColumnLocation = newLocation.column();
        if ((0 <= newRowLocation && newRowLocation < field.length) && (0 <= newColumnLocation && newColumnLocation < field.length)) {
            currentLocation = new Coordinate(newRowLocation, newColumnLocation);
        }
    }

    protected void enableFountain() {
        if (currentLocation.equals(fountainLocation)) fountainActivated = true;
        else System.out.println("You are not in the correct room");
    }

    protected void shoot(Coordinate room) {
        if (0 > Math.min(room.row(), room.column()) || Math.max(room.row(), room.column()) > field.length) {
            System.out.println(NARRATE.apply("You shot against a wall!"));
            System.out.println(NARRATE.apply("Luckily you managed to catch the arrow in the rebound."));
            return;
        }
        if (numberOfArrows > 0) {
            if (getRoomTypeOfRoom(room) == RoomType.AMAROK) {
                System.out.println(NARRATE.apply("You shot an Amarok!"));
                field[room.row()][room.column()] = RoomType.EMPTY;
            } else if (getRoomTypeOfRoom(room) == RoomType.MAELSTROM) {
                System.out.println(NARRATE.apply("You shot a Maelstrom!"));
                field[room.row()][room.column()] = RoomType.EMPTY;
            } else {
                System.out.println(NARRATE.apply("Your shot missed."));
            }
            numberOfArrows--;
        } else {
            System.out.println(NARRATE.apply("Sadly, you're out of arrows."));
        }
    }

    private RoomType getRoomTypeOfRoom(Coordinate room) {
        return field[room.row()][room.column()];
    }

    protected Coordinate getCurrentLocation() {
        return currentLocation;
    }
}

