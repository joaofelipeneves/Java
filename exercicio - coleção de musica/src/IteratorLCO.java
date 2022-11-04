public class IteratorLCO {

	private Album[] album2;
	private int nmbrAlbuns, Index;

	public IteratorLCO(Album[] album, Album[] album2, int numAlbuns) {
		//this.album = album;
		this.nmbrAlbuns = numAlbuns;
		this.Index = 0;
		this.album2 = album;
		newArr();
		setorder();
	}

	public boolean hasNext() {
		return Index < nmbrAlbuns;
	}

	public Album next() {
		return album2[Index++];
	}

	private void newArr() {
		Album[] tmp = new Album[nmbrAlbuns];
		for (int i = 0; i < nmbrAlbuns; i++) {
			tmp[i] = album2[i];
		}
		album2 = tmp;
	}

	private void setorder() {
		Album tmp;
		for (int i = 0; i < nmbrAlbuns; i++) {			
			for (int j = i + 1; j < nmbrAlbuns; j++) {
				
				if (album2[i].getReleaseDate() > album2[j].getReleaseDate()) {
					tmp = album2[i];
					album2[i] = album2[j];
					album2[j] = tmp;
				} 
				
				else if (album2[i].getReleaseDate() == album2[j].getReleaseDate()
						&& album2[i].getAuthor().compareTo(album2[j].getAuthor()) > 0) {
					tmp = album2[i];
					album2[i] = album2[j];
					album2[j] = tmp;

				}
			}
		}
	}
}