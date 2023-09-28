package projetoComercio;

public class Legs extends Products {
	
	private String waist;
	private String length;
	
	public String getWaist() {
		return waist;
	}
	public String getLength() {
		return length;
	}
	
	public Legs(String name, String style, String size, String color, String material, int category, int stockQuantity, String waist, String length) {
		super(name, style, size, color, material, category, stockQuantity);
		this.waist = waist;
		this.length = length;
		code = ++lastCode;
	}
}