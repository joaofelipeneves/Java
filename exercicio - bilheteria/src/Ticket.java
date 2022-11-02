public class Ticket {
	private int age; 
	private boolean isFirstYear;
	public Ticket (int age, boolean isFirstYear) {this.age = age;   this.isFirstYear = isFirstYear;}
public int getPrice() {
	int x = 0 ;
	int valor = 20;

		
		
		 if (age > 65 && isFirstYear == false) { 
			x = (valor / 2) ;
			return x ;};
		 
		 if (age > 65 && isFirstYear == true) {
			 x = (valor - 12);
			 return x ;
		 };
		 
		 if (age < 5  && isFirstYear == true ) { 
			x = (valor * 8 / 10) ;
			return x ;};
		 if (age < 5 && isFirstYear == false) { 
					x = (valor - valor) ;
					return x ;};
		
		 if (isFirstYear == true) {
			x = (valor - 4);
			
			return x ;
		};
		 if (isFirstYear == false) {
			x = (valor);
			
			return x ;
		};
		return valor;}}
