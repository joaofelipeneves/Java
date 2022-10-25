import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main{
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(System.in);
		String fileName = in.nextLine();
		Scanner fileReader = new Scanner(new FileReader(fileName));
		
		int nGames = fileReader.nextInt();
		fileReader.nextLine();
		
		for(int i=0 ; i < nGames; i++) {
			int nLines = fileReader.nextInt();
			int nColumns = fileReader.nextInt();
			int n = fileReader.nextInt();
			fileReader.nextLine();
			
			char[][] board = new char[nLines][nColumns];
			
			for(int j = 0; j < nLines; j++) {
				String line = fileReader.nextLine();
				for(int k = 0; k < nColumns; k++) {
					board[j][k] = line.charAt(k);
				}
			}
			
			System.out.println(analizeGameBoard(board, i+1, n));
		}
		fileReader.close();
		in.close();
	}
	
	private static String analizeGameBoard(char[][] chars, int numGames, int n) {
		int jogador1 = 0;
		int jogador2 = 0;

		for (int j = 0; j < chars.length - 1; j++) {
			// chars[0]
			for (int k = 0; k < chars[j].length - 1; k++) {
				if(chars[j][k] == chars[j][k + 1]) {
					if (chars[j][k] == 'x') {
						jogador2++;
						
					}
					else if(chars[j][k] == 'o') {
						jogador1++;

					}
				}
				//j+1
				if (chars[j][k] == chars[j + 1][k]) {
					if(chars[j][k] == 'x') {
						jogador1++;

					}else if(chars[j][k] == 'o') {
						jogador2++;

					}
				}
			}
		}

		if (jogador1 == 0) {
			return "Jogo " + numGames + ": empata";
		} 
		
		else if (jogador2 > jogador1) {
			return "Jogo " + numGames + ": ganhou o jogador 1";
		} 
		else  { 
			return "Jogo " + numGames + ": ganhou o jogador 2";
	} 
		
}
}






















