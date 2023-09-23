package projetoComercio;

public class Products {
		private static int lastCode = 0 ;
	
		private int code;
	
		private String name;
		
		private int stockQuantity;

	public Products(String productName) {
		this.name = productName;
		lastCode++;
		this.code = lastCode;
		this.stockQuantity = 0;
		}

    public int getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

		public int getStockQuantity() {
			return stockQuantity;
		}
	
		public void addStockPerCode(int stockQuantity) {
			this.stockQuantity += stockQuantity;	
		}
		public void removeStockPerCode(int stockQuantity) {
			this.stockQuantity -= stockQuantity;
		}
}
