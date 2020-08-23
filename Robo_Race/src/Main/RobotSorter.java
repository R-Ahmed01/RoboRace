package Main;
import java.util.Comparator;
import GridLocations.Robot;

public class RobotSorter implements Comparator<Robot>{
	@Override
    public int compare(Robot robot1, Robot robot2) {
        return Character.compare(robot1.robot, robot2.robot);
    }
}
