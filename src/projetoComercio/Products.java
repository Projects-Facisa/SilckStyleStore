package projetoComercio;

import java.util.ArrayList;


public class Products {
		protected static int lastCode = 0 ;
		protected int code;
		private String name;
		private int stockQuantity;
		private String category;
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
	
	
	public void setCode(int code) {
		this.code = code;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
		
	
	 public Products(String name, String style, String size, String color, String material,int category, int stockQuantity) {
        this.name = name + "," + style + "," + color + "," + size + "," + material;
        this.style = style;
        this.size = size;
        this.color = color;
        this.material = material;
		this.stockQuantity = stockQuantity;
		switch (category) {
			case 1 -> this.category = "chest";
			case 2 -> this.category = "legs";
			case 3 -> this.category = "feet";
		}
    }
	@Override
	public String toString() {
		return name +
				" (code.: " + code + " | stock: " + stockQuantity + " | category: " + category + " | buy price" + " | sell price";
	}
}
