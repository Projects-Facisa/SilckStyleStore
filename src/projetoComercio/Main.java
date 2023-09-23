package projetoComercio;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Methods operation = new Methods();
           
        int option = 0;
        System.out.println("                      [--- 🔥 WELCOME TO BYTEBLAZE STORE 🔥 ---]");
        operation.Loading();
        while (option != 6) {
            System.out.println("                                 [--- MAIN MENU ---]\n");
            System.out.println("(1) List All (2) Register Product (3) Add Stock (4) Remove Product (5) Sell Product (6) Exit");
            option = Integer.parseInt(sc.nextLine());
            int productStock;
            int productCode;

            switch (option) {
                case 1:
                	operation.Loading();
                    operation.List();
                    break;
                case 2:
                	System.out.println("Enter the product name:");
                    String productName = sc.nextLine();
                    
                    System.out.println("Enter the product style:");
                    String productStyle = sc.nextLine();
                    
                    System.out.println("Enter the product size:");
                    String productSize = sc.nextLine();
                    
                    System.out.println("Enter the product color:");
                    String productColor = sc.nextLine();
                    
                    System.out.println("Enter the product material:");
                    String productMaterial = sc.nextLine();
                    
                    Products newProduct = new Products(productName, productStyle, productSize, productColor, productMaterial);
                    
                    System.out.println("Enter the product Category:");
                    System.out.println("1) Chest, 2) Legs, 3) Feet");
                    int productCategory = Integer.parseInt(sc.nextLine());
                    
                    switch (productCategory) {
                    	case 1:
                    		System.out.println("Enter the cleavage type:");
                            String productCleavage = sc.nextLine();
                            
                            System.out.println("Enter the sleeve type:");
                            String productSleeve = sc.nextLine();
                            
                    		newProduct = new Chest(productName, productStyle, productSize, productColor, productMaterial, productCleavage, productSleeve);
                    		break;
                    	case 2:
                    		System.out.println("Enter the waist:");
                            String productWaist = sc.nextLine();
                            
                            System.out.println("Enter the length:");
                            String productLength = sc.nextLine();
                                         
                            newProduct = new Legs(productName, productStyle, productSize, productColor, productMaterial, productWaist, productLength);
                    		break;
                    	case 3:
                    		System.out.println("Enter the closure type:");
                            String productClosure = sc.nextLine();
                            
                            System.out.println("Enter the heel size:");
                            String productHeelSize = sc.nextLine();
                            
                            System.out.println("Enter the sole type:");
                            String productSoleType = sc.nextLine();
                    		
                            newProduct = new Feet(productName, productStyle, productSize, productColor, productMaterial, productClosure, productHeelSize, productSoleType);
                    		break;
                    	default:
                            System.out.println("Invalid Option, please try again ❌");
                            break;
                    } 
                    
                    productCode = newProduct.getCode();
                    operation.registerProduct(newProduct);
                    newProduct = operation.products.get(operation.products.size() - 1);

                    System.out.println("Do you want to add stock?\n(1) Yes (2) No");
                    int optionStock = Integer.parseInt(sc.nextLine());

                    if (optionStock == 1) {
                        System.out.println("Enter the stock quantity:");
                        productStock = Integer.parseInt(sc.nextLine());
                        if (productStock < 0) {
                            System.out.println("It was not possible to add the product because the stock entered is negative ❌");
                        } 
                        else {
                            operation.addStock(productStock, productCode);
                            System.out.print(newProduct.getName() + " added successfully.");
                            System.out.println(" code: " + newProduct.getCode() + ", " + "stock: " + newProduct.getStockQuantity() + "\n");
                        }
                    } 
                    else {
                        System.out.print(newProduct.getName() + " added successfully.");
                        System.out.println(" code: " + newProduct.getCode() + ", " + "stock: " + newProduct.getStockQuantity() + "\n");
                    }
                    break;
                case 3:
                    System.out.print("Enter the product code: ");
                    productCode = Integer.parseInt(sc.nextLine());

                    if (operation.locatePerCode(productCode) == null) {
                        System.out.println("The code entered does not exist ❌");
                        System.out.println("Returning...");
                    } else {
                        System.out.print("Enter the stock quantity: ");
                        productStock = Integer.parseInt(sc.nextLine());

                        operation.addStock(productStock, productCode); //
                        System.out.println("Stock added successfully ✔️");
                    }
                    break;
                case 4:
                    System.out.print("Enter the product code: ");
                    productCode = Integer.parseInt(sc.nextLine());

                    if (operation.locatePerCode(productCode) == null) {
                    	System.out.println("The code entered does not exist ❌");
                    	System.out.println("Returning...");
                    }
                    else {
	                    if (operation.locatePerCode(productCode).getStockQuantity() == 0) {
                            System.out.println("Product removed successfully ✔️");
                            operation.deleteProduct(productCode);
	                    }
	                    else {
	                        System.out.println("There's still stock of this product in the market");
	                        System.out.println("(1) Remove anyway (2) Cancel operation");
	                        int optionRemove = Integer.parseInt(sc.nextLine());

	                        if (optionRemove == 1) {
                                System.out.println("Product removed successfully ✔️");
                                operation.deleteProduct(productCode);
	                        }
	                        else {
	                        	System.out.println("Operation Cancelled ❌");
	                            System.out.println("Returning...");
	                        	}
	                    	}
                    	}
                    break;
                case 5:
                    System.out.print("Enter the product code: ");
                    productCode = Integer.parseInt(sc.nextLine());

                    if (operation.locatePerCode(productCode) == null) {
                    	System.out.println("The code entered does not exist ❌");
                    	System.out.println("Returning...");
                    }
                    else {
	                    System.out.print("Enter the quantity to be sold: ");
	                    productStock = Integer.parseInt(sc.nextLine());

	                    if (operation.locatePerCode(productCode).getStockQuantity() - productStock < 0) {
	                        System.out.println("Not Enough Stock to sell ❌");
	                        System.out.println("Returning...");
	                    }
	                    else {
                            System.out.println("Product sold successfully ✔️");
                            operation.removeStock(productStock, productCode);
	                    }
                    }
                    break;
                case 6:
                    System.out.println("Exiting ByteBlazeStore, Thank You!");
                    break;
                default:
                    System.out.println("Invalid Option, please try again ❌");
                    break;
            }
        }
        sc.close();
    }
}