package projetoComercio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
    public ArrayList<Products> products = new ArrayList<Products>();

    public void ListAll() {
        if (products.isEmpty()) {
            System.out.println("\nNo Product Registered Yet!!\n");
        }
        int counter = 0;
        for (Products product : products) {
            counter += 1;
            System.out.println((counter + ") " + product));
        }
    }

    public void registerProduct(Products product) {
        products.add(product);
		saveProductsToFile(products);
    }

    public void addStock(int productStock, int productCode) {
        Products product = locatePerCode(productCode);
        if (product != null) {
            product.addStockPerCode(productStock);
			saveProductsToFile(products);
        } else {
            System.out.println("The code entered does not exist ❌");
        }
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
		saveProductsToFile(products);
    }

    public void removeStock(int productStock, int productCode) {
        Products product = locatePerCode(productCode);
        product.removeStockPerCode(productStock);
		saveProductsToFile(products);
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

    public void saveProductsToFile(ArrayList<Products> products) {
        try (PrintWriter writer = new PrintWriter("arquivo.txt")) {
            for (Products product : products) {
            	writer.write(product.getName()+","+product.getCode()+","+product.getStockQuantity()+"\n");
                
            }
			writer.close();
            System.out.println("Products saved to " + "arquivo.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + "arquivo.txt");
        }
    }

    public void carregaArray() {
		ArrayList<Products> tempArray = new ArrayList<Products>();
		File file = new File("arquivo.txt");
			try {
				Scanner scan = new Scanner(file);
				while (scan.hasNextLine()) {
					String[] productsArray = scan.nextLine().split(",");
					Products product = new Products(productsArray[0], productsArray[1], productsArray[2], productsArray[3], productsArray[4], Integer.parseInt(productsArray[5]), Integer.parseInt(productsArray[6]));
					tempArray.add(product);
					
														
				}
				scan.close();
			}
            catch (FileNotFoundException e) {
            	System.out.println("File not found: " + "arquivo.txt");	
			}
		products = tempArray;
	}	
}
                