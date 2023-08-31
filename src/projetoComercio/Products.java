package projetoComercio;

public class Products {
	
		public int code;
	
		public String name;
		
		public int stockQuantity;
	
		public int getCode() {
			return code;
		}
	
		public void setCode(int code) {
			this.code = code;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
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
