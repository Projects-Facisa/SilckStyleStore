package projetoComercio;

public class Legs extends Products {

    private String waist;
    private String length;

    public Legs(int code, String name, String style, String size, String color, String material, String category, int stockQuantity, double productCost, double saleValue, String waist, String length) {
        super(code, name, style, size, color, material, category, stockQuantity, productCost, saleValue);
        this.waist = waist;
        this.length = length;
    }
    @Override
    public String toString() {
        return name +
                " (code.: " + code + " | stock: " + stockQuantity + " | category attributes ->" + " waist: " + waist + ", lenght: " + length + " | product cost: " + productCost + " | sale value:" + saleValue;
    }
    @Override
    public String saveFileString() {
        return code+","+name+","+category+","+stockQuantity+","+productCost+","+saleValue+","+waist+","+length;
    }
}