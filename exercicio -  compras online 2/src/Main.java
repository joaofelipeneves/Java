import java.util.Scanner;  

public class Main{                                                                                                                   
	public static void main(String[] args) {                                                                                         
		                                                                                                                             
		Scanner in = new Scanner(System.in); 
		
		int count = 0;
		int itemsNum = in.nextInt();  
		int[] itemsPrices = new int [itemsNum];
		String[] itemsNames = new String[itemsNum];   
		    
                                                                                                                             
		do {                                                                                                                         
			for (int i=0; i != itemsNum; i++){                                                                                       
				itemsPrices[i] = in.nextInt();                                                                                            
				in.nextLine();             
				itemsNames[i] = in.nextLine();                                                                                
				count++;                                                                                                             
			}                                                                                                                        
		} while (count != itemsNum);         
		
		
		int Saldo = in.nextInt();
		                                                                                                                                                                                                                             
		ShppSystem ss = new ShppSystem(itemsNum, itemsPrices, itemsNames, Saldo);                                                      
		ss.Buy();  
		
		for (int i = 0; i != itemsNum ; i++) {
			if (ss.itemsNames(i) != null) {
				System.out.println(ss.itemsNames(i));
			} 
		}
		
		
		System.out.println(ss.SpentMoney() + " " + ss.getSaldo());
		in.close();                                                                                                                             
	}   
}                                                                                                                                    