package PlayersGuide.TheFountainOfObjects;

import java.util.Random;
import java.util.Scanner;
import PlayersGuide.AnsiColors.AnsiColors;

enum Command{
    MOVE_NORTH,
    MOVE_SOUTH,
    MOVE_EAST,
    MOVE_WEST,
    ENABLE_FOUNTAIN
}
enum RoomType{
    EMPTY,
    ENTRANCE,
    FOUNTAIN,
    PIT
}
public class FountainOfObjectsGame {
    //private final String[] COMMANDS = {"move north", "move south", "move east", "move west", "enable fountain"};
    private RoomType[][] field;
    private boolean fountainActivated = false;
    boolean playerWins = false, playerLoses = false;
    private Coordinate currentLocation;

    private final Coordinate ENTRANCE_LOCATION = new Coordinate(0, 0);
    private Coordinate fountainLocation;// = new Coordinate(0, 2);
    private final String NARRATIVE = AnsiColors.ANSI_PURPLE;
    private final String DESCRIPTION = AnsiColors.ANSI_WHITE;
    private final String INPUT = AnsiColors.ANSI_CYAN;
    private final String LIGHT = AnsiColors.ANSI_YELLOW;
    private final String FOUNTAIN = AnsiColors.ANSI_BLUE;
    private final String RESET = AnsiColors.ANSI_RESET;

    private final Scanner input = new Scanner(System.in);

