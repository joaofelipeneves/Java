public class Album{
	private String author, song;
	private int releaseDate;
	
	public Album (String author, String song, int releaseDate) {
		this.author = author;
		this.song = song;
		this.releaseDate = releaseDate;
		
	}
	
	public int getReleaseDate() {
		return releaseDate;
		
	}
	
	public String getSong() {
		return song;
	}
	
	public String getAuthor() {
		return author;
	}
}