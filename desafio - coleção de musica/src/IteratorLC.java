public class IteratorLC{
	
	private Album[] album;
	private int nmbrAlbums, Index;
	
	public IteratorLC(Album[] album, int nmbrAlbums) {
		this.album = album;
		this.nmbrAlbums = nmbrAlbums;
		this.Index = 0;
	}
	
	public boolean hasNext() {
		return Index < nmbrAlbums;
	}
	
	public Album next() {
		return album[Index++];
	}
}