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
	public Legs(){}
	public Legs(int code, String name, String style, String size, String color, String material, String category, int stockQuantity, String waist, String length) {
		super(code, name, style, size, color, material, category, stockQuantity);
		this.waist = waist;
		this.length = length;
		this.code = ++lastCode;
	}
	@Override
	public String toString() {
		return name +
				" (code.: " + code + " | stock: " + stockQuantity + " | category attributes: " + " | waist: " + waist + " | lenght: " + length + " | buy price" + " | sell price";
	}
	@Override
	public String saveFileString() {
		return code+","+name+","+stockQuantity+","+waist+","+length;
	}
}