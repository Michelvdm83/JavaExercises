package PlayersGuide.TheOldRobot;

public abstract class RobotCommand {
    public abstract void run(Robot robot);
}
class OnCommand extends RobotCommand{
    public void run(Robot robot){
        robot.setPowered(true);
        robot.setX(0);
        robot.setY(0);
    }
}
class OffCommand extends RobotCommand{
    public void run(Robot robot){
        robot.setPowered(false);
    }
}
class NorthCommand extends RobotCommand{
    public void run(Robot robot){
        if(robot.isPowered()){
            robot.setY(robot.getY()+1);
        }
    }
}
class SouthCommand extends RobotCommand{
    public void run(Robot robot){
        if(robot.isPowered()){
            robot.setY(robot.getY()-1);
        }
    }
}
class EastCommand extends RobotCommand{
    public void run(Robot robot){
        if(robot.isPowered()){
            robot.setX(robot.getX()+1);
        }
    }
}
class WestCommand extends RobotCommand{
    public void run(Robot robot){
        if(robot.isPowered()){
            robot.setX(robot.getX()-1);
        }
    }
}
/*
Make OnCommand and OffCommand classes that inherit from RobotCommand and turn the robot
on or off by overriding the run method.
Make a NorthCommand, SouthCommand, WestCommand, and EastCommand that move the robot 1
unit in the +y direction, 1 unit in the -y direction, 1 unit in the -x direction, and 1 unit in the +x
direction, respectively. Also, ensure that these commands only work if the robot’s isPowered is true.
 */