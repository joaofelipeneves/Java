public class IteratorLAA {
	
	private Album[] albums;
	private int nmbrAlbums, Index;
	private String author;
	
	public IteratorLAA(Album[] albums, int nmbrAlbums, String author) {
		this.albums = albums;
		this.nmbrAlbums = nmbrAlbums;
		this.Index = 0;
		this.author = author ;		
	}
	
	public boolean hasNext() {
		return Index < nmbrAlbums;
	}
	
	public Album next() {
		advance();
		return albums[Index++];
	}
	
	private void advance() {
		while (hasNext() && !isFromArtist(albums[Index])) {
			Index++;
		}
	}
	
	private boolean isFromArtist(Album pos) {
		return author.equals(pos.getAuthor());
		}
}