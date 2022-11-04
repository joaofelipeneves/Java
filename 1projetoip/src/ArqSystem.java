// @author Joao Felipe Ribeiro Neves ----- LEI ;
// this class will be mainly used for calculate and change things that are happening at the Main.java
public class ArqSystem {

	int[] sites;
	int[] diggedsites;
	Archaeologist archeologist1;
	Archaeologist archeologist2;

	// will set the default data, and then , it can be used on other files
	public ArqSystem(String name1, String name2, int[] sites) {
		this.sites = sites;
		this.diggedsites = new int[sites.length];

		archeologist1 = new Archaeologist(name1);
		archeologist2 = new Archaeologist(name2);
	}

// this method will change the status of the site as the value keep going away
	public String SiteState() {

		String SiteState = "";
		for (int i = 0; i < sites.length; i++) {

			if (sites[i] > 0) {
				SiteState += "*";
			} else {
				SiteState += "-";
			}

		}
		return SiteState; // terrainForm is the way that the teasure will be showned up on the screen
							// "---**"
	}

// this method will return invalid if the name that the user inputted at the beginning is different that the one that the user is calling  

	// this method will return the merit of each archeologist;
	public int Merit(String name) {

		if (name.equals(archeologist1.getName())) {
			return archeologist1.getMerit();
		} else {
			return archeologist2.getMerit();
		}

	}

	// this method changes the license if max of failures is overcomed
	public void modifyLicense(String name) {
		if (name.equals(archeologist1.getName())) {
			archeologist1.newLicense();
			archeologist2.newLicense();
		}
	}

	public boolean isInvalid(String name) {
		if (!name.equals(archeologist1.getName()) || !name.equals(archeologist2.getName())) {
			return true;
		} else {
			return false;
		}
	}

	// this method will return the value of the fortune
	public int Fortune() {

		int riqueza = 0;

		for (int i = 0; i < sites.length; i++) {
			riqueza += sites[i];

		}

		return riqueza;

	}

	// this method returns true if the archeologist still has his license to dig the
	// site , false if not
	public boolean hasLicense(String name) {
		if (name.equals(archeologist1.getName())) {
			return archeologist1.hasLicense();
		} else {
			return archeologist2.hasLicense();
		}
	}
	// this method will atribute all the data to the archeologist, starting at
	// receveing their locations

	public void dig(int move, String name) {
		int addSiteValue;
		int position;

		if (name.equals(archeologist1.getName())) {
			position = archeologist1.getPos();
		} else
			position = archeologist2.getPos();

//will set all the positions related to the site and all the excavation that goes in,
// receives how many sites were digged , how much will be taken if someone o again in an already excavated site		
		if (diggedsites[position + move] == 0) {
			addSiteValue = sites[position + move];
			diggedsites[position + move]++;

		} else
			addSiteValue = (-10) * (diggedsites[position + move] - 1);
		diggedsites[position + move]++;

//will set the values to the archeologist, will receive : Merit, Name, move (to go between the 
// the sites and will refresh its location)
		{
			if (name.equals(archeologist1.getName())) {
				archeologist1.digMerit(addSiteValue);
				archeologist1.actualPosition(move);
				dig(archeologist1.getPos());
				Fortune();
			} else {
				archeologist2.digMerit(addSiteValue);
				archeologist2.actualPosition(move);
				dig(archeologist2.getPos());
				Fortune();
			}

		}

	}

	// this method returns true if if the archeologist is still inside the
	// excavation site
	public boolean isInside(String name, int move) {
		int position;
		if (name.equals(archeologist1.getName())) {
			position = archeologist1.getPos();
		} else
			position = archeologist2.getPos();

		if (position + move >= 0 && position + move < sites.length) {
			return true;
		} else {
			return false;
		}
	}

// this method digs the choosen site 
	public void dig(int i) {
		sites[i] = 0;
	}

// this boolean return true if both still has theirs licenses 
	public boolean bothLost() {
		if (!(archeologist1.hasLicense() && archeologist2.hasLicense())) {
			return true;
		} else {
			return false;
		}
	}

}
