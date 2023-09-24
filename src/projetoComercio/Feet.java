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

	public Feet(String name, String style, String size, String color, String material, int category, String closureType, String heelSize, String soleType) {
		super(name, style, size, color, material, category);
		this.closureType = closureType;
		this.heelSize = heelSize;
		this.soleType = soleType;
		code = ++lastCode;
	}
}