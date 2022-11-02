public class ShppSystem {

	private int Names;
	private int[] itemsPrices;
	private String[] itemsNames;
	private int Saldo;
	private int initSaldo;
	private dataItems[] items;

	public ShppSystem(int Names, int[] itemsPrices, String[] itemsNames, int Saldo) {
		this.Names = Names;
		this.itemsPrices = itemsPrices;
		this.itemsNames = itemsNames;
		this.Saldo = Saldo;
		this.initSaldo = Saldo;
		this.items = new dataItems[Names];
		

	}
	
	private void setItems() {
		for (int i = 0; i != Names; i++) {
			items[i] = new dataItems(itemsPrices[i], itemsNames[i]);
		}
	}
	
	
	private boolean canBuy(int position) {
		return initSaldo - items[position].getPrices() >= 0;
	}

	public void Buy() {
		setItems();
		for (int i = 0; i != Names; i++) {
			if (canBuy(i)) {
				initSaldo = initSaldo - items[i].getPrices();
			} else {
				items[i] = null;
			}
		}
		
		Iterator it = new Iterator(items);
		it.setItems();
	}
	
	

	public int getSaldo() {
		return initSaldo;
	}
	
	public int SpentMoney() {
		return Saldo - initSaldo;
	}	
	
	
	public String itemsNames(int i) {
		if (items[i] != null) {
			return items[i].getNames();
		} else {
			return null;
		}
		
	}	
}