package PlayersGuide.TheFountainOfObjects;


public abstract class GameCommand {
    public abstract void run(FountainOfObjectsGame game);
    static GameCommand getCommand(Command command){
        return switch(command){
            case MOVE_NORTH -> new NorthCommand();
            case MOVE_SOUTH -> new SouthCommand();
            case MOVE_EAST  -> new EastCommand();
            case MOVE_WEST  -> new WestCommand();
            case ENABLE_FOUNTAIN -> new EnableFountainCommand();
        };
    }
}
class NorthCommand extends GameCommand{
    public void run(FountainOfObjectsGame game){
        game.moveOnRow(1);
    }
}
class SouthCommand extends GameCommand{
    public void run(FountainOfObjectsGame game){
        game.moveOnRow(-1);
    }
}
class EastCommand extends GameCommand{
    public void run(FountainOfObjectsGame game){
        game.moveOnColumn(1);
    }
}
class WestCommand extends GameCommand{
    public void run(FountainOfObjectsGame game){
        game.moveOnColumn(-1);
    }
}
class EnableFountainCommand extends GameCommand{
    public void run(FountainOfObjectsGame game){
        game.enableFountain();
    }
}