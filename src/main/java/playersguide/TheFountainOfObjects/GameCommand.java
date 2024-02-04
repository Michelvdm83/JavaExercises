package playersguide.TheFountainOfObjects;

public enum GameCommand {
    MOVE_NORTH("move 1 step north"),
    MOVE_SOUTH("move 1 step south"),
    MOVE_EAST("move 1 step east"),
    MOVE_WEST("move 1 step west"),
    ENABLE_FOUNTAIN("shoot an arrow into the room directly north of you"),
    SHOOT_NORTH("shoot an arrow into the room directly south of you"),
    SHOOT_SOUTH("shoot an arrow into the room directly east of you"),
    SHOOT_EAST("shoot an arrow into the room directly west of you"),
    SHOOT_WEST("activate the fountain if you're in the fountain room"),
    HELP("show list of commands with descriptions");

    GameCommand(String description) {
        DESCRIPTION = description;
    }

    //thinking about using this:
    //private final Consumer<FountainOfObjectsGame> executor;
    private final String DESCRIPTION;

    public void execute(FountainOfObjectsGame game) {
        Coordinate current = game.getCurrentLocation();
        switch (this) {
            case MOVE_NORTH -> game.moveTo(new Coordinate(current.row() + 1, current.column()));//game.moveRow(1);
            case MOVE_SOUTH -> game.moveTo(new Coordinate(current.row() - 1, current.column()));//game.moveRow(-1);
            case MOVE_EAST -> game.moveTo(new Coordinate(current.row(), current.column() + 1));//game.moveColumn(1);
            case MOVE_WEST -> game.moveTo(new Coordinate(current.row(), current.column() - 1));//game.moveColumn(-1);
            case ENABLE_FOUNTAIN -> game.enableFountain();
            case SHOOT_NORTH -> game.shoot(new Coordinate(current.row() + 1, current.column()));
            case SHOOT_SOUTH -> game.shoot(new Coordinate(current.row() - 1, current.column()));
            case SHOOT_EAST -> game.shoot(new Coordinate(current.row(), current.column() + 1));
            case SHOOT_WEST -> game.shoot(new Coordinate(current.row(), current.column() - 1));
            case HELP -> game.showHelp();
        }
    }

    public String getDescription() {
        return DESCRIPTION;
    }
}