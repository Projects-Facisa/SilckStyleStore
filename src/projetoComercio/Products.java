package projetoComercio;

import java.util.ArrayList;


public class Products {
	
		public ArrayList<Products> products = new ArrayList<Products>();
		
		protected static int lastCode = 0 ;
		protected int code;
		private String name;
		private int stockQuantity;
		
		private String style;
		private String size;
		private String color;
		private String material;
		
		//private int costOfSale; Ambos os atributos ainda serão trabalhados. 
		//private int costOfPurchase;
		
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
	public String getStyle() {
		return style;
	}
	
	public String getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

	public String getMaterial() {
		return material;
	}
	
	 public Products(String productName, String style, String size, String color, String material) {
        this.name = productName;
        this.stockQuantity = 0;
        
        this.style = style;
        this.size = size;
        this.color = color;
        this.material = material;
    }	
}
