package PlayersGuide.TheOldRobot;

public class Robot {
    private int x;

    private int y;

    private boolean isPowered = false;

    private final RobotCommand2[] commands = new RobotCommand2[3];

    public void run() {
        for (RobotCommand2 command : commands) {
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
    public int getNumberOfCommands(){
        return commands.length;
    }

    //if using the interface, the command should be replaced with a String
    //and the switch command from TheOldRobot.java should be here for 'visibility'
    //It runs like this, but intellij gives warning
    public void setCommands(RobotCommand2 command, int commandNumber){
        if(commandNumber < 1 || 3 < commandNumber){
            return;
        }
        commands[commandNumber-1] = command;
    }
}

//with an interface this would be:

interface RobotCommand2 {
    void run(Robot robot);
}
class OnCommand2 implements RobotCommand2{
    public void run(Robot robot){
        robot.setPowered(true);
        robot.setX(0);
        robot.setY(0);
    }
}
class OffCommand2 implements RobotCommand2{
    public void run(Robot robot){
        robot.setPowered(false);
    }
}
class NorthCommand2 implements RobotCommand2{
    public void run(Robot robot){
        if(robot.isPowered()){
            robot.setY(robot.getY()+1);
        }
    }
}
class SouthCommand2 implements RobotCommand2{
    public void run(Robot robot){
        if(robot.isPowered()){
            robot.setY(robot.getY()-1);
        }
    }
}
class EastCommand2 implements RobotCommand2{
    public void run(Robot robot){
        if(robot.isPowered()){
            robot.setX(robot.getX()+1);
        }
    }
}
class WestCommand2 implements RobotCommand2{
    public void run(Robot robot){
        if(robot.isPowered()){
            robot.setX(robot.getX()-1);
        }
    }
}