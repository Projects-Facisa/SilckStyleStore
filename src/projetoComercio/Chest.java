package projetoComercio;

public class Chest extends Products {
	
	private String cleavageType; // Tipo de decote
	private String sleeveType; // Tipo de manga
	
	public String getCleavageType() {
		return cleavageType;
	}
	public String getSleeveType() {
		return sleeveType;
	}
	
	public Chest(String name, String style, String size, String color, String material, int category, String cleavageType, String sleeveType) {
		super(name, style, size, color, material, category);
		
		this.cleavageType = cleavageType;
		this.sleeveType = sleeveType;
		code = ++lastCode;
	}
}