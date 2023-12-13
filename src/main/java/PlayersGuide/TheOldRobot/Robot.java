package PlayersGuide.TheOldRobot;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private int x;

    private int y;

    private boolean isPowered = false;

    //private final RobotCommand[] commands = new RobotCommand[3];
    private final List<RobotCommand> commands = new ArrayList<>();

    public void run() {
        for (RobotCommand command : commands) {
            command.run(this);
            System.out.printf("[%d %d %b]\n", x, y, isPowered);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPowered() {
        return isPowered;
    }

    public void setPowered(boolean powered) {
        isPowered = powered;
    }

    public int getNumberOfCommands() {
        return commands.size();
    }

    public void addCommand(RobotCommand command) {
        commands.add(command);
    }
}