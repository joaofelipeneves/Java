public class AlbumSystem {

	private static final int DEFAULT_SIZE = 10;
	private static final int CHANGE_SIZE = 2;

	private Album[] albums, album2;
	private int nmbrAlbums;

	public AlbumSystem() {
		this.albums = new Album[DEFAULT_SIZE];
		this.nmbrAlbums = 0;
	}

	public int getNmbrAlbums() {
		return nmbrAlbums;
	}

	public void registerAlbum(Album album) {
		if (isFull()) {
			growFactor();
		}
		albums[nmbrAlbums++] = album;
	}

	private boolean isFull() {
		return nmbrAlbums == albums.length;
	}

	private void growFactor() {
		Album[] sizeAlbum = new Album[CHANGE_SIZE * albums.length];
		for (int i = 0; i != nmbrAlbums; i++) {
			sizeAlbum[i] = albums[i];
		}
		albums = sizeAlbum;
	}

	public boolean albumChecker(String artist, String title) {
		for (int i = 0; i != nmbrAlbums; i++) {
			if (albums[i].getAuthor().equals(artist) && albums[i].getSong().equals(title))
				return true;
		}
		return false;
	}

	public IteratorLC iteratorLC() {
		return new IteratorLC(albums, nmbrAlbums);
	}

	public IteratorLAA IteratorLAA(String artist) {
		return new IteratorLAA(albums, nmbrAlbums, artist);
	}
	
	
	public void definirorder() {
		album2 = new Album[albums.length];
		for (int i = 0; i < nmbrAlbums; i++) {
			album2[i] = albums[i];
		} 
	}
	
	
	public IteratorLCO IteratorLCO() {
		return new IteratorLCO(albums, album2, nmbrAlbums);
	}
}
