package PlayersGuide.TheFountainOfObjects;


public abstract class GameCommand {
    public abstract void run(FountainOfObjectsGame game);

    static GameCommand getCommand(Command command) {
        return switch (command) {
            case MOVE_NORTH -> new NorthCommand();
            case MOVE_SOUTH -> new SouthCommand();
            case MOVE_EAST -> new EastCommand();
            case MOVE_WEST -> new WestCommand();
            case ENABLE_FOUNTAIN -> new EnableFountainCommand();
            case SHOOT_NORTH -> new ShootNorthCommand();
            case SHOOT_SOUTH -> new ShootSouthCommand();
            case SHOOT_EAST -> new ShootEastCommand();
            case SHOOT_WEST -> new ShootWestCommand();
            case HELP -> new HelpCommand();
        };
    }
}

class NorthCommand extends GameCommand {
    public void run(FountainOfObjectsGame game) {
        game.moveOnRow(1);
    }
}

class SouthCommand extends GameCommand {
    public void run(FountainOfObjectsGame game) {
        game.moveOnRow(-1);
    }
}

class EastCommand extends GameCommand {
    public void run(FountainOfObjectsGame game) {
        game.moveOnColumn(1);
    }
}

class WestCommand extends GameCommand {
    public void run(FountainOfObjectsGame game) {
        game.moveOnColumn(-1);
    }
}

class EnableFountainCommand extends GameCommand {
    public void run(FountainOfObjectsGame game) {
        game.enableFountain();
    }
}

class ShootNorthCommand extends GameCommand {
    public void run(FountainOfObjectsGame game) {
        Coordinate current = game.getCurrentLocation();
        game.shoot(new Coordinate(current.row() + 1, current.column()));
    }
}

class ShootSouthCommand extends GameCommand {
    public void run(FountainOfObjectsGame game) {
        Coordinate current = game.getCurrentLocation();
        game.shoot(new Coordinate(current.row() - 1, current.column()));
    }
}

class ShootEastCommand extends GameCommand {
    public void run(FountainOfObjectsGame game) {
        Coordinate current = game.getCurrentLocation();
        game.shoot(new Coordinate(current.row(), current.column() + 1));
    }
}

class ShootWestCommand extends GameCommand {
    public void run(FountainOfObjectsGame game) {
        Coordinate current = game.getCurrentLocation();
        game.shoot(new Coordinate(current.row(), current.column() - 1));
    }
}

class HelpCommand extends GameCommand {
    public void run(FountainOfObjectsGame game) {
        game.showHelp();
    }
}
/*
When the game starts, display text that describes the game shown below:
You enter the Cavern of Objects, a maze of rooms filled with dangerous pits in search
of the Fountain of Objects.
Light is visible only in the entrance, and no other light is seen anywhere in the caverns.
You must navigate the Caverns with your other senses.
Find the Fountain of Objects, activate it, and return to the entrance.
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
When the player types the command help, display all available commands and a short description
of what each does. The complete list of commands will depend on what challenges you complete.
 */