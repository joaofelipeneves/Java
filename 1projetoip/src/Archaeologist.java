/////  @author Joao Felipe Ribeiro Neves ----- LEI ;
// in this class the user will be the middle term, it will receive data from ArqSystem and treat them to be received at the Main
public class Archaeologist {

	
	// create private data that will only be used at this class 
	private String archeologistName;
	private int merit;
	private int position;
	private boolean license;

	// create a public archeologist that will be the default to the others classes 
	public Archaeologist(String name) {
		archeologistName = name;
		license = true; 
		position = -1;
		merit = 0; 
		;  //set position to -1 due the array starts at 0
	}

	public String getName() {
		return archeologistName;

	}
	public int getMerit() {
		return merit;
	}
	
	public void digMerit(int addSiteValue) {
		merit += addSiteValue;   //merit will be the value of merit (that starts ate 0 + the values inside the Site)
	}
public int getPos() {
		return position;

	}

	public boolean hasLicense() {
		return license;
	}

	public void newLicense() {

		license = false;

	}
		public void actualPosition(int move) {
		position += move;  			// actualposition will be the position + the move that the user will define 
									//, so , if he walks 5 spaces he can return from 3 to 0 (he´s already on the fourth element of the array;)
	}
}
	

