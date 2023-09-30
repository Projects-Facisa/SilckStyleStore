package projetoComercio;

public class Feet extends Products{
	
	private String closureType;
	private String heelSize;
	private String soleType;
	
	public String getClosureType() {
		return closureType;
	}

	public String getHeelSize() {
		return heelSize;
	}

	public String getSoleType() {
		return soleType;
	}
	
	public Feet(int code, String name, String style, String size, String color, String material, String category, int stockQuantity, String closureType, String heelSize, String soleType) {
		super(code, name, style, size, color, material, category, stockQuantity);
		this.closureType = closureType;
		this.heelSize = heelSize;
		this.soleType = soleType;
	}
	@Override
	public String toString() {
		return name +
				" (code.: " + code + " | stock: " + stockQuantity + " | category attributes: " + " | closure: " + closureType + " | heel: " + heelSize + " | sole: " + soleType + " | buy price" + " | sell price";
	}
	@Override
	public String saveFileString() {
		return code+","+name+","+stockQuantity+","+closureType+","+heelSize+","+soleType;
	}
}