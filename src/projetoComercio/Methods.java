package projetoComercio;

import java.util.ArrayList;

public class Methods {
	ArrayList<Products> products = new ArrayList<Products>();

	public void List() {
		if (products.isEmpty()) {
			System.out.println("\nNo Product Registered Yet!!\n");
		}
		int counter = 0;
		for (Products product : products) {
			counter += 1;
			System.out.println((counter + ") " + product.getName() + " (code.: " + product.getCode() + " | " + "stock: " + product.getStockQuantity() +")" + "\n"));
		}
	}
	public void registerProduct(String productName, int productCode, int productStock) {
		Products newProduct = new Products(productName,productCode);
		products.add(newProduct);
		addStock(productStock, productCode);

	}
	public void addStock(int productStock, int productCode) {
		Products product = locatePerCode(productCode);
		product.addStockPerCode(productStock);
	}


	public Products locatePerCode(int productCode) {
		for (Products product : products) {
			if (product.getCode() == productCode) {
				return product;
			}
		}
		return null;
	}

	public void deleteProduct(int productCode) {
		Products product = locatePerCode(productCode);
		products.remove(product);

	}
	public void removeStock(int productStock, int productCode) {
		Products product = locatePerCode(productCode);
		product.removeStockPerCode(productStock);
	}
    public void Loading() {
    	System.out.println("Loading...");
        LoadingDelay(1500);
        System.out.println("Loading complete ✔️");
    }
    private void LoadingDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Error during loading" + e.getMessage());
        }
    }
 }