    public FountainOfObjectsGame(){

    }
    public void run(){
        System.out.println(NARRATIVE + "You are at the entrance of the cave with the " +
                           FOUNTAIN + "Fountain of Objects");
        System.out.println(NARRATIVE + "If you can find and activate the " + FOUNTAIN + "Fountain" +
                           NARRATIVE + ", you will save the island!");
        System.out.println("But there is a darkness in the cave impenetrable by any light!");
        System.out.println("Get to the " + FOUNTAIN + "Fountain of Objects" + NARRATIVE + "\n, activate it");
        System.out.println("and escape the cave to win!" + RESET);
        System.out.println("Please choose: ");
        System.out.println("""
                1. Small  (4 x 4)
                2. Medium (6 x 6)
                3. Large  (8 x 8)""");
        while(true) {
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice){
                case 1 -> createField(4);
                case 2 -> createField(6);
                case 3 -> createField(8);
                default -> {
                    continue;
                }
            }
            System.out.println("Your choice was: " + field.length + " x " + field.length);
            System.out.println("Fountain location: " + fountainLocation);
            break;
        }
        currentLocation = new Coordinate(0, 0);
        while(playerWins == playerLoses){
            System.out.println(DESCRIPTION + "You are in the room at " + currentLocation + "." + RESET);
            System.out.print("What do you want to do? ");
            System.out.print(INPUT);
            String command = input.nextLine().toUpperCase();
            System.out.print(RESET);
            command = command.replace(" ", "_");
            if(!command.isEmpty()) executeCommand(command);
            //System.out.println(DESCRIPTION + "You are in the room at " + currentLocation + "." + RESET);
            checkRoom(currentLocation);
            //if(!(playerWins || playerLoses))System.out.print("What do you want to do? ");
        }

    }

    //create the game's field with different room types
    private void createField(int sizeOfSide){
        field = new RoomType[sizeOfSide][sizeOfSide];
        fountainLocation = getRandomLocation(sizeOfSide);
        int numberOfPits = switch(sizeOfSide){
            case 4 -> 1;
            case 6 -> 2;
            case 8 -> 4;
            default-> 0;
        };

        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[i].length; j++){
                Coordinate current = new Coordinate(i, j);
                if(current.equals(fountainLocation)){
                    field[i][j] = RoomType.FOUNTAIN;
                }
                else if(current.equals(ENTRANCE_LOCATION)){
                    field[i][j] = RoomType.ENTRANCE;
                }
                else{
                    field[i][j] = RoomType.EMPTY;
                }
            }
        }
        for(int i = 0; i < numberOfPits; i++){
            while(true) {
                Coordinate temp = getRandomLocation(sizeOfSide);
                if(field[temp.row()][temp.column()] == RoomType.EMPTY){
                    field[temp.row()][temp.column()] = RoomType.PIT;
                    break;
                }
            }
        }
    }

    private Coordinate getRandomLocation(int sizeOfSideOfField){
        Random random = new Random();
        boolean randomizer = random.nextBoolean();
        int randomRow;
        int randomColumn;
        if(randomizer) {
            randomRow = (int) (Math.random() * (sizeOfSideOfField - 2)) + 2;
            randomColumn = (int) (Math.random() * (sizeOfSideOfField));
        }
        else{
            randomRow = (int) (Math.random() * (sizeOfSideOfField));
            randomColumn = (int) (Math.random() * (sizeOfSideOfField - 2)) + 2;
        }
        return new Coordinate(randomRow, randomColumn);
    }
    //check if the room has something extra
    private void checkRoom(Coordinate currentPosition){
        int row = currentPosition.row();
        int column = currentPosition.column();
        RoomType thisRoom = field[row][column];
        switch(thisRoom){
            case ENTRANCE -> {
                if(fountainActivated){
                    System.out.println("You made it out of the cave and reactivated the " + FOUNTAIN + "fountain" + RESET);
                    System.out.println("You win!");
                    playerWins = true;
                    return;
                }
                else{
                    System.out.println(LIGHT + "You see light coming from the cavern entrance." + RESET);
                }
            }
            case FOUNTAIN -> {
                if(fountainActivated){
                    System.out.println(DESCRIPTION + "You hear the rushing waters from the "
                            + FOUNTAIN + "Fountain of Objects" + DESCRIPTION + ". It has been reactivated!" + RESET);
                }
                else{
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
            case EMPTY -> {}
        }
        boolean pitInNeighberhood = false;
        for(int i = row-1; i <= row+1; i++){
            if(0 > i || i > field.length-1)continue;
            for(int j = column-1; j <= column+1; j++){
                if(0 > j || j > field[i].length-1)continue;
                if (field[i][j] == RoomType.PIT) {
                    pitInNeighberhood = true;
                    break;
                }
            }
        }
        if(pitInNeighberhood){
            System.out.println(DESCRIPTION + "You feel a draft. There is a pit in a nearby room." + RESET);
        }
        //not much different types at the moment, but plan on rebuilding with switch for roomTypes
    /*    if(currentPosition.equals(ENTRANCE_LOCATION)){
            if(!fountainActivated){
                System.out.println(LIGHT + "You see light coming from the cavern entrance." + RESET);
            }
            else{
                System.out.println("You made it out of the cave and reactivated the " + FOUNTAIN + "fountain" + RESET);
                System.out.println("You win!");
                playerWins = true;
            }
        }
        if(currentPosition.equals(fountainLocation)){
            if(fountainActivated){
                System.out.println(DESCRIPTION + "You hear the rushing waters from the "
                        + FOUNTAIN + "Fountain of Objects" + DESCRIPTION + ". It has been reactivated!" + RESET);
            }
            else{
                System.out.println(DESCRIPTION + "You hear water dripping in this room. "
                        + FOUNTAIN + "The Fountain of Objects" + DESCRIPTION + " is here!" + RESET);
            }
        }*/
    }
    //checks if the entered command is legal and executes this if it is
    private void executeCommand(String command){
        Command commando;
        try {
            commando = Command.valueOf(command);
        }catch(IllegalArgumentException e){
            System.out.println("This is not a legal command!");
            return;
        }
        GameCommand nextCommand = GameCommand.getCommand(commando);
        nextCommand.run(this);
    }
    void moveOnRow(int step){
        int newRowLocation = currentLocation.row()+step;
        if(0 <= newRowLocation && newRowLocation < field.length){
            currentLocation = new Coordinate(newRowLocation, currentLocation.column());
        }
    }
    void moveOnColumn(int step){
        int newColumnLocation = currentLocation.column()+step;
        if(0 <= newColumnLocation && newColumnLocation < field.length){
            currentLocation = new Coordinate(currentLocation.row(), newColumnLocation);
        }
    }
    void enableFountain(){
        if(currentLocation.equals(fountainLocation))fountainActivated = true;
        else System.out.println("You are not in the correct room");
    }
}

record Coordinate(int row, int column){}