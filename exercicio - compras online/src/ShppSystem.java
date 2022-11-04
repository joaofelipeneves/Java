public class ShppSystem {

	private int itemsNum;
	private int[] prices;
	private String[] itemsNames;
	private int Saldo;
	private int initSaldo;
	private String maisCaro = " ";
	private int maiorPreco = 0;

	public ShppSystem(int itemsNum, int[] prices, String[] itemsNames, int initSaldo) {
		this.itemsNum = itemsNum;
		this.prices = prices;
		this.itemsNames = itemsNames;
		this.initSaldo = initSaldo;
		this.Saldo = initSaldo;

	}
	private boolean canBuy(int position) {
		return Saldo - prices[position] >= 0;
	}

	public void Buy() {
		for (int i = 0; i != itemsNum; i++) {
			if (canBuy(i)) {
				Saldo -= prices[i];
				if (prices[i] > this.maiorPreco) {
					this.maiorPreco = prices[i];
					this.maisCaro = itemsNames[i];
				}
			}
		}
	}

	public int getSaldo() {
		return Saldo;
	}
	
	public int SpentMoney() {
		return -(Saldo - initSaldo);
	}	

	public String getMaisCaro() {
		return maisCaro;
	}	
}