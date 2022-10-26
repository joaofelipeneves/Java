public class Ticket {
	private int age; 
	private boolean isFirstYear;
	public Ticket (int age, boolean isFirstYear) {this.age = age;  this.isFirstYear = isFirstYear;}
public int getPriceWith(Ticket ticket2) {
	
int valor = 20 ;
int x = 0 ;
	
	if (age > 65 | ticket2.age > 65) {
		    valor = (valor / 2);
	}
	if (age < 5 && isFirstYear == false) { 
			x = (valor - valor) ;
			return x ;};
	if (age < 65  && isFirstYear == true ) { 
			x = (valor * 8 / 10) ;
			return x ;};
	if (age < 65  && isFirstYear == false ) { 
			x = (valor) ;
			return x ;};
			
	if (age > 5 && isFirstYear == true) {
		    valor = (valor  * 8 / 10); 
	}

	return valor; 
}
}