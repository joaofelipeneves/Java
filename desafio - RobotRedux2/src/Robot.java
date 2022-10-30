public class Robot {
	public static final String NORTH = "N";
	public static final String SOUTH = "S";
	public static final String LESTE = "E";
	public static final String OESTE = "O";
	
	private String direção = NORTH;
	private int cordenadaX, cordenadaY;
	private int IPcordenadaX, IPcordenadaY;
	private int distPercorrida = 0;
	private int LargestMove = 0;
	
	public Robot(int cordenadaX, int cordenadaY) {
		this.cordenadaX = cordenadaX; this.cordenadaY = cordenadaY;
		this.IPcordenadaX = cordenadaX; this.IPcordenadaY= cordenadaY;
	}

	public int getX() {
		return cordenadaX;
	}

	public int getY() {
		return cordenadaY;
	}
	public int getLargestMove() {
		return LargestMove;
	}
	
	public void move(int distance) {
		switch(direção) {
		case NORTH: cordenadaY = (cordenadaY + distance);
			break;
		case SOUTH: cordenadaY = (cordenadaY - distance);
			break;
		case LESTE: cordenadaX = (cordenadaX + distance);
			break;
		case OESTE: cordenadaX = (cordenadaX - distance);
			break;
		}
		distPercorrida = distPercorrida + Math.abs(distance);
		if(LargestMove < distance) {LargestMove = distance;}
		else if(LargestMove > distance) {LargestMove = distance;}
	} 
	
	public void changeDirection(String direção) {this.direção = direção;}
	
	public void markIP() {cordenadaX = IPcordenadaX; cordenadaY = IPcordenadaY;}
	
	public String currentLocation() {return cordenadaX + " " + cordenadaY;}
	
	public int getdistPercorrida() {return distPercorrida;}
	
	public int distanceIP() {return Math.abs(cordenadaX - IPcordenadaX) + Math.abs(cordenadaY - IPcordenadaY);}
	
	public int distanceBetween(Robot other) {
		return Math.abs(cordenadaX - other.getX()) + Math.abs(cordenadaY - other.getY());
	}}