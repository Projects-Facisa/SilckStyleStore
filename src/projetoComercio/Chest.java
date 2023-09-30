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
	public Chest(){}
	public Chest(int code, String name, String style, String size, String color, String material, String category, int stockQuantity, String cleavageType, String sleeveType) {
		super(code, name, style, size, color, material, category, stockQuantity);
		this.cleavageType = cleavageType;
		this.sleeveType = sleeveType;
		this.code = ++lastCode;
	}
	@Override
	public String toString() {
		return name +
				" (code.: " + code + " | stock: " + stockQuantity + " | category attributes: " + " | cleavage type: " + cleavageType + " | sleeve type: " + sleeveType + " | buy price" + " | sell price";
	}
	@Override
	public String saveFileString() {
		return code+","+name+","+stockQuantity+","+cleavageType+","+sleeveType;
	}
}