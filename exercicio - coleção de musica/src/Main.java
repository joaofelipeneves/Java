import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		AlbumSystem as = new AlbumSystem();
		String choose;
		do {
			choose = in.nextLine();
			switch (choose) {
			case "SAIR":
				Quit(as, in);
				break;
			case "RA":
				RegisterAlbum(as, in);
				break;
			case "CA":
				CheckAlbum(as, in);
				break;
			case "LC":
				ListOrderPurchase(as);
				break;
			case "LAA":
				ListBuyOrderAndAuthorName(as, in);
				break;
			case "LCO":
				ListChronologicalOrder(as);
				break;
			}
		} while (!choose.equals("SAIR"));
	}

	private static void Quit(AlbumSystem as, Scanner in) {
		System.out.println("A colecao tem " + as.getNmbrAlbums() + " albuns");
		in.close();
	} 

	private static void RegisterAlbum(AlbumSystem as, Scanner in) {
		String author = in.nextLine().trim();
		String song = in.nextLine().trim();
		int releaseDate = in.nextInt();
		as.registerAlbum(new Album(author, song, releaseDate));
		System.out.println("Album inserido");
	}

	private static void CheckAlbum(AlbumSystem as, Scanner in) {
		String author = in.nextLine().trim();
		String song = in.nextLine().trim();
		if (as.albumChecker(author, song))
			System.out.println("Album existente");
		else
			System.out.println("Album inexistente");
	}
//ok
	private static void ListOrderPurchase(AlbumSystem as) {
		IteratorLC IteratorLC = as.iteratorLC();
		while (IteratorLC.hasNext()) {
			Album album = IteratorLC.next();
			if(album != null)
			System.out.println(album.getAuthor() + " ; " + album.getSong() + " ; " + album.getReleaseDate());
		}
	}
//OK
	private static void ListBuyOrderAndAuthorName(AlbumSystem as, Scanner in) {
		String artist = in.nextLine().trim();
		IteratorLAA IteratorLAA = as.IteratorLAA(artist);
		while (IteratorLAA.hasNext()) {
			Album album = IteratorLAA.next();
			if(album != null)
			System.out.println(album.getAuthor() + " ; " + album.getSong() + " ; " + album.getReleaseDate());
		}
	}
//OK
	public static void ListChronologicalOrder(AlbumSystem as) {
		as.definirorder();
		IteratorLCO IteratorLCO = as.IteratorLCO();
		while (IteratorLCO.hasNext()) {
			Album album = IteratorLCO.next();
			if(album != null)
			System.out.println(album.getAuthor() + " ; " + album.getSong() + " ; " + album.getReleaseDate());
		}
	}
}
