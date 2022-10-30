public class RobotSystem {
	
	private Robot robot1;
	private Robot robot2;
	private String distfinal;
	
	public RobotSystem(int x1, int x2, int y1, int y2) {
		robot1 = new Robot(x1, y1);
		robot2 = new Robot(x2, y2);
	}
	
	
	public void moveRobot(int roboz, int distance) {
		if (roboz == 1) {
			robot1.move(distance);
		} else {
			robot2.move(distance);	
		}
	}
	
	
	public void robotDirection(int roboz, String direction) {
		if (roboz == 1) {
			robot1.changeDirection(direction);
		} else {
			robot2.changeDirection(direction);
		}
	} 	
	
	
	public void markIP(int roboz) {
		if (roboz == 1) {
			robot1.markIP();
		} else {
			robot2.markIP();
		}
	}
	
	
	public int xLocation(int roboz) {
		if (roboz == 1) {
			return (robot1.getX());
		} else {
			return (robot2.getX());
		}
	}
	
	
	public int yLocation(int robotNumber) {
		if (robotNumber == 1) {
			return (robot1.getY());
		} else {
			return (robot2.getY());
		}
	}
	
	
	public int moveRobot(int roboz) {
		if (roboz == 1) {
			return robot1.getdistPercorrida();
		} else {
			return robot2.getdistPercorrida();
		}
	}
	
	
	public int robotWalkPoint(int roboz) {
		if (roboz == 1) {
			return robot1.distanceIP();
		} else {
			return robot2.distanceIP();
		}
	}
	
	
	public String LargestMove(int roboz) {
		if (robot1.getLargestMove() > robot2.getLargestMove()) {
			distfinal = "ROBOT 1";
		} else if (robot1.getLargestMove() < robot2.getLargestMove()) {
			distfinal = "ROBOT 2";
		} else if (robot1.getLargestMove() == robot2.getLargestMove()) {
			distfinal = "EMPATE";
		}
		return distfinal;
		
	}
	 
	/*	public int robotComparation(int robotNumber) {
			robot1.getXPos();
			robot2.getXPos();
			robot1.getYPos();
			robot2.getYPos();
			return (Math.abs(robot1.getXPos() - robot.getXPos()) + Math.abs(robot1.getYPos() - robot2.getYPos()));
		}*/
	
}