/**
@author Joao Felipe Ribeiro Neves ----- LEI ;



the main method is where the execution of the code begins. 
it will receive all the basics informations to deliver and calculate what was asked in the beginning of this project 
**
It receives 2 names, the size of the excavation site, all the variables that goes into the array (excavation site),
will also receive 6(six) different types of commands that each one of them will execute something diferent, it will be more elaborated in the next comments;
*/



import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String name1 = input.nextLine();  //both names are defined by the user via input(due to java.util.scanner).
		String name2 = input.nextLine();

		int siteSize = input.nextInt(); // receives the value that storage the siteSize.

		int[] sites = new int[siteSize]; // save sites value until they reach the siteSize.

		

		for (int i = 0; i < siteSize; i++) {  
			sites[i] = input.nextInt();
		}

//create the a part of the system that will be used in a large part of this program, it will 
//set that the system has 3 types of data inside of it
		ArqSystem as = new ArqSystem(name1, name2, sites);
		processCommands(input, as);
	}

	
// a method that gives 6 possibilities to the user to choose what he wants to do at the time 
	private static void processCommands(Scanner input, ArqSystem as) {
		String choose = input.next();
		while (!choose.equals("sair")) {
			switch (choose) {
			case "riqueza":
				cmdFortune(input, as);
				break;
			case "terreno":
				cmdSite(input, as);
				break;
			case "merito":
				cmdMerit(input, as);
				break;
			case "escavacao":
				cmdDig(input, as);
				break;
			default:
				error(input);
				break;
			}
			choose = input.next();
		}
		exit(as);
	}

	
	// a method that if choosen will show the buried fortune at the moment
	
	private static void cmdFortune(Scanner input, ArqSystem as) {

		System.out.println("Riqueza enterrada: " + as.Fortune());
	}
	// method that returns the the status of the site at the moment 
	private static void cmdSite(Scanner input, ArqSystem as) {

		System.out.println(as.SiteState());

	}
    //method that get the name of the person via input and them calculate his merit based on the sites that he already escavated;
	private static void cmdMerit(Scanner input, ArqSystem as) {
		String name = input.nextLine().trim();

		 if (!(as.hasLicense(name))) {
			System.out.println("Arqueologo desclassificado"); // if arq(name choosen by the user) has lost license he will receive the message disqualified
		} else {
			System.out.println("Merito de " + name + ": " + as.Merit(name)); // returns the merit with the name that the user inputted;
		}

	}
	
	//method that makes the moves inside the array (Site) and gets the fortune burried in the site;
	//if the value the jump equals 0 
	private static void cmdDig(Scanner input, ArqSystem as) {
		int move = input.nextInt();
		String name = input.nextLine().trim();

		if (move == 0) {
			System.out.println("Salto invalido"); 			//jump cannot be equals to 0 because it is not recognized by the system
		} 
		else if (move != 0 && (as.isInvalid(name))) { 		// if jump is possible but the system cannot recognize the person it gives that message to the user
			System.out.println("Arqueologo inexistente");
		}
		else if (move != 0 && !(as.hasLicense(name))) { 		// if arq looses his license he will be automatically desqualified
			System.out.println("Arqueologo desclassificado");
		} else if (!(as.isInside(name, move))) {
			System.out.println(name + " perdeu a licenca de escavacao");
			as.modifyLicense(name);								// if jumps different from what is possible automatically looses his license 
		} else {
			as.dig(move, name);
		}
	}
	
	
	// method that returns invalid to every command different from those setted
	private static void error(Scanner input) {
		System.out.println("Comando invalido"); 
		input.nextLine();
		}
	
	
	// method that will say how the competition ended 
	private static void exit(ArqSystem as) {

		if (as.bothLost()){
			System.out.println("Correu mal! Foram ambos desclassificados.");
		}
		else if (as.SiteState().contains("*")) {
			System.out.println("Ainda havia tesouros por descobrir...");
		} else {
			System.out.println("Todos os tesouros foram descobertos!");
		}

	}

	
}
