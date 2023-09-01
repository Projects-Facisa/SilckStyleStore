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
		Products newProduct = new Products();
		newProduct.setName(productName);
		newProduct.setCode(productCode);
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
}