import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int itemsNum = in.nextInt();
		int[] prices = new int [itemsNum];
		String[] itemsNames = new String[itemsNum];
		int count = 0;
		
		do {
			for (int i=0; i != itemsNum; i++){
				prices[i] = in.nextInt();
				in.nextLine();
				itemsNames[i] = in.nextLine().trim();
				count++;
			}
		} while (count != itemsNum);
		
		int initSaldo = in.nextInt();
		ShppSystem ss = new ShppSystem(itemsNum, prices, itemsNames,initSaldo);
		ss.Buy();
		
		if (ss.SpentMoney() == 0) {
			System.out.print(ss.SpentMoney());
			System.out.println(" " + ss.getSaldo());
		} else {
			System.out.println(ss.getMaisCaro());
			System.out.print(ss.SpentMoney());
			System.out.println(" " + ss.getSaldo());
		}
			
		in.close();  
	}    
}