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
	
	public Legs(String name, String style, String size, String color, String material, String waist, String length) {
		super(name, style, size, color, material);
		this.waist = waist;
		this.length = length;
		code = ++lastCode;
	}
}