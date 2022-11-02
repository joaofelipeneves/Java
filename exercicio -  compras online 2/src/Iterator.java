public class Iterator {
	private dataItems[] items;
	
	public Iterator(dataItems[] items) {
		this.items = items;
	}
	
	public void setItems() {
		int i ;
		int j ;
		dataItems pos;
		boolean changepos;
		
		
		for (i = 0; i < items.length - 1; i++) {
			changepos = true;
			for (j = 0; j < items.length - i - 1; j++) {
				if(items[j] != null & items[j + 1] != null) {
					if(items[j].getPrices() < items[j + 1].getPrices()) {
						pos = items[j];
						items[j] = items[j + 1];
						items[j + 1] = pos;
						changepos = true;
					}
					
					if(items[j].getPrices() == items[j + 1].getPrices()) {
						if (items[j].getNames().compareTo(items[j + 1].getNames()) >= 0) {
							pos = items[j];
							items[j] = items[j + 1];
							items[j + 1] = pos;
							changepos = true;
						}
					}
				}
			}
			if (!changepos)
				break;
		}
	}	
}