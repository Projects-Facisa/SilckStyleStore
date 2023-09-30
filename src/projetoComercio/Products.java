package projetoComercio;

import java.util.ArrayList;


public class Products {
		protected static int lastCode = 0 ;
		protected int code;
		protected String name;
		protected int stockQuantity;
		protected String category;
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

	public String getCategory() {
		return category;
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

	public Products(){}
	public Products(int code, String name, String style, String size, String color, String material,String category, int stockQuantity) {
		this.name = name + "," + style + "," + color + "," + size + "," + material + "," + category;
        this.style = style;
        this.size = size;
        this.color = color;
        this.material = material;
		this.stockQuantity = stockQuantity;
		this.category = category;

		}
	public String saveFileString() {
		return code+","+name+","+stockQuantity;
	}
	public String toString(){
		return name +
				" (code.: " + code + " | stock: " + stockQuantity + " | category: " + category + " | buy price" + " | sell price";
	}
}
