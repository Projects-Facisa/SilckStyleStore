package projetoComercio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Methods {

    private double floatingCapital = 0;

    public double getFloatingCapital() {
        return floatingCapital;
    }

    public void buyWithFloatingCapital(double buyValue) {
        floatingCapital -= buyValue;
    }
    public void sellWithFloatingCapital(double sellValue) {
        floatingCapital += sellValue;
    }

    public ArrayList<Products> products = new ArrayList<Products>();

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void ListAll() {
        if (products.isEmpty()) {
            System.out.println("\nNo product registered yet!!");
        } else {
            Loading();
            System.out.println("Floating Capital:" + floatingCapital);
            for (Products product : products) {
                System.out.println(product.toStringProduct());
            }
        }
    }
    public void ListPerCategory(String category) {
        boolean productInCategory = false;
        for (Products product : products) {
            if (product.getCategory().equals(category)) {
                productInCategory = true;
                break;
            }
        }
        if (!productInCategory) {
            System.out.println("\nNo product registered in this category yet!!");
        } else {
            Loading();
            for (Products product : products) {
                if (product.getCategory().equals(category)) {
                    System.out.println(product);
                }
            }
        }
    }
    public void registerProduct(Products product) {
        products.add(product);
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
    
    public int calculateTotalStock() {
        int totalStock = 0;
        for (Products product : products) {
            totalStock += product.getStockQuantity();
        }
        return totalStock;
    }
    

    public void SaveProductsToFile(ArrayList<Products> products) {
        try (PrintWriter writer = new PrintWriter("fileArray.txt")) {
            for (Products product : products) {
            	writer.write(product.saveFileString()+"\n");
            }
			writer.close();
            System.out.println("Products saved to " + "fileArray.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + "fileArray.txt");
        }
    }

    public void LoadProductArrayFile() { //Talvez o
		ArrayList<Products> tempArray = new ArrayList<Products>();
		File file = new File("fileArray.txt");
			try {
				Scanner scan = new Scanner(file);
				while (scan.hasNextLine()) {
					String[] productsArray = scan.nextLine().split(",");
                    Products product = new Products(Integer.parseInt(productsArray[0]),productsArray[1], productsArray[2], productsArray[3], productsArray[4], productsArray[5], productsArray[6], Integer.parseInt(productsArray[7]), Double.parseDouble(productsArray[8]), Double.parseDouble(productsArray[9]));
                    switch (productsArray[6]) {
                        case "Chest":
                            product = new Chest(Integer.parseInt(productsArray[0]),productsArray[1], productsArray[2], productsArray[3], productsArray[4], productsArray[5], productsArray[6], Integer.parseInt(productsArray[7]), Double.parseDouble(productsArray[8]), Double.parseDouble(productsArray[9]), productsArray[10], productsArray[11]);
                            break;
                        case "Legs":
                            product = new Legs(Integer.parseInt(productsArray[0]),productsArray[1], productsArray[2], productsArray[3], productsArray[4], productsArray[5], productsArray[6], Integer.parseInt(productsArray[7]), Double.parseDouble(productsArray[8]), Double.parseDouble(productsArray[9]), productsArray[10], productsArray[11]);
                            break;
                        case "Feet":
                            product = new Feet(Integer.parseInt(productsArray[0]),productsArray[1], productsArray[2], productsArray[3], productsArray[4], productsArray[5], productsArray[6], Integer.parseInt(productsArray[7]), Double.parseDouble(productsArray[8]), Double.parseDouble(productsArray[9]), productsArray[10], productsArray[11], productsArray[12]);
                            break;
                    }
                    tempArray.add(product);
				}
				scan.close();
			}
            catch (FileNotFoundException e) {
            	System.out.println("File not found: " + "fileArray.txt");
			}
		products = tempArray;
	}
    public void saveFloatingCapitalToFile() {
        try (PrintWriter writer = new PrintWriter("FileCashRegister.txt")) {
            writer.write(String.valueOf(floatingCapital));
        } catch (FileNotFoundException e) {
            System.out.println("Error saving Floating Capital: " + e.getMessage());
        }
    }
    public void loadFloatingCapitalFromFile() {
        try (Scanner scanner = new Scanner(new File("FileCashRegister.txt"))) {
            if (scanner.hasNextLine()) {
                String fileCapital = scanner.nextLine();
                floatingCapital = Double.parseDouble(fileCapital);
            } else {
                System.out.println("FileCashRegister.txt is empty or formatted incorrectly.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileCashRegister.txt not found. Floating Capital not loaded.");
        }
    }
    
    
}