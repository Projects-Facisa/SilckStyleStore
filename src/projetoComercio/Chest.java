package projetoComercio;

public class Chest extends Products {

    private String cleavageType; // Tipo de decote
    private String sleeveType; // Tipo de manga

    public Chest(int code, String name, String style, String size, String color, String material, String category, int stockQuantity, double productCost, double saleValue, String cleavageType, String sleeveType) {
        super(code, name, style, size, color, material, category, stockQuantity, productCost, saleValue);
        this.cleavageType = cleavageType;
        this.sleeveType = sleeveType;
    }
    @Override
    public String toString() {
        return name +
                " (code.: " + code + " | stock: " + stockQuantity + " | category attributes ->" + " cleavage type: " + cleavageType + ", sleeve type: " + sleeveType + " | product cost: " + productCost + " | sale value:" + saleValue;
    }
    @Override
    public String saveFileString() {
        return code+","+name+","+category+","+stockQuantity+","+productCost+","+saleValue+","+cleavageType+","+sleeveType;
    }
}