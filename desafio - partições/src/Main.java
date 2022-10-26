import java.util.Scanner;

 public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		int n = scan.nextInt() ; 
		int m = scan.nextInt();
		System.out.println(getPartitions(n, m));
		scan.close();
	} 
	
	public static int getPartitions(int n, int m) {
		int parts = 0; 
		
		if(n == 0 && m >= 0)      { parts = 1; }	
		if(n > 0 && m == 0)       { parts = 0; }
		if(n < m && m > 0)        { parts = getPartitions(n, m -1);}
		if (n >= m && m > 0)      { parts = getPartitions(n - m , m ) + getPartitions(n, m - 1);}
		
		return parts ;
	}
} 