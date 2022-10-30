import java.util.Scanner;

public class Main {
	public static final String MOVE = "MV", CHANGEDIRECTION = "MD", INTERESTPOINT = "PI", ACTUALLOCATION = "LP", TRAVELEDDISTANCE = "LDT", IPDISTANCE= "LDPI", MAXDISTANCE = "DTMAX",
			DISTANCEROBOTS = "DR", LARGESTMOVE = "LMV";

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int cordenadax = input.nextInt(); int cordenaday = input.nextInt();
		input.nextLine();
		
		Robot robot1 = new Robot(cordenadax, cordenaday);
		cordenadax = input.nextInt();
		cordenaday = input.nextInt();
		Robot robot2 = new Robot(cordenadax, cordenaday);
		input.nextLine();
			
		for(int i = 0; i < 5; i++) {
			String choose = input.next();
			Robot robot = null;

			if(false == choose.matches(DISTANCEROBOTS + "||" + MAXDISTANCE + "||" + LARGESTMOVE))
			{int roboz = input.nextInt(); robot = roboz == 1 ? robot1 : robot2;}
			
			switch(choose) {
			case MOVE: robot.move(input.nextInt());
				break;
			case CHANGEDIRECTION: robot.changeDirection(input.next());
				break;
			case INTERESTPOINT: robot.markIP();
				break;
			case ACTUALLOCATION: System.out.println(robot.currentLocation());
				break;
			case TRAVELEDDISTANCE: System.out.println(robot.getdistPercorrida());
				break;
			case IPDISTANCE: System.out.println(robot.distanceIP());
				break;
			case MAXDISTANCE:
				if(robot1.getdistPercorrida() == robot2.getdistPercorrida()) {
					System.out.println("EMPATE");
				}
				else if(robot1.getdistPercorrida() > robot2.getdistPercorrida()) {
					System.out.println("ROBOT 1");
				}
				else if(robot1.getdistPercorrida() < robot2.getdistPercorrida()) {
					System.out.println("ROBOT 2");
				}
				break;
			case DISTANCEROBOTS: System.out.println(robot1.distanceBetween(robot2));
			break;
			case LARGESTMOVE:
				if(robot1.getLargestMove() == robot2.getLargestMove()) {
					System.out.println("EMPATE");
				}
				else if(robot1.getLargestMove() > robot2.getLargestMove()) {
					System.out.println("ROBOT 1");
				}
				else if(robot1.getLargestMove() < robot2.getLargestMove()) {
					System.out.println("ROBOT 2");
				}
				break;
			case  "S" :
				break;
			default :
				input.nextLine();
				robotStop();
				break;
			}
		}
		private static void robotStop() {
			System.out.println("Comando invalido.");
		}
	}}