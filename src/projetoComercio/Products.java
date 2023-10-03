package projetoComercio;

public class Products {
        protected int code;
        protected String name;
        protected int stockQuantity;
        protected String category;
        private String style;
        private String size;
        private String color;
        private String material;
        protected double productCost;
        protected double saleValue;

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
    public double getProductCost() {
        return productCost;
    }
    public double getSaleValue() {
        return saleValue;
    }

    public Products(int code, String name, String style, String size, String color, String material, String category, int stockQuantity, double productCost, double saleValue) {
        this.code = code;
        this.name = name + "," + style + "," + color + "," + size + "," + material;
        this.style = style;
        this.size = size;
        this.color = color;
        this.material = material;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.productCost = productCost;
        this.saleValue = saleValue;

        }
    public String saveFileString() {
        return code+","+name+","+category+","+stockQuantity+","+productCost+","+saleValue;
    }
    public String toStringProduct(){
        return name +
                " (code.: " + code + " | stock: " + stockQuantity + " | category: " + category + " | product cost: " + productCost + " | sale value: " + saleValue;
    }
}