public class IteratorLAO {

	private Album[] album, album2;
	private int nmbrAlbums, Index;
	private String author;

	public IteratorLAO(Album[] album, int nmbrAlbuns, String author) {
	    this.album = album;
		this.album2 = album;
		this.Index = 0;
		this.author = author;
		newArr(album2);
		setorder();
		advance();		
		
	}

	public boolean hasNext() {
		return Index < nmbrAlbums;
	}

	public Album next() {
		return album2[Index++];
	}

	private void newArr(Album[] album2) {
		Album[] tmp = new Album[nmbrAlbums];
		for (int i = 0; i < nmbrAlbums; i++) {
			tmp[i] = album[i];
		}
		album2 = tmp;
	}
	
	private void advance() {
		while (hasNext() && !isFromArtist(album[Index])) {
			Index++;
		}
	}
	
	private boolean isFromArtist(Album pos) {
		return author.equals(pos.getAuthor());
		}	
	
	private void setorder() {
		Album tmp;

		for (int i = 0; i < nmbrAlbums; i++) {

			
			for (int j = i + 1; j < nmbrAlbums; j++) {

				if (album[i].getReleaseDate() > album[j].getReleaseDate()) {
					tmp = album[i];
					album[i] = album[j];
					album[j] = tmp;
				} else if (album[i].getReleaseDate() == album[j].getReleaseDate()
						&& album[i].getAuthor().compareTo(album[j].getAuthor()) > 0) {
					tmp = album[i];
					album[i] = album[j];
					album[j] = tmp;

				}
			}
		}
	}
}