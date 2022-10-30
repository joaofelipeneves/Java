import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main{
	public static final String TIE = "Jogo %d: empate\n";
	public static final String P1_WINS = "Jogo %d: ganhou o jogador 1\n";
	public static final String P2_WINS = "Jogo %d: ganhou o jogador 2\n";
	
	public static final int TIE_CODE = 0;
	public static final int PLAYER1_CODE = 1;
	public static final int PLAYER2_CODE = 2;
	
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
			
			analizeGameBoard(board, i+1, n, nLines, nColumns);
		}
		fileReader.close();
		in.close();
	}
	
	private static void analizeGameBoard(char[][] chars, int numGames, int n, int nLines, int nColumns) {
		int r;
		
		
		
		int row1 = 1;
		int row2 = 1;
		int col1 = 1;
		int col2 = 1;
		
		boolean p1 = false;
		boolean p2 = false;
		
		int vfinal = 0;
		
		
		for (int h = 0; h < nLines; h++) {
			for (int i = 0; i < nColumns - 1; i++) {
				if((chars[h][i] == 'o') && (chars[h][i + 1] == 'o')) &&  {
					row1++;
				} else row1 = 1;
				
				if((chars[h][i] == 'x') && (chars[h][i + 1] == 'x')) {
					row2++;
				} else row2 = 1;
				
				if(row1 >= n) {
					p1 = true;
				}
				if (row2 >= n) {
					p2 = true;
				}
			} 
			
			row1 = 1;
			row2 = 1;
		}
		
		for (int j = 0; j < nColumns; j++) {
			for (int k = 0; k < nLines - 1; k++) {
				if((chars[k][j] == 'o') && (chars[k + 1][j] == 'o')) {
					col1++; 
				} else col1 = 1;
				if ((chars[k][j] == 'x') && (chars[k + 1][j] == 'x')) {
					col2++;
				} else col2 = 1;
				
				if (col1 >= n) {
					p1 = true;
				}
				if (col2 >= n) {
					p2 = true;
				}
			}
			
		 col1 = 1;
		 col2 = 1;
		}
		
		col1 = 1;
		col2 = 1;
		
		for (int i = 0; i < nLines; i++) {
			for (int j = 0; j < nColumns - 1; j++) {
				int l = i;
				int c = (nColumns - 1) - j;
				if (c < l) {
					r = c;
				} else if (c > 1) {
					r = l; 
				} else {
					r = l;
				}
				for (int k = 0; k < r; k++) {
					if (((chars[i - k][j + k] == 'o') && (chars[i - k - 1][j + k + 1] == 'o')) && (col1 + 1 < n)) {
						col1++;
					} else if (((chars[i - k][j + k] == 'o') && (chars[i - k - 1][j + k + 1] == 'o')) && (col1 + 1 < n)){
						p1 = true;
					} else {
						col1 = 1 ;
					}
					if (((chars[i - k][j + k] == 'x') && (chars[i - k - 1][j + k + 1] == 'x')) && (col2 + 1 < n)) {
						col2++;
					} else if (((chars[i + k][j + k] == 'x') && (chars[i + k + 1][j + k + 1] == 'x')) && (col2 + 1 >= n)) {
						p2 = true;
					} else {
						col2 = 1;
					} 
				}
				col1 = 1;
				col2 = 1;
			}
			col1 = 1;
			col2 = 1;
		}
		col1 = 1;
		col2 = 1;
		
		for (int i = 0; i < nLines; i++) {
			for (int j = 0; j < nColumns - 1; j++) {
				int l = i;
				int c = (nColumns - 1) - j;
				if (c < l) {
					r = c;
				} else if (c > 1) {
					r = l; 
				} else {
					r = l;
				}
				for (int k = 0; k < r; k++) {
					if (((chars[i - k][j + k] == 'o') && (chars[i - k - 1][j + k + 1] == 'o')) && (col1 + 1 < n)) {
						col1++;
					} else if (((chars[i - k][j + k] == 'o') && (chars[i - k - 1][j + k + 1] == 'o')) && (col1 + 1 < n)){
						p1 = true;
					} else {
						col1 = 1 ;
					}
					if (((chars[i - k][j + k] == 'x') && (chars[i - k - 1][j + k + 1] == 'x')) && (col2 + 1 < n)) {
						col2++;
					} else if (((chars[i + k][j + k] == 'x') && (chars[i + k + 1][j + k + 1] == 'x')) && (col2 + 1 >= n)) {
						p2 = true;
					} else {
						col2 = 1;
					} 
				}
				col1 =1;
				col2 = 1;
			}
		}	
		
		
		
		if((p1) && (p2)) {
			vfinal = 0;
		} else if ((p1) && (!p2)) {
			vfinal = 1;
		} else if ((!p1) && (p2)) {
			vfinal = 2;
		} 
		
	
		
		

	
	
		if(vfinal == 0) {
			System.out.printf(TIE, numGames);
		} 
		if (vfinal == 1) {
			System.out.printf(P1_WINS, numGames);
			}
		if (vfinal == 2 ){
		System.out.printf(P2_WINS, numGames);
	}	
	}
}























