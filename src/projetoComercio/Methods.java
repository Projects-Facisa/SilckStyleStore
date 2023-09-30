package projetoComercio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
    public ArrayList<Products> products = new ArrayList<Products>();

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void ListAll() {
        if (products.isEmpty()) {
            System.out.println("\nNo Product Registered Yet!!\n");
        }

        for (Products product : products) {
            System.out.println(product);
        }
    }
    public void ListChest() {
        if (products.isEmpty()) {
            System.out.println("\nNo Product Registered Yet!!\n");
        }
        for (Products product : products) {
            if (product.getCategory().equals("Chest")){
                System.out.println(product);  //Ainda não está usando o toString da Subclasse
            }
        }
    }
    public void ListLegs() {
        if (products.isEmpty()) {
            System.out.println("\nNo Product Registered Yet!!\n");
        }

        for (Products product : products) {
            if (product.getCategory().equals("Legs")){
                System.out.println(product);  //Ainda não está usando o toString da Subclasse
            }
        }
    }
    public void ListFeet() {
        if (products.isEmpty()) {
            System.out.println("\nNo Product Registered Yet!!\n");
        }
        for (Products product : products) {
            if (product.getCategory().equals("Feet")){
                System.out.println(product);  //Ainda não está usando o toString da Subclasse
            }
        }
    }

    public void registerProduct(Products product) {
        products.add(product);
    }

    public void addStock(int productStock, int productCode) {
        Products product = locatePerCode(productCode);
        if (product != null) {
            product.addStockPerCode(productStock);
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

    public void saveProductsToFile(ArrayList<Products> products) {
        try (PrintWriter writer = new PrintWriter("arquivo.txt")) {
            for (Products product : products) {
            	writer.write(product.saveFileString()+"\n");
            }
			writer.close();
            System.out.println("Products saved to " + "arquivo.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + "arquivo.txt");
        }
    }

    public void carregaArray() { //Talvez o
		ArrayList<Products> tempArray = new ArrayList<Products>();
		File file = new File("arquivo.txt");
			try {
				Scanner scan = new Scanner(file);
				while (scan.hasNextLine()) {
					String[] productsArray = scan.nextLine().split(",");
                    Products product = new Products(Integer.parseInt(productsArray[0]),productsArray[1], productsArray[2], productsArray[3], productsArray[4], productsArray[5], productsArray[6], Integer.parseInt(productsArray[7]));
                    switch (productsArray[6]) {
                        case "Chest":
                            product = new Chest(Integer.parseInt(productsArray[0]),productsArray[1], productsArray[2], productsArray[3], productsArray[4], productsArray[5], productsArray[6], Integer.parseInt(productsArray[7]), productsArray[8], productsArray[9]);
                            tempArray.add(product);
                            break;
                        case "Legs":
                            product = new Legs(Integer.parseInt(productsArray[0]),productsArray[1], productsArray[2], productsArray[3], productsArray[4], productsArray[5], productsArray[6], Integer.parseInt(productsArray[7]), productsArray[8], productsArray[9]);
                            tempArray.add(product);
                            break;
                        case "Feet":
                            product = new Feet(Integer.parseInt(productsArray[0]),productsArray[1], productsArray[2], productsArray[3], productsArray[4], productsArray[5], productsArray[6], Integer.parseInt(productsArray[7]), productsArray[8], productsArray[9], productsArray[10]);
                            tempArray.add(product);
                            break;
                    }                  
				}
				scan.close();
			}
            catch (FileNotFoundException e) {
            	System.out.println("File not found: " + "arquivo.txt");	
			}
		products = tempArray;
	}}