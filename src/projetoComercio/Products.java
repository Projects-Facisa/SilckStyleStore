package projetoComercio;

public class Products {
	
		public int code;
	
		public String name;
		
		public int stockQuantity;

    public Products(String productName, int productCode) {
		this.name = productName;
		this.code = productCode;
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
