package playersguide.TheFountainOfObjects;


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